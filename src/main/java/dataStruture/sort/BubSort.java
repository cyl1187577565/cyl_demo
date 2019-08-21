package dataStruture.sort;

/**
 * @Description 冒泡排序
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/24
 */
public class BubSort implements ISort {
    @Override
    public void sort(int[] a) {
        if(a == null || a.length == 0){
            return ;
        }
        for ( int i = a.length-1 ; i > 0; i--){
            for(int j=0 ; j < i; j++){
                if(a[j] > a[j+1]){
                    swap(a,j, j+1);
                }
            }
        }
    }

    public void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
