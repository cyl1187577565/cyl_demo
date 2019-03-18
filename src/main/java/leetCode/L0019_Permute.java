package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46 去排列
 */
public class L0019_Permute {
    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 1, 3});
        System.out.println(JSON.toJSONString(res));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int size = res.size();

            for(int j = 0 ; j < size; j++){
                List<Integer> poll = ((LinkedList<List<Integer>>) res).poll();

                for(int k = 0 ; k < nums.length; k++){
                    if(poll.contains(nums[k])){
                        continue;
                    }
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.addAll(poll);
                    temp.add(nums[k]);
                    res.add(temp);
                }

            }

        }
        return res;
    }




}
