package dataStruture.recursive;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * 字符串的全排列
 * 解题思路：
 *  全排列前n-1个字符
 *  加入第n个字符， 和前n-1个字符轮换位置
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/26
 */
public class Permute {

    public static void main(String[] args) {

        List<String> abc = permute("abcd");
        System.out.println(JSON.toJSONString(abc));
        System.out.println(abc.size());
    }

    private static List<String> permute(String str){
        List<String> result = new LinkedList<>();
        for (int i = 0; i < str.length(); i++){
            if (result.isEmpty()){
                result.add(str.substring(0,1));
            }else {
                int size = result.size();
                for(int j = 0; j < size; j++){
                    result.addAll(exchangeEveryWorldWithTarget(((LinkedList<String>) result).pop(),str.charAt(i)));
                }
            }

        }
        return  result;
    }

    /**
     * 交换字符串中的每一个字符和目标char
     * @param str
     * @param target
     * @return
     */
    private static List<String> exchangeEveryWorldWithTarget(String str, char target){
        List<String> result = new ArrayList<>();

        char[] chars = str.toCharArray();
        char[] temp = new char[str.length() +1];
        //复制数组
        for(int j = 0; j < chars.length; j++){
            temp[j] = chars[j];
        }
        temp[temp.length-1] = target;
        result.add(new String(temp));

        for(int j = 0 ; j < temp.length-1; j++){
            // 和最后一位交换
            temp[temp.length -1] = temp[j];
            temp[j] = target;
            result.add(new String(temp));

            //还原temp
            temp[j] = temp[temp.length -1];
            temp[temp.length - 1] = target;
        }

        return  result;
    }


}
