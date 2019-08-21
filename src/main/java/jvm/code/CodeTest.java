package jvm.code;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 整数的存储，在计算机中是以补码的方式存在的，
 * 以补码存在的好处为 1 可以统一0的表示，2可以简化整数的加减法计算（统一做加法）
 *
 * 在IEEE754的定义中，一个浮点数由3部分组成：符号位，指数位和尾数位。
 *
 */
public class CodeTest {


    public static void main(String[] args) {
        showEveryBit();
        System.out.println();
        System.out.println(Integer.valueOf(0x8));
        System.out.println(1 & 3);
        System.out.println(1|6);

        HashMap<String,String> map = new HashMap<>();
        map.put("key","value");
        System.out.println(26&31);
        System.out.println(31&16);
        map.get("key");

        ConcurrentHashMap<String,String> map1 = new ConcurrentHashMap<>();
        map1.put("key", "value");

    }

    /**
     * 查看整数中每一位的实际值
     */
    public static void showEveryBit(){
        int a = -10;

        for(int i = 0; i < 32; i++){
            int t = (a & 0x80000000 >>> i) >>> (31-i);
            System.out.print(t);
        }
    }
}
