package zookeeper.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZooKeeper_GetData_Api_Sync_Usage
 * @Author dianXiao2
 * @Date 2018/12/28 18:35
 **/
public class ZooKeeper_GetData_Api_Sync_Usage implements Watcher {

    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;
    private static CountDownLatch latch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper = null;
    private static Stat stat = new Stat();

    public static void main(String[] args) throws Exception{
        zooKeeper = new ZooKeeper(connectString,sessionTimeout,new ZooKeeper_GetData_Api_Sync_Usage());
        latch.await();
        System.out.println(">> ZooKeeper session established ..");

        String path = "/cyl";

//        String resPath2 = zooKeeper.create(path+"/test1", "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        System.out.println(">> 创建节点："+resPath2);
        zooKeeper.create(path,"value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
//        zooKeeper.getChildren(path,true);
//        String resPath3 = zooKeeper.create(path+"/test2", "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
//        System.out.println(">> 创建节点："+resPath3);
        zooKeeper.getData(path,true, stat);
        Stat stat1 = zooKeeper.exists(path, true);
        System.out.println(stat1.getVersion());
        zooKeeper.setData(path,"aaa".getBytes(),-1);
        zooKeeper.setData(path,"bb".getBytes(),1);
        zooKeeper.delete(path, -1);

//

//        zooKeeper.setData(resPath2, "bbb".getBytes(),-1);

        Thread.sleep(Integer.MAX_VALUE);


    }

    @Override
    public void process(WatchedEvent event){
        System.out.println(">> received watched event: "+event);
        if(Event.KeeperState.SyncConnected.equals(event.getState())){
            if(Event.EventType.None == event.getType() && null == event.getPath()){
                latch.countDown();
            }else if (Event.EventType.NodeChildrenChanged == event.getType()){
                //子节点改变
                try {
                    System.out.println(">> ReGet child: "+ zooKeeper.getChildren(event.getPath(),true));
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else if(Event.EventType.NodeDataChanged == event.getType()){
                try {
                    System.out.println(new String(zooKeeper.getData(event.getPath(), true, stat)));
                    System.out.println(stat.getCzxid()+" ," + stat.getMzxid()+" ," + "," + stat.getVersion());
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
