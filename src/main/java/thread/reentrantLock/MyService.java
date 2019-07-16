package thread.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();

    public void test(){
        lock.lock();
        for(int i = 0; i < 5; i++){
            System.out.println("ThreadName=" + Thread.currentThread().getName()+" " + (i+1));
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        String aa = "aaa";
        System.out.println(aa.hashCode());

        System.out.println(aa.hashCode() & Integer.MAX_VALUE);
    }
}
