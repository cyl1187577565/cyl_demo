package leetCode;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 最长回文-*
 *
 */
public class Aae_Longest_Palindromic_Substring {


    /**
     * 中心扩展法 时间复杂度n^2
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        final int len = s.length();
        int maxLen = 1;
        int start = 0;
        int end = 0;

        //排除特殊情况
        if (s == "" || s == null){
            return "";
        }
        if(len == 1){
            return s;
        }

        //求长度为奇数的回文字符串
        for(int i = 0; i < s.length(); i++){
            int j = i-1, k = i+1;
            while (j >= 0 && k < len && s.charAt(j) == s.charAt(k) ){
                if((k -j +1) > maxLen){
                    maxLen = k-j+1;
                    start = j;
                    end = k;
                }

                j--;
                k++;
            }
        }

        //求长度为偶数的回文字符串]
        for(int i = 0; i< len; i++){
            int j = i, k = i+1;
            while (j >= 0 && k < len && s.charAt(j) == s.charAt(k)){
                if((k-j+1) > maxLen){
                    maxLen = k-j+1;
                    start = j;
                    end = k;
                }
                j--;
                k++;
            }
        }

        return s.substring(start, end+1);
    }

    /**
     * 马拉车算法， 时间复杂度N
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s){
        //排除特殊情况
        if(s == null || "".equals(s)){
            return null;
        }
        if(1 == s.length()){
            return s;
        }

        StringBuilder sb = new StringBuilder("$#");
        for(int i = 0; i < s.length() ; i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        String s1 = sb.toString();

        int[] p = new int[s1.length()];
        int mx = 0, id = 0, resLen = 0, resCenter = 0;

        for(int i = 0; i < s1.length(); i++){
            //核心之处，避免了重复的计算
            p[i] = (mx > i)?Math.min(p[2*id -i], mx -i):1;

            //判断是否是回文数据
            while ((i+p[i])< s1.length() && (i - p[i])>= 0 && s1.charAt(i+p[i]) == s1.charAt(i - p[i])){
                p[i] += 1;
            }
            if(mx < i +p[i]){
                mx = i +p[i];
                id = i;
            }
            if(resLen < p[i]){
                resLen = p[i];
                resCenter = i;
            }
        }

        //起始位置为(resCenter - resLen)/2, 字符段长度为resLen -1;
        int start = (resCenter-resLen)/2;
        int end = resLen + start -1;
        return s.substring(start, end);
    }
    public static void main(String[] args) {
        String s = longestPalindrome2("a");
        System.out.println(s);
    }
}
