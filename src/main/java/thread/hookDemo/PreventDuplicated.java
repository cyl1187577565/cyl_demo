package thread.hookDemo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description 使用钩子线程+lock文件防止程序重复启动
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/17
 */
public class PreventDuplicated {
    private final static String LOCK_FILE = "d://lock.txt";
    private static boolean DELETE = true;

    public static void main(String[] args) throws IOException {
        //注入hook线程，在程序退出时删除lock文件
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if(DELETE){
                System.out.println(">> The program will kill SIGNAL.");
                deleteLockFile();
            }

        }));

        //检查是否存在lock文件
        checkRunning();

        //模拟业务
        boolean flag = true;
        int n = 0;
        while (flag){
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                n++;
                System.out.println(">> The program is running");
                if(n == 100){
                    flag = false;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void checkRunning() throws IOException {
        File file = getFile();
        if (file.exists()){
            DELETE = false;
            throw new RuntimeException(">> The program already running.");
        }
        file.createNewFile();
    }

    /**
     * 删除lock文件
     */
    private static void deleteLockFile() {
        File  file = getFile();
        file.deleteOnExit();
    }

    private static File getFile() {
        return new File(LOCK_FILE);
    }


}
