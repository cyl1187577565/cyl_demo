package thread.threadPoolDemo;

import java.util.LinkedList;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class CylLinkedRunnableQueue implements RunnableQueue {
    // 任务队列的最大容量
    private int limit;
    //若任务队列已经满了则执行拒绝策略
    private final DenyPolicy denyPolicy;
    //存放任务的队列
    private final LinkedList<Runnable> runnableList = new LinkedList<>();
    private ThreadPool threadPool;

    //构造函数
    public CylLinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
        this.limit = limit;
        this.denyPolicy = denyPolicy;
        this.threadPool = threadPool;
    }

    @Override
    public void put(Runnable runnable) {

        synchronized (runnableList){
            if( runnableList.size() >= limit){
                //无法容纳新的任务时执行拒绝策略
                denyPolicy.reject(runnable,threadPool);
            }else{
                //将任务添加到队尾，并唤醒阻塞中的线程
                runnableList.addLast(runnable);
                runnableList.notifyAll();
            }
        }
    }

    @Override
    public Runnable take() throws InterruptedException {
        synchronized (runnableList){
            if(runnableList.isEmpty()){
                try {
                    //如果队列中没有任何可执行任务，则当前线程 将会挂起，
                    runnableList.wait();
                } catch (InterruptedException e) {
                    //被中断时需要抛出异常
                    e.printStackTrace();
                    throw e;
                }
            }
            return runnableList.removeFirst();
        }
    }

    @Override
    public int size() {
        synchronized (runnableList){
            return runnableList.size();
        }
    }
}
