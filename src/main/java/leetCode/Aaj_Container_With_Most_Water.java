package leetCode;

/**
 * 11  装水最多的水桶
 */
public class Aaj_Container_With_Most_Water {


    public static void main(String[] args) {
        int i = maxArea(new int[]{1,1});
        System.out.println(i);
    }

    /**
     * 双指针发
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int res = 0;


        while (i<=j){
            res = Math.max((j-i) * Math.min(height[i],height[j]),res);
            if(height[i]< height[j]){
                i++;
            }else{
                j--;
            }
        }
        return res;
    }
}
