package leetCode;

/**
 * 10正则表达式匹配
 */
public class L0011_Regular_Expression_Matcher {
    public static void main(String[] args) {
        boolean ab = isMatch("aaa", "aaaa");
        System.out.println(ab);
    }
    public static boolean isMatch(String s, String p) {
        int i = s.length()-1;
        int j = p.length() -1;

        while (i >= 0 && j >= 0){
            if (p.charAt(j) == '.'){
                j--;
                i--;
            }else if(p.charAt(j) == '*'){
                j--;
                while (j>=0 && i >=0 && (p.charAt(j) == s.charAt(i) || '.' == p.charAt(j))){
                    i--;
                }
                j--;
            }else{
                if(p.charAt(j) != s.charAt(i)){
                    return false;
                }
                i--;
                j--;
            }
        }

        return i == -1 ;
    }

}
