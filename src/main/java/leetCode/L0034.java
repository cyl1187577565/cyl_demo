package leetCode;

import com.alibaba.fastjson.JSON;

/**
 * @Description
 * @Author dianXiao2
 * @Version V1.0.0
 * @Date 2019/9/30
 */
public class L0034 {

    public static void main(String[] args) {
        int[]  res = {5,7,7,8,8,10};

        int[] ints = searchRange(res, 6);
        System.out.println(JSON.toJSONString(ints));
    }
/*
    给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

    你的算法时间复杂度必须是 O(log n) 级别。

    如果数组中不存在目标值，返回 [-1, -1]。

    来源：力扣（LeetCode）
    */
    public static int[] searchRange(int[] nums, int target) {
        int leftIndex = -1;
        int rightIndex = -1;

        int[] res = new int[2];
        res[0] = leftIndex;
        res[1] = rightIndex;
       if(nums == null || nums.length == 0){

           return res;
       }

       int left = 0;
       int right = nums.length -1;
       //首先寻找做边界
       while (left <= right){
           int mid = (left + right) /2;
           if(nums[mid] > target){
               right = mid-1;
           }else if(nums[mid] < target){
               left = mid+1;
           }else{
               //判断mid是否还能够做减一的操作
               if(mid - 1 >= left && nums[mid -1] == target){
                   right = mid-1;
               }else{
                   leftIndex = mid;
                   break;
               }
           }
       }

       //如果没有找到左边界， 则说明在目标数组中， 这个数字不存在， 可以直接返回了
       if(leftIndex == -1){
           return  res;
       }

       //找到了左边界后， 需要寻找右边界
        left = leftIndex;
        right = nums.length-1;
        while (left <= right){
            int mid = (left + right)/2;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                //判断mid加一是否还能够做加一的操作
                if((mid+1) <= right && nums[mid+1] == target){
                    left = mid +1;
                }else{
                    rightIndex = mid;
                    break;
                }
            }
        }

        res[0] = leftIndex;
        res[1] = rightIndex;
        return res;
    }
}
