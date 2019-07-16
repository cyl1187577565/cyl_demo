package thread.readWriteLockDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Count {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock  readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();

    public void get(){
        try{
            readLock.lock();
            System.out.println(Thread.currentThread().getName()+" read start");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName()+" read end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }

    public void put(){
        try{
            writeLock.lock();
            System.out.println(Thread.currentThread().getName()+" write start");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " write end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }
}
