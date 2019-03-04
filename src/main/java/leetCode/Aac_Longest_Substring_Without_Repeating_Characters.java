package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最长子串
 */
public class Aac_Longest_Substring_Without_Repeating_Characters {

    public int lengthOfLongestSubstring(String s) {
       //最长子串的长度
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        for(;j <s.length(); j++){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                i = Math.max(map.get(c), i);
            }
            res = Math.max(res, j -i +1);
            map.put(c, j + 1);
        }

        return res;
    }
}
