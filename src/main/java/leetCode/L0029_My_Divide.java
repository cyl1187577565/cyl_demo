package leetCode;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/26
 * 29. 两数相除
 */

/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

        返回被除数 dividend 除以除数 divisor 得到的商。

        示例 1:

        输入: dividend = 10, divisor = 3
        输出: 3
        示例 2:
*/

public class L0029_My_Divide {
    public int divide(int dividend, int divisor) {
        //获得最后的正负号
        boolean sign = (dividend > 0) ^ (divisor > 0);

        //处理极限值
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        //全部化成正数来进行计算
        long dd = Math.abs(dividend);
        long d = Math.abs(divisor);

        int result = 0;
        for(int i = 31; i >= 0; i--){
            if(dd >> i >= d){
                result += 1 << i;
                dd -= d << i;
            }
        }

        if(sign){
            return  -result;
        }else{
            return result;
        }
    }
}
