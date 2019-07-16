package thread.useMutipleCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();

    public void waitA() {
        try{
            lock.lock();
            System.out.println("begin awaitA 时间为："+System.currentTimeMillis() +" ThreadName= " + Thread.currentThread().getName());
            condition1.await();
            System.out.println("end awaitA 时间为 "+ System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void waitB(){
        try{
            lock.lock();
            System.out.println("begin await A 时间为："+System.currentTimeMillis()+" ThreadName = "+Thread.currentThread().getName());
            condition2.await();
            System.out.println("end awaitB 时间为 "+ System.currentTimeMillis()+" ThreadName = "+ Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalA(){
        try{
            lock.lock();
            System.out.println("signalA 时间为"+ System.currentTimeMillis()+" ThreadName = "+ Thread.currentThread().getName());
            condition1.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void signalB(){
        try{
            lock.lock();
            System.out.println("signalB 时间为 " +System.currentTimeMillis()+" ThreadName = "+ Thread.currentThread().getName());
            condition2.signalAll();
        }finally{
            lock.unlock();
        }
    }
}
