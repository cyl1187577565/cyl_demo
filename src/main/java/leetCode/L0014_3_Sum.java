package leetCode;

import java.util.*;

/**
 * 15 三数之和
 */
public class L0014_3_Sum {
    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{3, 0, -2, -1, 1, 2});
        System.out.println(lists.toString());
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int len = nums.length;

        for (int i = 0; i < nums.length && nums[i] <=0; i++){
            int start = nums[i];
            int temp = 0-start;
            int l = i+1;
            int r = len-1;
            while (l < r){
                if(temp == nums[l] +nums[r]){
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    set.add(list);
                    l++;
                    r--;
                }else if(temp > (nums[l] + nums[r])){
                    l++;
                }else {
                    r--;
                }
            }

        }
        return new ArrayList<>(set);
    }
}
