package zookeeper.zkClient;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import javax.swing.plaf.TableHeaderUI;
import java.util.List;

/**
 * @ClassName Create_Session_Sample
 * @Author dianXiao2
 * @Date 2018/12/29 10:30
 **/
public class Create_Session_Sample {
    private static final String zkServers = "localhost:2181";
    private static final int sessionTimeout = 5000;

    public static void main(String[] args) throws Exception{
        ZkClient zk = new ZkClient(zkServers, sessionTimeout);
        System.out.println(">> ZooKeeper session established");

        String path = "/cyl";

        //指定节点注册监听器, 监听子节点的add, delete 并且将新的子节点列表返回给客户端
        //客户端可以对一个不存在的节点进行子节点变更的监听
        //该节点本身的创建和删除也会通知到客户端
        // 与原生的watcher不同， ZkClient的listener不是一次性的，客户端只要注册一次就会一直生效
        zk.subscribeChildChanges(path, new IZkChildListener() {
            @Override
            public void handleChildChange(String s, List<String> list) throws Exception {
                System.out.println(">> node : "+ s + "'s children changed, current children is " + list);
            }
        });

        zk.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                System.out.println(">> node : "+ s +" changed, data:" + o.toString());
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(">> node : " + s + " deleted...");
            }
        });

        //创建节点
        zk.createPersistent("/cyl/test1", true);

        //改变数据
        zk.writeData(path, "cao yu long");

        //删除节点
        zk.deleteRecursive("/cyl");

        Thread.sleep(Integer.MAX_VALUE);
    }
}
