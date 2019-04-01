package dataStruture;

import java.time.Instant;
import java.time.LocalDateTime;

/**'
 * 阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        long start = Instant.now().toEpochMilli();
        long factorial = factorial(20);
        long end = Instant.now().toEpochMilli();
        System.out.println(factorial);
        System.out.println(end-start );


        start = Instant.now().toEpochMilli();
        long l = factorial2(20);
        end = Instant.now().toEpochMilli();
        System.out.println(l);
        System.out.println(end-start );
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static long factorial(int n){
        if (n == 0){
            return 1;
        }

        return factorial(n-1)*n;
    }

    /**
     * 动态规划
     * @return
     */
    public static long factorial2(int n){
        long[] res = new long[n+1];
        res[0] = 1;
        for(int i = 1; i <= n ; i++){
            res[i] = i* res[i-1];
        }
        return res[n];
    }
}
