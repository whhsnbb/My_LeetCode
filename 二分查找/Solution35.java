package 二分查找;
//35. 搜索插入位置
//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
//你可以假设数组中无重复元素。
//
//示例 1:
//
//输入: [1,3,5,6], 5
//输出: 2
//示例 2:
//
//输入: [1,3,5,6], 2
//输出: 1
//示例 3:
//
//输入: [1,3,5,6], 7
//输出: 4
//示例 4:
//
//输入: [1,3,5,6], 0
//输出: 0
class Solution35 {
    //二分查找法
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)    return 0;
        int len = nums.length;

        if (nums[len -1] < target) {
            return len;
        }
        int right = len -1 , left = 0;
        while(left < right){

            int mid = (left + right) / 2;   //让mid是前取整的中间数
            if(nums[mid] == target) {
                return mid;                 //如果中间数就是目标值，数排名就插入这个位置
            }

            if(nums[mid] < target){             //如果target比中间数大，说明下一次查找区间为[mid+1,right]
                left = mid + 1;
            }else{
                right = mid;                    //如果target比中间数小，说明下一次查找区间为[left,mid];
            }
        }
        return left;                            //返回循环后的地方left，因为left最多只可能到达len - 1的地方，所以要加一个特判就是如果nums[len-1]<target就直接返回len;
    }
}