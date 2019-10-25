package jvm.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/10/21
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        try{

        }finally {
            lock.unlock();
        }
    }
}
