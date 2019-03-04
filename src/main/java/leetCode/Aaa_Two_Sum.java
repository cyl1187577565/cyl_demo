package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/*      Given an array of integers, return indices of the two numbers such that they add up to a specific target
        You may assume that each input would have exactly one solution, and you may not use the same element twice.
        Example:

        Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class Aaa_Two_Sum {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] ints = towSum(nums, target);
        System.out.println(JSON.toJSONString(ints));

    }

    public static int[] towSum(int[] a, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int temp;
        for (int i = 0; i < a.length; i++){
            temp = target - a[i];
            if( map.containsKey(temp) && map.get(temp) != i){
                int[] res = {map.get(temp),i};
                return res;
            }else {
                map.put(a[i], i);
            }
        }
        return null;
    }
}
