package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串全排列
 */
public class L0046_Permute {
    public static void main(String[] args) {
        List<List<Integer>> lists = swapEveryIntegerWithTarget(Arrays.asList(1, 2), 3);
        System.out.println(JSON.toJSONString(lists));

    }
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new LinkedList<>();
        res.add(new ArrayList<>());

        for(int i = 0; i <nums.length; i++){
            int size = res.size();
            for (int j = 0 ; j < size; j++){
                List<Integer> poll = ((LinkedList<List<Integer>>) res).poll();
                for(int k = 0; k < nums.length; k++){
                    if(poll.contains(nums[k])){
                        continue;
                    }
                    List<Integer> temp = new ArrayList<>();
                    temp.addAll(poll);
                    temp.add(nums[k]);
                    res.add(temp);
                }
            }
        }
        return res;
    }


    private static List<List<Integer>> permute2(int[] nums){
        List<List<Integer>> res = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if (res.isEmpty()){
                res.add(new ArrayList<>(Arrays.asList(nums[i])));
            }else {
                int size = res.size();
                for(int j = 0; j < size; j++){
                    res.addAll(swapEveryIntegerWithTarget(((LinkedList<List<Integer>>) res).pop(),nums[i]));
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> swapEveryIntegerWithTarget(List<Integer> in, Integer target){
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.addAll(in);
        temp.add(target);
        Integer[] tempArr = new Integer[temp.size()];
        for(int i = 0; i <  temp.size(); i++){
            tempArr[i] = temp.get(i);
        }
        result.add(new ArrayList<>(Arrays.asList(tempArr)));

        for(int i = 0; i < in.size(); i++){
            tempArr[tempArr.length - 1] = tempArr[i];
            tempArr[i] = target;
            result.add(new ArrayList<>(Arrays.asList(tempArr)));

            //tempArr还原
            tempArr[i] = tempArr[tempArr.length - 1];
            tempArr[tempArr.length - 1] = target;
        }

        return result;
    }
}
