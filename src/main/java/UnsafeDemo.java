import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class UnsafeDemo {
    public static void main(String[] args) throws Exception{
        Field f = Unsafe.class.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe UNSAFE = (Unsafe) f.get(null);

        byte[] bytes = new byte[10];
        byte[] bytes2 = new byte[20];
        System.out.println(Arrays.toString(bytes));

        int byteArrayBaseOffset = UNSAFE.arrayBaseOffset(byte[].class);
        System.out.println(byteArrayBaseOffset);
        UNSAFE.putByte(bytes,(long)byteArrayBaseOffset,(byte)1);
        UNSAFE.putByte(bytes2,(long)byteArrayBaseOffset,(byte)1);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));

        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.addAndGet(1);
        System.out.println("==========");
        System.out.println(atomicInteger.get());
    }
}
