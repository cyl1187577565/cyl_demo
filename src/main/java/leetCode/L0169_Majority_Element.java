package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 169 求众数
 */
public class L0169_Majority_Element {
    public static void main(String[] args) {

    }

    public  static int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        Integer res = 0;
        Integer resKey = 0;

        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i]) +1);
            }else{
                map.put(nums[i], 1);
            }
        }

       for( Integer key : map.keySet()){
            if(map.get(key) > res){
                res = map.get(key);
                resKey = key;
            }
       }

       return resKey;
    }
}
