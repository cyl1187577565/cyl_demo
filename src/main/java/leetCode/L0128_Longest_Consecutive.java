package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 * 用哈希表存储每个端点值对应连续区间的长度
 * 若数已在哈希表中：跳过不做处理
 * 若是新数加入：
 * 取出其左右相邻数已有的连续区间长度 left 和 right
 * 计算当前数的区间长度为：cur_length = left + right + 1
 * 根据 cur_length 更新最大长度 max_length 的值
 * 更新区间两端点的长度值
 */
public class L0128_Longest_Consecutive {
    public static void main(String[] args) {
        L0128_Longest_Consecutive client = new L0128_Longest_Consecutive();
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        int i = client.longestConsecutive(nums);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;

        for (Integer i : nums){
            if(!map.containsKey(i)){
                Integer left = map.get(i-1);
                Integer right = map.get(i+1);
                if(left == null){
                    left = 0;
                }
                if(right == null){
                    right = 0;
                }
                Integer current_length = left + right +1;
                result = Math.max(current_length, result);
                map.put(i, current_length);
                map.put((i-left),current_length);
                map.put((i+right),current_length);
            }
        }
        return result;
    }
}
