package leetCode;

/**
 * 7整数翻转
 */
public class L0006_Reverse_Integer {
    public static void main(String[] args) {
        int reverse = reverse(-10);
        System.out.println(reverse);
    }

    public static int reverse(int x) {
        long temp = 0;
        while ( x != 0){
            temp *= 10;
            temp +=x%10;
            if(temp > Integer.MAX_VALUE || temp <Integer.MIN_VALUE){
                return 0;
            }
            x /=10;
        }
        return (int)temp;
    }
}
