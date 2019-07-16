import java.util.HashMap;
import java.util.Map;

public class LargestSum {
    public static void main(String[] args) {
        LargestSum largestSum = new LargestSum();
        int[] a = {-1,100,-1,-10};
        int i = largestSum.largestSum(a);
        System.out.println(i);
    }

    /**
     *
     * @param nums
     */
    public int largestSum(int[] nums){
       int temSum = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i ++){
            if(temSum > 0){
                temSum = nums[i] + temSum;
            }else{
                temSum = nums[i];
            }
            res = Math.max(res, temSum);
        }
        return  res;
    }
}
