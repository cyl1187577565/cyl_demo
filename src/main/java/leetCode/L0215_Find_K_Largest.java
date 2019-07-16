package leetCode;

/**
 *数组中的第K个最大元素
 */
public class L0215_Find_K_Largest {
    public static void main(String[] args) {

        L0215_Find_K_Largest l0215_find_k_largest = new L0215_Find_K_Largest();
        int[] a = {3,2,3,1,2,4,5,5,6};
        int kthLargest = l0215_find_k_largest.findKthLargest(a, 4);
        System.out.println(kthLargest);
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length <= 0){
            return -1;
        }
        quickSort(nums,0, nums.length-1);
        int index = nums.length-k;
        if(index < 0){
            return -1;
        }
        return nums[index];
    }

    private void quickSort(int[] a, int left, int right){
        if(left < right){
            int pivot = a[right];
            int i = left, j = right;
            while (i < j){
                while (i < right && a[i] <= pivot  ){
                    i++;
                }
                while(j > 0 &&a[j] >= pivot){
                    j--;
                }
                if( i<j){
                    exchange(a,i,j);
                }
            }
            exchange(a, i, right);
            quickSort(a, left, i-1);
            quickSort(a, i+1, right);
        }
    }
    private void exchange(int[]a, int i1, int i2){
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
    }
}
