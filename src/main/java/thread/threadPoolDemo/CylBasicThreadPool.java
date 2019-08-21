package thread.threadPoolDemo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class CylBasicThreadPool extends Thread implements ThreadPool {

    private final int initSize;
    private final int maxSize;
    private final int coreSize;
    private int activeCount;

    //创建线程需要的工厂
    private final ThreadFactory threadFactory;
    //任务队列
    private final RunnableQueue runnableQueue;
    //线程池是否已经被shutdown
    private volatile boolean isShutdown = false;
    //工作线程队列
    private final Queue<Thread> threadQueue = new ArrayDeque<>();

    private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();

//    private final static ThreadFactory DEFAULT_THREAD_FACTORY ;

    private final long keepAliveTime;

    private final TimeUnit timeUnit;

    public CylBasicThreadPool(int initSize, int maxSize, int coreSize, int activeCount, ThreadFactory threadFactory, int queueSize,DenyPolicy denyPolicy, long keepAliveTime, TimeUnit timeUnit) {
        this.initSize = initSize;
        this.maxSize = maxSize;
        this.coreSize = coreSize;
        this.activeCount = activeCount;
        this.threadFactory = threadFactory;
        this.runnableQueue = new CylLinkedRunnableQueue(queueSize,denyPolicy, this);
        this.keepAliveTime = keepAliveTime;
        this.timeUnit = timeUnit;
        this.init();
    }

    private void init() {
        start();
        for(int i = 0; i < initSize; i++){
            newThread();
        }
    }

    /**
     * 提交任务
     * @param runnable
     */
    @Override
    public void execute(Runnable runnable) {
        if(this.isShutdown){
            throw new IllegalStateException(">> The thread pool is destroy");
        }

        //提交任务只是简单的往任务列中插入Runnable
        this.runnableQueue.put(runnable);

    }

    private void newThread(){
        CylTask task = new CylTask(runnableQueue);
        Thread thread = this.threadFactory.createThread(task);
//        Thread
    }

    @Override
    public void shutdown() {

    }

    @Override
    public int getInitSize() {
        return 0;
    }

    @Override
    public int getMaxSize() {
        return 0;
    }

    @Override
    public int getCoreSize() {
        return 0;
    }

    @Override
    public int getQueueSize() {
        return 0;
    }

    @Override
    public int getActiveSize() {
        return 0;
    }

    @Override
    public boolean isShutdown() {
        return false;
    }
}
