package thread.hookDemo;

import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class ThreadHook {

    // 钩子线程可以用来防止某个线程重复启动
    public static void main(String[] args) {
        // 为应用程序注册钩子线程
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println(">> The hook Thread is running");
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(">> The hook thread will exit");
        }));

        System.out.println(">> The program will stopping !!!");
    }
}
