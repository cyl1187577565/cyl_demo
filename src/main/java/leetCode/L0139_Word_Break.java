package leetCode;

import java.util.Arrays;
import java.util.List;

/**
 * 139 字符串拆分
 */
public class L0139_Word_Break {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("leet", "code");
        boolean leetcode = wordBreak("leetcode", list);
        System.out.println(leetcode);
    }
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        boolean[] memo = new boolean[n + 1];
        memo[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (memo[j] && wordDict.contains(s.substring(j, i))) {
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }

    public boolean wordBreak2(String s, List<String> wordDict){
        int n = s.length();
        boolean[] memo = new boolean[n+1];
        memo[0] = true;

        for(int i = 0; i < s.length(); i++){
            for(int j = 0 ; j <= i ; j++){
                if(memo[j] && wordDict.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[n];
    }


}
