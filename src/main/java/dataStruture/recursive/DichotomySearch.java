package dataStruture.recursive;

/**
 * @Description
 *  二分法查找
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/7/26
 */
public class DichotomySearch {

    private static int dichotomySearch(int[] arr, int left, int right, int target){
        int mid = (left + right)/2;
        int temp = arr[mid];

        if(target > temp){
            return dichotomySearch(arr, mid +1, right, target);
        }else if( target < temp){
            return dichotomySearch(arr, left, mid-1, target);
        }else{
            return mid;
        }

    }
}
