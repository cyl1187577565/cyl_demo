package thread.fair_noFair_test;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private ReentrantLock lock;

    public MyService(boolean isFair) {
        lock = new ReentrantLock(isFair);;
    }

    public void serviceMethod(){
        try{
            lock.lock();
            System.out.println("ThreadName = "+ Thread.currentThread().getName()+" 获得锁");

        }finally {
            lock.unlock();
        }
    }
}
