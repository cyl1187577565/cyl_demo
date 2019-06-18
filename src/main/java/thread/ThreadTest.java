package thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class ThreadTest {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getThreadGroup());
        ThreadLocal<String> t = new ThreadLocal<>();

        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
    }
}
