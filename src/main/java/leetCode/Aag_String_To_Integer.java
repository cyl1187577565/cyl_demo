package leetCode;

/**
 * 8字符串转数字
 */
public class Aag_String_To_Integer {

    public static void main(String[] args) {
        int i = myAtoi(" ");
        System.out.println(i);
    }

    public static int myAtoi(String str) {

        if(str == null || "".equals(str)){
            return 0;
        }

        int sign = 1;
        long temp = 0;

        if(str == null || "".equals(str)){
            return 0;
        }

        //开头处理空字符串
        int i = 0;
        while ( i < str.length() && ' ' == str.charAt(i) ){
            i++;
        }
        //处理正负号
        if(i < str.length() && ('-' == str.charAt(i) || '+' == str.charAt(i))){
            sign = 1-2*('-' == str.charAt(i)? 1: 0);
            i++;
        }

        //处理字符串
        while (i < str.length() && str.charAt(i) >= (int)'0' && str.charAt(i) <= (int)'9'){
            temp *= 10;
            temp += (int)str.charAt(i)-(int)'0';
            if(temp >= Integer.MAX_VALUE){
                if(sign < 0){
                    return (Integer.MAX_VALUE +1) * sign;
                }else{
                    return Integer.MAX_VALUE;
                }

            }
            if(temp <= Integer.MIN_VALUE){
                if(sign < 0){
                    return (Integer.MIN_VALUE +1) * sign;
                }else{
                    return Integer.MIN_VALUE;
                }
            }
            i++;
        }

        return (int) temp * sign;
    }
}
