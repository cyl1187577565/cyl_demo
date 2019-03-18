package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 20   有效的括号
 */
public class L0020_Valid_Parenthese {

    public static void main(String[] args) {
        String test = "([)]";
        boolean valid = isValid(test);
        System.out.println(valid);
    }
    public static boolean isValid(String s) {

        char temp ;
        List<Character> statck = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    ((LinkedList<Character>) statck).push(s.charAt(i));
                    break;
                case '{':
                    ((LinkedList<Character>) statck).push(s.charAt(i));
                    break;
                case '[':
                    ((LinkedList<Character>) statck).push(s.charAt(i));
                    break;
                case ')':{

                    if(statck == null || statck.size() <= 0){
                        return false;
                    }
                    temp = ((LinkedList<Character>) statck).pop();
                    if (temp != '('){
                        return false;
                    }
                    break;

                }
                case '}':{
                    if(statck == null || statck.size() <= 0){
                        return false;
                    }
                    temp = ((LinkedList<Character>) statck).pop();
                    if(temp !='{'){
                        return false;
                    }
                    break;
                }
                case ']':{
                    if(statck == null || statck.size() <= 0){
                        return false;
                    }
                    temp = ((LinkedList<Character>) statck).pop();
                    if(temp != '['){
                        return false;
                    }
                    break;
                }
                default:
                    return true;
            }
        }
        return statck.isEmpty();

    }
}
