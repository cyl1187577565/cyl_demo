package leetCode;


import com.alibaba.fastjson.JSON;

/**
 * 88合并两个有序数组
 */
public class L0088_Merge_2_array {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        merge(nums1, 2, nums2, 1);
        System.out.println(JSON.toJSONString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int j = 0; j < n; j++){
                nums1[j] = nums2[j];
            }
            return;
        }
        int right = m + n - 1;
        while (m > 0 && n > 0){
            if (nums1[m-1] > nums2[n-1]){
                nums1[right] = nums1[m-1];
                m--;
            }else{
                nums1[right] = nums2[n-1];
                n--;
            }
            right--;
        }
        if(n != 0){
            for(int i = 0; i < n; i++){
                nums1[i] = nums2[i];
            }
        }
    }
}
