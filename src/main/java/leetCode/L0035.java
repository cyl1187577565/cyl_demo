package leetCode;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/30
 * 35. 搜索插入位置
 */
/*给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

 你可以假设数组中无重复元素。*/
public class L0035 {

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int mid = (left + right) /2;
            if(nums[mid] < target){
                left = mid +1;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                return mid;
            }
        }

        if(nums[left] >= target){
            return left;
        }else{
            return left +1;
        }
    }
}
