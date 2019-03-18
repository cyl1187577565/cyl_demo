package leetCode;

/**
 * 136 只出现一次的数字
 */
public class L0136_Single_Number {
    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }

    /*使用位运算*/
    public static int singleNumber(int[] nums){
        if(nums == null || nums.length < 1){
            return 0;
        }

        int res = 0, i = 0;
        while (i < nums.length ){
            res = res ^ nums[i];
            i++;
        }
        return res;
    }
}
