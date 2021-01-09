package 二分查找;
//33. 搜索旋转排序数组
//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
//
//请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//
//
//
//示例 1：
//
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
//示例 2：
//
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//示例 3：
//
//输入：nums = [1], target = 0
//输出：-1
class Solution33 {
    //其实就是二分查找法
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }

        int left = 0, right = len -1;
        while(left <= right){
            int mid = (left + right) / 2;               //找出中间数的索引

            if(nums[mid] == target){                    //如果中间数等于目标值，则返回
                return mid;
            }

            if(nums[0] <= nums[mid]){                  //如果最左边的数小于中间值，说明左半部分是有序的
                if(target < nums[mid] && target >= nums[0]){     //如果目标值在左半边，right就变成mid-1缩小范围
                    right = mid - 1;
                }else{
                     left = mid + 1;                              //如果不在左半边，left就变成mid+1缩小范围
                }
            }else{                                     //与上面情况相反，右半边有序
                if(target <= nums[len-1] && target > nums[mid]){        //如果目标值在右半边，left就变成mid+1缩小范围
                    left = mid + 1;
                }else{
                    right = mid -1;                                    //如果不在右半边，right就变成mid-1缩小范围
                }
            }
        }
        return -1;
    }
}
