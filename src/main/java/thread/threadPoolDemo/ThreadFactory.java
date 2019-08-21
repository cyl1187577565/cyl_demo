package thread.threadPoolDemo;

public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
