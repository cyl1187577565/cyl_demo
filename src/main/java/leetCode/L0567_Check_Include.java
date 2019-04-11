package leetCode;

import org.springframework.util.StringUtils;

import java.util.*;

/**
 * 567字符串的排列
 */
public class L0567_Check_Include {

    public static void main(String[] args) {
        boolean b = checkInclusion("adc", "dcda");
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int size = s1.length();
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++){
            list.add(s1.charAt(i));
        }

        for(int i = 0; i <= s2.length()-size; i++){
            List<Character> temp = new ArrayList<>(list);
            if(temp.contains(s2.charAt(i))){
                temp.remove((Character)s2.charAt(i));
                int k = 1;
                while ( k < size){
                    if(temp.contains(s2.charAt(i+k))){
                        if(k == size-1){
                            return true;
                        }
                        temp.remove((Character)s2.charAt(i+k));
                        k++;
                    }else{
                        k = size;
                    }
                }
            }
        }
        return false;
    }

}
