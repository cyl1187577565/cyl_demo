package zookeeper.curator;

import com.alibaba.fastjson.JSON;
import com.mysql.jdbc.StringUtils;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName Create_Session_Sample
 * @Author dianXiao2
 * @Date 2018/12/29 11:42
 * 使用curator 客户端的sample
 **/
public class Create_Session_Sample {

    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;

    private static final CountDownLatch latch = new CountDownLatch(2);
    private static ExecutorService tp = Executors.newFixedThreadPool(2);


    public static void main(String[] args) throws Exception{
        int hours, mins, secs;

        String len="-26";
        if("" == len || len.length() <= 0){
            hours  = 0;
            mins = 0;
            secs = 0;
        }else{
            Integer lenInt = Integer.parseInt(len);
            boolean flag = true;
            if(lenInt <0){
                flag = false;
                len = String.valueOf(Math.abs(lenInt));
            }
            if (len.length() < 4) {
                len = "0000" + len;
            }
            if (!len.substring(0, len.length() - 4).equals("")) {
                hours = Integer.parseInt(len.substring(0, len.length() - 4));
                if(!flag){
                    hours = 0- hours;
                }
            }
            if (!len.substring(len.length() - 4, len.length() - 2).equals("")) {
                mins = Integer.parseInt(len.substring(len.length() - 4, len.length() - 2));
                if(!flag){
                    mins = 0- mins;
                }
            }
            secs = Integer.parseInt(len.substring(len.length() - 2, len.length()));
            if(!flag){
                secs = 0 - secs;
            }

        }

    }

    public static void sync() throws Exception{
        // 重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);

        //fluent 方式的创建
        CuratorFramework zk = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(sessionTimeout)
                .connectionTimeoutMs(3000)
                .retryPolicy(retryPolicy)
                .namespace("cyl")
                .build();
        zk.start();

        //创建节点
        String path = zk.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath("/test2/test2_1");
        System.out.println(">> 创建的节点："+ path);

        //读取数据
        zk.getData()
                .forPath("/test2");;

        //删除节点
        zk.delete()
                .forPath("/test2/test2_1");

        //递归删除节点
        zk.delete()
                .deletingChildrenIfNeeded()
                .forPath("/test2/test2_1");



        Thread.sleep(Integer.MAX_VALUE);
    }

    //异步接口调用
    public static void async() throws Exception{
        //
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework zk = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(sessionTimeout)
                .connectionTimeoutMs(3000)
                .retryPolicy(retryPolicy)
                .namespace("cyl2")
                .build();
        zk.start();
        System.out.println("<< Thread: " + Thread.currentThread().getName());

        //创建节点
        zk.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework zk, CuratorEvent event) throws Exception {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println(">> " + JSON.toJSONString(event));
                        System.out.println(">> Thread: "+Thread.currentThread().getName());
                        latch.countDown();
                    }
                },tp)
                .forPath("/test1","init".getBytes());

        //创建节点
        zk.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .inBackground(new BackgroundCallback() {
                    @Override
                    public void processResult(CuratorFramework zk, CuratorEvent event) throws Exception {
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                        System.out.println(">> " + JSON.toJSONString(event));
                        System.out.println(">> Thread: "+Thread.currentThread().getName());
                        latch.countDown();
                    }
                },tp)
                .forPath("/test2","init".getBytes());

        latch.await();
        tp.shutdown();

        System.out.println(">> 完成...");
        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 使用nodechache进行监听的实例
     */
    public static void nodeCache_sample() throws Exception{
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework zk = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(sessionTimeout)
                .connectionTimeoutMs(3000)
                .retryPolicy(retryPolicy)
                .namespace("cyl3")
                .build();
        zk.start();
        System.out.println(">> Thread: " + Thread.currentThread().getName());

        String path = "/test1/nodeCache";

        //注册监听器 nodeCache
        final NodeCache cache = new NodeCache(zk, path, false);
        cache.start();
        cache.getListenable()
                .addListener(new NodeCacheListener() {
                    @Override
                    public void nodeChanged() throws Exception {
                        System.out.println(">> Node data update ,new data :" + new String(cache.getCurrentData().getData()));
                    }
                });

        //创建节点
        zk.create()
                .creatingParentsIfNeeded()
                .withMode(CreateMode.EPHEMERAL)
                .forPath(path, "init".getBytes());


        //改变值
        zk.setData()
                .forPath(path, "u".getBytes());

        zk.setData()
                .forPath(path, "m".getBytes());

        zk.setData()
                .forPath(path, "y".getBytes());

        Thread.sleep(1000);

        zk.delete()
                .deletingChildrenIfNeeded()
                .forPath("/test1");

        Thread.sleep(Integer.MAX_VALUE);
    }

    /**
     * 子节点变更注册监听器
     */
    public static void pathChildrenCache_sample(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework zk = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .sessionTimeoutMs(sessionTimeout)
                .connectionTimeoutMs(3000)
                .retryPolicy(retryPolicy)
                .namespace("cyl4")
                .build();
        zk.start();
        System.out.println(">> Thread: " + Thread.currentThread().getName());
    }
}
