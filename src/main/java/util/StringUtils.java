package util;


import java.io.UnsupportedEncodingException;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/8/8
 */
public class StringUtils {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String test = "\uAB37\uAB37\uFFDF\uFFDF\uAB37\uAB37";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < test.length(); i++){
            char a = (char) (test.charAt(i)^Integer.MAX_VALUE);
            sb.append(a);
        }
        System.out.println(sb.toString());
    }


}
