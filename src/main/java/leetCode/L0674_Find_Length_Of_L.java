package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续递增序列
 */
public class L0674_Find_Length_Of_L {
    public int findLegthOfLCIS(int[] nums){
        if(nums == null || nums.length <= 0){
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int temp = nums[0];
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > temp){
                res = Math.max(res, i-left+1);
            }else{
                left = i;
                res = Math.max(res,1);
            }
            temp = nums[i];
        }
        return res;
    }
}
