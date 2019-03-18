package leetCode;

/**
 * 寻找数组的中心索引
 */
public class L0724_Pivot_Index {

    public int pivotIndex(int[] nums) {
        long sum = 0;
        //计算总和
        for(int i : nums){
            sum += nums[i];
        }

        int i = 0;
        while (i < nums.length){
            long tempSum = 0;
            for(int j = 0; j < i; j++){
                tempSum += nums[j];
            }
            if(2*tempSum == (sum - nums[i])){
                return i;
            }
        }
        return -1;
    }
}
