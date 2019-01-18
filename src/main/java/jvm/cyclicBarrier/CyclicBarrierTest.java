package jvm.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @ClassName CyclicBarrier
 * @Author dianXiao2
 * @Date 2019/1/14 15:53
 **/
public class CyclicBarrierTest implements Runnable{

    private CyclicBarrier barrier;

    private String name;

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(5);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for( int i = 0 ; i < 5; i++){
            executorService.submit(new Thread(new CyclicBarrierTest(barrier, "worker" + i)));
        }
        executorService.shutdown();
    }

    public CyclicBarrierTest(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "正在做工作..........");
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(name + "完成工作了, 我们放假了");
    }

}
