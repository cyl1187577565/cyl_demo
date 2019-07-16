package thread.conditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println("a");
            condition.await();
            System.out.println("b");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
