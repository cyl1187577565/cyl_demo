package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/10/14
 */
public class L0040 {
    private int[] candidates;
    private List<List<Integer>> res;
    private int target ;
    private int len;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return null;
        }

        this.candidates = candidates;
        this.res = new ArrayList<>();
        this.target = target;
        this.len = candidates.length;

        Arrays.sort(candidates);
        findCombinationSum(target,0,new LinkedList<Integer>());
        return  res;
    }

    private void findCombinationSum(int residue, int start, LinkedList<Integer> pre) {
        if(residue == 0){
            res.add(new ArrayList<>(pre));
            return ;
        }

        for(int i= start; i < len && residue-candidates[i] >=0; i++){
            pre.push(candidates[i]);
            findCombinationSum(residue-candidates[i],i+1,pre);
            pre.pop();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        L0040 ll = new L0040();
        List<List<Integer>> lists = ll.combinationSum2(candidates, target);
        System.out.println(JSON.toJSONString(lists));

    }
}
