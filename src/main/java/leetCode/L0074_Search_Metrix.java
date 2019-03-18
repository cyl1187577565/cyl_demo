package leetCode;

/**
 * 74
 * 搜索
 */
public class L0074_Search_Metrix {


    /**
     * 每次比较右上角的数字
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1){
            return false;
        }
       int i = 0 ;
       int j = matrix[0].length - 1;
       while (i < matrix.length && j >= 0){
           if ( matrix[i][j] > target){
               //比目标值大则去除该列
               j--;
           }else if(matrix[i][j] < target){
               //比目标值小则去除该行
               i++;
           }else{
               return true;
           }
       }
       return false;
    }
}
