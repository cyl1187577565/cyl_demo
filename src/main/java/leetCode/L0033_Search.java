package leetCode;

/**
 *搜索旋转排序数组 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 */
public class L0033_Search {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int search = search(nums, 3);
        System.out.println(search);
    }

    public static int search(int[] nums, int target){
        if(nums == null || nums.length <= 0){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        int mid;
        while (left <= right){
            mid = (left + right)/2;
            if(nums[mid] == target){
                return mid;
            }
            //判断左半部分是否是有序
            if((mid-1)>= left && nums[left] <= nums[mid-1]){
                //左半部分有序
                //判断target是否在左半部分
                if((mid-1)>= left && target >= nums[left] && target<= nums[mid-1]){
                    //在左半部分,利用二分法查找
                    return binarySearch(nums,left,mid-1,target);
                }else{
                    //可能在右半部分
                    left = mid+1;
                }
            }else{
                //右半部分有序
                //判断target是否在右半部分
                if((mid+1)<= right && target >= nums[mid+1] && target<= nums[right]){
                    //在右半部分，利用二分法查找
                    return binarySearch(nums,mid+1,right,target);
                }else{
                    //可能在左半部分
                    right = mid-1;
                }

            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums,int left, int right, int target){
        while (left<=right){
            int mid = (left + right)/2;
            if(target > nums[mid]){
                left = mid +1;
            }else if(target < nums[mid]){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
