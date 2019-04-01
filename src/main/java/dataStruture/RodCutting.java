package dataStruture;

/**
 * 锯条切割
 */
public class RodCutting {
    public static void main(String[] args) {
        int i = rodCut3(5);
        System.out.println(i);
    }

    static int[] profs = {0,1,5,8,9,10,17,17,20,24,30};

    /**
     * 自顶而下的递归方法
     * @param n
     * @return
     */
    static int rotCut( int n){
        if (n == 0){
            return 0;
        }else{
            int profit = 0;
            for(int i = 1 ; i <= n ; i++){
                profit = Math.max(profit, profs[i]+ rotCut( n-i));
            }
            return profit;
        }
    }

    /**
     * 自顶而下的备忘录法
     * @param n
     * @return
     */
    static int rodCut2(int n){
        int[] maxProfs = new int[n+1];
        for(int i = 0 ;i <= n ; i++){
            maxProfs[i] = -1;
        }

        return rotCutAssist(maxProfs,n);

    }

    static int rotCutAssist(int[] maxProfs, int n){
        if(maxProfs[n] != -1){
            return maxProfs[n];
        }
        int profit = 0;
        if(n == 0){
            profit = 0;
        }else{
            for(int i = 1; i<= n ; i++){
                profit = Math.max(profit, profs[i] + rotCutAssist(maxProfs, n-i));
            }
        }
        maxProfs[n] = profit;
        return maxProfs[n];
    }


    /**
     * 自下而上的动态规划法
     * @param n
     * @return
     */
    static int rodCut3(int n){
        if (n == 0){
            return 0;
        }

        int[] maxProfs = new int[n+1];
        maxProfs[0] = 0;

        for(int i = 1; i <= n; i++){
            int profit = 0;

            for(int j = 1; j<= i; j++){
                profit = Math.max(profit, profs[j]+maxProfs[i-j]);
            }
            maxProfs[i] = profit;

        }
        return maxProfs[n];
    }
}
