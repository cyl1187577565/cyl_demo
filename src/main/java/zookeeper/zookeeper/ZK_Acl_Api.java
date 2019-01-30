package zookeeper.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

public class ZK_Acl_Api implements Watcher {
    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        ZooKeeper zk1 = new ZooKeeper(connectString, sessionTimeout, new ZK_Acl_Api());
        ZooKeeper zk2 = new ZooKeeper(connectString, sessionTimeout, new ZK_Acl_Api());
        latch.await();

        String path = "/cyl_auth1";
        zk1.addAuthInfo("digest","foo:true".getBytes());
        String node1 = zk1.create(path, "test".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL);

        Stat stat = new Stat();
        byte[] data = zk2.getData(path, false, stat);

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
