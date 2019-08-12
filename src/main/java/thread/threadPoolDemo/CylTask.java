package thread.threadPoolDemo;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class CylTask implements Runnable {

    private RunnableQueue runnableQueue;
    private volatile boolean running = true;

    public CylTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        // 如果当前任务状态为running并且没有被中断，则其将不断的从queue中获取runnable，然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()){
            Runnable runnable = null;
            try {
                runnable = runnableQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            runnable.run();
        }
    }

    //停止当前任务，主要用于线程池的shutdown方法中使用
    public void stop(){
        this.running = false;
    }
}
