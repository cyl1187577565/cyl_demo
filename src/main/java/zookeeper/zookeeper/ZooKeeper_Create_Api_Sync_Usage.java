package zookeeper.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZooKeeper_Create_Api_Sync_Usage
 * @Author dianXiao2
 * @Date 2018/12/28 14:36
 * ZooKeeper api创建节点，使用同步（sync）接口
 **/

public class ZooKeeper_Create_Api_Sync_Usage implements Watcher {
    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(connectString,sessionTimeout,new ZooKeeper_Create_Api_Sync_Usage());
        System.out.println(">> zookeeper.state:"+zooKeeper.getState());
        latch.await();
        System.out.println(">> ZooKeeper session established ...");

        String path1 = zooKeeper.create("/test", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(">> 创建节点："+path1);
        String path2 = zooKeeper.create("/test", "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
        System.out.println(">> 创建节点："+path2);

        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override
    public void process(WatchedEvent event) {

        System.out.println(">> received watched event:"+event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            latch.countDown();
        }
    }
}
