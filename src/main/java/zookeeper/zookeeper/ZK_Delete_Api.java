package zookeeper.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

public class ZK_Delete_Api implements Watcher {


    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;
    private static CountDownLatch latch = new CountDownLatch(1);

    static class MyVoidCallBack implements AsyncCallback.VoidCallback{

        @Override
        public void processResult(int resCode, String path, Object ctx) {

        }
    }

    public static void main(String[] args) throws Exception{
        ZooKeeper zooKeeper = new ZooKeeper(connectString ,sessionTimeout,new ZK_Delete_Api());
        System.out.println(">> zookeeper.state:"+zooKeeper.getState());
        latch.await();
        zooKeeper.delete("/cyl",-1);
        System.out.println("删除了/cyl节点");
    }

    /**
     * 同步删除
     * @param zooKeeper
     * @param path
     * @param version
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void deleteSync(ZooKeeper zooKeeper, String path, int version) throws KeeperException, InterruptedException {
        zooKeeper.delete(path,version);
    }

    /**
     * 异步删除
     * @param zooKeeper
     * @param path
     * @param version
     */
    public void deleteAsync(ZooKeeper zooKeeper, String path, int version){
        zooKeeper.delete(path,version,new MyVoidCallBack(),"你大爷");
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
