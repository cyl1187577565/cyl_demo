package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 字符串全排列
 */
public class L0046_Permute {
    public static void main(String[] args) {

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
}
