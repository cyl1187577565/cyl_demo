package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/27
 */
public class L0030_FindSubStr {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        //处理极限值
        if(s == null || s == ""){
            return result;
        }
        if(words == null || words.length <= 0){
            return result;
        }

        //计算滑动窗口的长度
        int winLength = words.length * words[0].length();
        int wordLength = words[0].length();
        //将所有的words加入hashmap中
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i <  words.length; i++){
            if(map.get(words[i]) != null){
                map.put(words[i], map.get(words[i]) +1);
            }else{
                map.put(words[i], 1);
            }
        }

        //遍历字符串
        for(int i = 0; i <= s.length()-winLength; i++){
            //新建一个hash，用来做对比使用
            Map<String,Integer> temp = new HashMap<>();
            //计算窗口截止位置
            int end = i + winLength;
            for(int j = i ; j <= end - wordLength ;){
                //一个个单词的比较
                String key = s.substring(j, j + wordLength);
               //首先判断该字符串是否在map中
                Integer nums = map.get(key);
                if(nums == null){
                    break;
                }

                //然后在判断字符是否小于等于nums
                Integer tempValue = temp.get(key);
                if(tempValue == null){
                    temp.put(key, 1);
                }else if(tempValue < nums){
                    temp.put(key, (tempValue + 1));
                }else{
                    //和字符串不匹配
                    break;
                }

                if(j == (end - wordLength)){
                    result.add(i);
                }
                j += wordLength;
            }
        }

        return result;
    }


    public static void main(String[] args) {
       String s =  "wordgoodgoodgoodbestword";
       String[] words = {"word","good","best","good"};
       List<Integer> substring = findSubstring(s, words);
       System.out.println(JSON.toJSONString(substring));
    }
}
