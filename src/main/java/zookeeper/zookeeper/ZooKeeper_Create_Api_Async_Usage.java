package zookeeper.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZooKeeper_Create_Api_Async_Usage
 * @Author dianXiao2
 * @Date 2018/12/28 17:07
 * zookeeper api 创建节点， 医用异步（axync）接口
 **/
public class ZooKeeper_Create_Api_Async_Usage implements Watcher {

    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;
    private static CountDownLatch latch = new CountDownLatch(1);


    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(connectString,sessionTimeout,new ZooKeeper_Create_Api_Async_Usage());
        System.out.println(">> zookeeper.state:"+zooKeeper.getState());
        latch.await();
        System.out.println(">> ZooKeeper session established ...");

        zooKeeper.create("/test", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL, new IStringCallBack(), "I am context");
        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(">> received watched event:"+event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            latch.countDown();
        }
    }

    static class  IStringCallBack implements AsyncCallback.StringCallback{

        @Override
        public void processResult(int rc, String path, Object ctx, String name) {
            System.out.println(">> Create path result: ["+rc+","+path+","+ctx+",real path name: "+ name);
        }
    }
}
