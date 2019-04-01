package dataStruture;

/**
 * 斐波那契
 */
public class Fibonacci {

    public static void main(String[] args) {
        int fib = fib3(12);
        System.out.println(fib);
    }

    /**
     * 递归实现
     * @param n
     * @return
     */
    public static int fib(int n){
        if(n <= 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }

        return fib(n-1)+fib(n-2);
    }

    /**
     * 自上而下的备忘录法
     * @param n
     * @return
     */
    public static int fib2(int n){

        int[] fibs = new int[n+1];
        for(int i = 0; i < n+1; i++){
            fibs[i] = -1;
        }
        return fib(n, fibs);
    }

    public static int fib(int n , int[] fibs){

        //已经在备忘录中，则不作计算
        if(fibs[n] != -1){
            return fibs[n];
        }

        if(n <= 1){
            fibs[n] = 1;
        }else {
            fibs[n] = fib(n-1, fibs) +fib(n-2, fibs);
        }

        return fibs[n];
    }

    /**
     * 自下而上的动态规划法
     * @param n
     * @return
     */
    public static int fib3(int n){
        if(n < 0){
            return 0;
        }

        int[] fibs = new int[n+1];
        fibs[0] = 1;
        fibs[1] = 1;

        for(int i = 2 ; i < n+1; i++){
            fibs[i] = fibs[i-1] +fibs[i-2];
        }
        return fibs[n];
    }
}
