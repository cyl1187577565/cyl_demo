package jvm.semaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SemaphoreTest
 * @Author dianXiao2
 * @Date 2019/1/14 16:16
 **/
public class SemaphoreTest{

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(6);
        int i = 0;
        while (i < 10){
            executorService.submit(new Thread(new Worker("worker"+i, semaphore)));
            i++;
        }
    }

    static class Worker implements Runnable{
        private String name;
        private Semaphore semaphore;

        public Worker(String name, Semaphore semaphore) {
            this.name = name;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println(name + "占用呀一个机器，正在生产....");
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));
                System.out.println(name + "完成工作，释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
