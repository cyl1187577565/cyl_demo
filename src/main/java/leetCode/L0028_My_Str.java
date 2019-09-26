package leetCode;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/26
 * 28. 实现 strStr()
 */
public class L0028_My_Str {

    public static int strStr(String haystack, String needle) {
        if( haystack == null || needle == null || haystack.length() < needle.length() ){
            return -1;
        }

        if (needle.length() == 0){
            return 0;
        }

        char[] text = haystack.toCharArray();
        char[] pattern = needle.toCharArray();

        int textLength = text.length;
        int patternLength = needle.length();

        for (int i = 0; i <= textLength - patternLength; i++) {
            int j =0;
            int temp = i;
            for(; j < patternLength; j++){
                if(text[temp] == pattern[j]){
                    temp++;
                }else {
                    break;
                }
            }
            if(j == patternLength){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        strStr("a", "a");
    }
}
