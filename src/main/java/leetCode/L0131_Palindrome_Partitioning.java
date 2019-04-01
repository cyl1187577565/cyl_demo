package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 131切分回文串 回溯算法
 */
public class L0131_Palindrome_Partitioning {

    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        List aab = partition("aab");
        System.out.println(JSON.toJSONString(aab));
    }

    public static List<List<String>> partition(String s) {
        nextString(s, 0, new ArrayList<>());
        return res;
    }

    public static void nextString(String str, int index, List<String> list){
        if(index == str.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i< str.length(); i++){
            String subStr = str.substring(index, i+1);
            if(isPalindrome(subStr)){
                list.add(subStr);
                nextString(str, i+1, list);
                list.remove(list.size() -1);
            }
        }
    }
    /**
     * 判断是否是回文
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        for (int i = 0; i <= str.length()/2; i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
