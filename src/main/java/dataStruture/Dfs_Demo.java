package dataStruture;

public class Dfs_Demo {

    public static void main(String[] args) {

    }

    public static boolean dfs(int n,int k,int[] a,int i, int sum){
        if( i == n){
            return sum == k;
        }
        //不加i的情况下
        if(dfs(n, k, a,i+1,sum)){
            return true;
        }
        //加上i的情况下
        if(dfs(n,k,a,i+1, sum + a[i])){
            return true;
        }
        return false;
    }
}
