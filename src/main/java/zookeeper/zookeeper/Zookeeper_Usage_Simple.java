package zookeeper.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName Zookeeper_Contructor_Usage_Simple
 * @Author dianXiao2
 * @Date 2018/12/28 11:49
 * 创建一个最基本的zookeeper的会话实例
 * ZooKeeper 所有的非叶子节点都不能使临时节点
 **/
public class Zookeeper_Usage_Simple implements Watcher {

    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(connectString,sessionTimeout,new Zookeeper_Usage_Simple());
            System.out.println(">> zookeeper.state:"+zooKeeper.getState());
            latch.await();
            System.out.println(">> ZooKeeper session established ...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println(">> receive watched event:"+event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            System.out.println(">> zookeeper 已经连接...");
            latch.countDown();
        }
    }
}
