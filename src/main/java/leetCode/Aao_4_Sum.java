package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 18 四数之和
 */
public class Aao_4_Sum {

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        List<List<Integer>> lists = fourSum(nums, 0);
        System.out.println(JSON.toJSONString(lists));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {

        //对数组进行排序
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        for(int i = 0; i < nums.length-3; i++){
            int temp = target - nums[i];

            for(int j = i+1; j < nums.length -2; j++){
                int temp2 = temp - nums[j];
                int l = j+1;
                int r = nums.length - 1;
                while (l < r){
                    if(temp2 < nums[l] + nums[r] ){
                        r--;
                    }else if(temp2 > nums[l] +nums[r]){
                        l++;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        r--;
                        l++;
                    }
                }
            }
        }

        return new ArrayList<>(res);
    }
}
