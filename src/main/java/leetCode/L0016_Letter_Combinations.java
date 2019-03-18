package leetCode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17电话号码的组合
 */
public class L0016_Letter_Combinations {
    static String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        String test = "23";
        List<String> list = letterCombinations(test);
        System.out.println(JSON.toJSONString(list));
        List<String> list1 = new LinkedList<>();
        List<String> list2 = letterCombinations2(test);
        System.out.println(JSON.toJSONString(list2));
    }

    //递归方法去做
    public static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        addNumer(res,0,"",digits);
        return res;
    }

    private static void addNumer(List<String> res, int i, String s, String digits) {
        if( i == digits.length()){
            res.add(s);
            return;
        }
        char[] chars = dict[Integer.valueOf(String.valueOf(digits.charAt(i)))].toCharArray();
        for(char c: chars){
            addNumer(res,i+1, s+c, digits);
        }
    }


    /**
     *队列实现
     * @param digits
     * @return
     */
    public static List<String> letterCombinations2(String digits){
        List<String> res = new LinkedList<>();
        res.add("");

        for(int i = 0; i< digits.length(); i++){
            int pos = digits.charAt(i) - '0';
            String tempStr = dict[pos];

            //当前队列里数据数量
            int size = res.size();

            //将队列里所有数据弹出
            for(int j = 0; j < size; j++){
                String poll = ((LinkedList<String>) res).poll();
                for(int k = 0 ; k < tempStr.length(); k++){
                    res.add(poll+tempStr.charAt(k));
                }
            }

        }

        return res;
    }
}
