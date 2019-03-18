package leetCode;

/**
 * 第六题 z形变换
 */
public class L0007_Zig_Zag_Conversion {

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 2);
        System.out.println(paypalishiring   );
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        StringBuilder[] sbs = new StringBuilder[numRows];
        StringBuilder res = new StringBuilder();

        //初始化sb
        for(int i = 0; i < sbs.length; i++){
            sbs[i] = new StringBuilder();
        }

        if(numRows == 1){
            return s;
        }
        int flag  = 0;
        for(int i = 0, j = 0; i < s.length(); i++){
            if(j == 0){
                flag = 1;
            }else if (j == (numRows-1)){
                flag = -1;
            }
            sbs[j].append(s.charAt(i));
            j += flag;

        }

        //返回返回值
        for(int i = 0; i < sbs.length; i++){
            res.append(sbs[i]);
        }
        return res.toString();
    }
}
