package thread.cynchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class EventClient {

    public static void main(String[] args) {
        final EventQueue eventQueue = new EventQueue();

        new Thread(() -> {
            while (true){
                eventQueue.put(new EventQueue.Event());
            }
        },"producer").start();

        new Thread(() ->{
            while (true) {
                eventQueue.get();
                try {
                    TimeUnit.MILLISECONDS.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, " consumer").start();
    }
}
