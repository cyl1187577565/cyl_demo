package thread.cyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/11
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new MainTask());

        BillTask worker1 = new BillTask("天津", barrier);
        BillTask worker2 = new BillTask("上海", barrier);
        BillTask worker3 = new BillTask("北京", barrier);

        worker1.start();
        worker2.start();
        worker3.start();

        System.out.println(">> 主任务完成");

    }

    static class MainTask extends Thread{
        @Override
        public void run() {
            System.out.println(">> 所有子任务都完成了， 开始执行主任务");
        }
    }

    static class BillTask extends Thread{
        private String billName;
        private CyclicBarrier barrier;

        public BillTask(String billName, CyclicBarrier barrier) {
            this.billName = billName;
            this.barrier = barrier;
        }

        @Override
        public void run() {

            try {
                System.out.println(">> 市区：" + billName + "开始运算");
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println(">> 市区:" + billName +" 运算完成");

                //假设一次运算不完，第二次要依赖第一次的运算结果，都到达这个节点 后面 才会继续执行
                barrier.await();
                System.out.println(">> 全部结束, 市区:" + billName +"才开始后面的工作");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

}
