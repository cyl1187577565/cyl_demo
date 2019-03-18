package leetCode;

import java.util.Arrays;

/**
 * 16 最接近的三数之和
 */
public class L0015_3_Sum_Closet {

    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{0, 1, 2}, 0);
        System.out.println(i);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2] ;
        int len = nums.length;
        for(int i  = 0; i< len-2; i++){
            int start = nums[i];
            int j = i+1;
            int k = len-1;
            while (j < k){
                int temp = start + nums[j] + nums[k];
                res =  Math.abs(target-temp)< Math.abs(target-res) ? temp : res;
                if(temp == target){
                    return temp;
                }else if(target > temp){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}
