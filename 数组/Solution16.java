package 数组;

import java.util.Arrays;

//16. 最接近的三数之和
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//
//
//示例：
//
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0 ; i < len; i ++){
            if(i > 0 && nums[i-1] == nums[i])   continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int value = nums[i] + nums[right] + nums[left];

                if (value == target) {
                    return value;
                }

                if(Math.abs(min - target) > Math.abs(value - target)){
                    min = value;
                }

                if(value - target > 0){
                    right --;
                }else{
                    left ++;
                }
            }
        }
        return min;
    }
}