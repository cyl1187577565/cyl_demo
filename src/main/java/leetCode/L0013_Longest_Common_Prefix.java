package leetCode;

/**
 * 14 最长公共前缀
 */
public class L0013_Longest_Common_Prefix {

    /**
     * 水平扫描法
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length <= 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 0; i < strs.length; i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix == null || "".equals(prefix)){
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * 水平扫描法2
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs){

        if(strs == null || strs.length <=0){
            return "";
        }

        for(int i = 0; i < strs[0].length(); i++){
            Character c = strs[0].charAt(i);

            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
