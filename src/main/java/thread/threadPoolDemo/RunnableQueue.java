package thread.threadPoolDemo;

public interface RunnableQueue {
    //当有数据的时候offer近
    void put(Runnable runnable);
    //获取Runnable
    Runnable take() throws InterruptedException;

    int size();
}
