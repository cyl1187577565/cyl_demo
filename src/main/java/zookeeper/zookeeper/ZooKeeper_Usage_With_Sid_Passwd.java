package zookeeper.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.time.ZoneOffset;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZooKeeper_Usage_With_Sid_Passwd
 * @Author dianXiao2
 * @Date 2018/12/28 14:24
 * 创建一个最基本的ZooKeeper对象实例，服用SessionId和Session_passwd
 **/
public class ZooKeeper_Usage_With_Sid_Passwd implements Watcher {


    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;

    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(connectString, sessionTimeout, new ZooKeeper_Usage_With_Sid_Passwd());
        latch.await();

        long sessionId = zooKeeper.getSessionId();
        byte[] passwd = zooKeeper.getSessionPasswd();

        zooKeeper = new ZooKeeper(connectString, sessionTimeout, new ZooKeeper_Usage_With_Sid_Passwd(), sessionId, passwd);

        Thread.sleep(Integer.MAX_VALUE);

    }

    @Override
    public void process(WatchedEvent event) {

        System.out.println(">> Received watched event: "+event);
        if(Event.KeeperState.SyncConnected == event.getState()){
            System.out.println(">> ZooKeeper is established");
            latch.countDown();

        }
    }
}
