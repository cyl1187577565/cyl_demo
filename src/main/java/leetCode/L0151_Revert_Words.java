package leetCode;

import org.springframework.util.StringUtils;

/**
 *
 */
public class L0151_Revert_Words {
    public static void main(String[] args) {
        reverseWords("  hello world!  ");
    }
    public static String reverseWords(String s) {
        if(s == "" || s.length() <= 0){
            return s;
        }
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = s1.length-1; i >= 0; i--){
            if(s1[i] == " " || s1[i].length()<=0){
                continue;
            }
            sb.append(s1[i]);
            sb.append(" ");
        }
        if(sb.length() <= 0){
            return sb.toString();
        }
        return sb.substring(0, sb.length() - 1);
    }


}
