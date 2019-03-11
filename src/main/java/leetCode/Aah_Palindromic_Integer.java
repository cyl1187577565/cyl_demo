package leetCode;

/**
 * 9判断一个数是否是回文数
 */
public class Aah_Palindromic_Integer {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(121);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(int x) {
        int res = x;
        if (x < 0){
            return false;
        }
        if(x == 0){
            return true;
        }

        long temp = 0;

        while(x > 0){
            temp *= 10;
            temp += x%10;
            if(temp > Integer.MAX_VALUE ){
                return false;
            }
            x /= 10;
        }
        System.out.println(temp);
        return  res == (int)temp;
    }
}
