package 数组;
//41. 缺失的第一个正数
//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//
//
//
//进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
//
//
//
//示例 1：
//
//输入：nums = [1,2,0]
//输出：3
//示例 2：
//
//输入：nums = [3,4,-1,1]
//输出：2
//示例 3：
//
//输入：nums = [7,8,9,11,12]
//输出：1
class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int min = findMinSum(nums,1);       //从一开始找
        return min;
    }

    public int findMinSum(int[] nums ,int min) {
        for(int i = 0 ; i < nums.length ; i++){         //遍历数组，如果没找到min，就说明缺少min，如果找到了，就min+1，递归继续找，知道找不到最小的min
            if(min == nums[i]){
                min = findMinSum(nums,min + 1);
                break;
            }
        }
        return min;
    }
}