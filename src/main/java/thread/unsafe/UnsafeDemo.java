package thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static io.netty.util.internal.shaded.org.jctools.util.UnsafeAccess.UNSAFE;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/8
 */
public class UnsafeDemo {
    public static void main(String[] args) {

        Unsafe unsafe = getUnsafe();

        byte[] bytes = new byte[10];
        byte[] bytes2 = new byte[20];
        System.out.println(Arrays.toString(bytes));

        int byteArrayBaseOffset = unsafe.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);
        unsafe.putByte(bytes,(long)byteArrayBaseOffset,(byte)1);
        unsafe.putByte(bytes2,(long)byteArrayBaseOffset,(byte)1);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));

        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.addAndGet(1);
        System.out.println("==========");
        System.out.println(atomicInteger.get());
    }

    /*Java最初被设计为一种安全的受控环境。尽管如此，HotSpot还是包含了一个后门sun.misc.Unsafe，
    提供了一些可以直接操控内存和线程的底层操作。Unsafe被JDK广泛应用于java.nio和并发包等实现中，
    这个不安全的类提供了一个观察HotSpot JVM内部结构并且可以对其进行修改，但是不建议在生产环境中使用。
        Unsafe类是如此地不安全，以至于JDK开发者增加了很多特殊限制来访问它。
        * 私有的构造器
        * 工厂方法getUnsafe()的调用器只能被Bootloader加载，否则抛出SecurityException 异常
    不过，我们可以通过反射机制轻松获取Unsafe的一个实例。*/
    public static Unsafe getUnsafe(){
        Field f = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            Unsafe unsafe = (Unsafe) f.get(null);
            return unsafe;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  null;
    }

}
