package zookeeper.zookeeper;

import org.apache.zookeeper.*;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ClassName ZooKeeper_GetChildren_Api_Usage
 * @Author dianXiao2
 * @Date 2018/12/28 17:35
 * ZooKeeper Api 获取子节点类表， 使用同步（sync）接口
 **/
public class ZooKeeper_GetChildren_Api_Usage implements Watcher {

    private static final String connectString = "localhost:2181";
    private static final int sessionTimeout = 5000;
    private static CountDownLatch latch = new CountDownLatch(1);
    private static ZooKeeper zooKeeper = null;

    public static void main(String[] args) throws Exception{
        zooKeeper = new ZooKeeper(connectString,sessionTimeout,new ZooKeeper_GetChildren_Api_Usage());
        latch.await();
        System.out.println(">> ZooKeeper session established ..");

        String path = "/cyl";
        String resPath = zooKeeper.create(path, "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(">> 创建节点："+resPath);

        String resPath2 = zooKeeper.create(path+"/test1", "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(">> 创建节点："+resPath2);

        String resPath3 = zooKeeper.create(path+"/test2", "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(">> 创建节点："+resPath3);

        List<String> children = zooKeeper.getChildren(path, true);
        children.stream()
                .forEach(System.out::println);

        String resPath4 = zooKeeper.create(path+"/test3", "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(">> 创建节点："+resPath4);

        String resPath5 = zooKeeper.create(path+"/test4", "value".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
        System.out.println(">> 创建节点："+resPath5);

        Thread.sleep(Integer.MAX_VALUE);
    }

    @Override
    public void process(WatchedEvent event) {
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
            }else{
                System.out.println(event.getType());
                System.out.println(event.getPath());
            }
        }
    }
}
