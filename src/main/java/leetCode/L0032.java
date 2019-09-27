package leetCode;

import java.util.LinkedList;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/27
 */
public class L0032 {

    public static int longestValidParentheses(String s) {
        if(s == null || s == ""){
            return 0;
        }

        char[] chars = s.toCharArray();

        int res = 0;
        for(int i = 0; i < chars.length; i++){
            LinkedList<Character> stack = new LinkedList();

            int j = i;
            for(; j < chars.length; j++) {
                if ('(' == chars[j]) {
                    //入栈
                    stack.push(chars[j]);
                } else {
                    //出栈校验合法性
                    if (stack.isEmpty()) {
                        break;
                    }
                    if (')' != stack.pop()) {
                        //不合法
                        break;
                    }
                }
            }

            res = Math.max(res, j -i);
         }

        return res;
    }


    public static void main(String[] args) {
        String ll = ")()())";
        int i = longestValidParentheses(ll);
        System.out.println(i);
    }
}
