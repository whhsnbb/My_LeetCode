package 二分查找;
//153. 寻找旋转排序数组中的最小值
//已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
//若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
//若旋转 4 次，则可以得到 [0,1,2,4,5,6,7]
//注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
//
//给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
//
//
//
//示例 1：
//
//输入：nums = [3,4,5,1,2]
//输出：1
//解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
//示例 2：
//
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
//解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
//示例 3：
//
//输入：nums = [11,13,15,17]
//输出：11
//解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
class Solution153 {
    public int findMin(int[] nums) {
        int len = nums.length;      //数组长度
        if(len == 1){
            return nums[0];                 //只有一个元素就返回这个数
        }
        int left = 0 , right = len -1;          //定义左右指针
        while(left <= right){

            int mid = (left + right) / 2;               //找到中间数的索引
            if(left == right || left == mid){           //[2,1]这个数据如果直接返回左侧就有错，所以返回左右中最小的
                return nums[left] > nums[right] ? nums[right] : nums[left];         //如果左指针和右指针或中指针相同时，返回左右中最小的一个；
            }

            if(nums[left] < nums[mid] && nums[mid] < nums[right]){        //如果序列成升序，直接返回最左侧的数
                return nums[left];
            }else if(nums[left] < nums[mid] && nums[mid] > nums[right]){    //如果中间最大，说明右边是更小的小序列
                left = mid + 1;
            }else if(nums[left] > nums[mid] && nums[mid] < nums[right]){    //如果中间比两边都小，就让left动知道直到left到达最小的
                left ++;
            }else if(nums[left] > nums[mid] && nums[mid] > nums[right]){        //如果序列成降序，就返回最右侧的数
                return nums[right];
            }
        }
        return 0;
    }
}
