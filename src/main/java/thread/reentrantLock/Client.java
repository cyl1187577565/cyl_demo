package thread.reentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/9
 */
public class Client {
    /**
     * ReentrantLock
     *      构造方法:
     *          ReentrantLock()
     *          ReentrantLock(boolean fair)
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
    }
}
