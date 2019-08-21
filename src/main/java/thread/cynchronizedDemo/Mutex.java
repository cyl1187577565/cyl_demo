package thread.cynchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class Mutex {
    private final static Object lock = new Object();

    public void accessResource(){
        synchronized(lock){
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final Mutex mutex = new Mutex();
        for(int i = 0; i < 5; i++){
            new Thread(mutex::accessResource).start();
        }
    }
}
