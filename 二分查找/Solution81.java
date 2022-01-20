package 二分查找;
//81. 搜索旋转排序数组 II
//已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
//
//在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
//
//给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
//
//
//
//示例 1：
//
//输入：nums = [2,5,6,0,0,1,2], target = 0
//输出：true
//示例 2：
//
//输入：nums = [2,5,6,0,0,1,2], target = 3
//输出：false
public class Solution81 {
    public boolean search(int[] nums, int target) {
        //二分查找
        int len = nums.length;//数组长度
        if(len == 0){
            return false;      //数组长度为0，直接返回false
        }
        if(len == 1){
            return nums[0] == target;   //数组长度为1，就直接看着个数和目标值是否相等
        }
        int left = 0 ,right = len -1;       //设置最初的左节点和右节点
        while(left <= right){
            int mid = (left +right)/2;      //找到中间节点

            if(nums[mid] == target){        //如果中间节点这个恰好是目标值直接返回true
                return true;
            }

            if(nums[mid] == nums[left] && nums[mid] == nums[right]){        //因为题目中说可能会有相同元素，为防止1,0,1,1,1这种情况，所以加此判断条件
                left ++;
                right --;
            }else if (nums[left] <= nums[mid]) {                            //如果左有序
                if (nums[left] <= target && target < nums[mid]) {               //在左半边的话，right左移一位，缩小范围
                    right = mid - 1;
                } else {
                    left = mid + 1;                                             //在右半边的话，left右移一位缩小范围
                }
            } else {                                                        //右有序
                if (nums[mid] < target && target <= nums[len - 1]) {            //在右半边的话，left右移一位缩小范围
                    left = mid + 1;
                } else {
                    right = mid - 1;                                            //在左半边的话，right左移一位，缩小范围
                }
            }
        }
        return false;
    }
}
