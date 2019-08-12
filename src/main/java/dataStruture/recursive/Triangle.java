package dataStruture.recursive;

/**
 * @Description
 *  三角函数
 *  序列 1 2 3 6 10 15 21
 *  F(n) = F(n-1) + n;
 *  F(0) = 0;
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/26
 */
public class Triangle {

    public static void main(String[] args) {
        int result = triangle2(5);
        System.out.println(result);
    }

    /**
     * 递归
     * @param n
     * @return
     */
    public static int triangle(int n){
        if(n == 0){
            return 0;
        }

        return triangle(n-1) + n;
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    private static int triangle2(int n) {
        int[] triangles = new int[n+1];
        triangles[0] = 0;

        for(int i = 1; i <= n; i++){
            triangles[i] = triangles[i-1] + i;
        }

        return triangles[n];
    }
}
