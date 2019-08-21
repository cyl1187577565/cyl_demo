package jvm.jvmArgs;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/25
 */
public class J005_PrintGC {
    /**
     * -XX:+PrintGC 只要遇到gc就会打印
     * -XX:+PrintGCDetails 打印详细gc日志
     * -XX:+PrintHeapAtGC 打印更加详细的gc
     * -XX:+PrintGCTimeStamps 打印gc发生的时间
     * -XX:-PrintGCApplicationStoppedTime 打印应用程序由于gc而产生的停顿时间
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
