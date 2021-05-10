package 数组;
//55. 跳跃游戏
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//判断你是否能够到达最后一个下标。
//
//
//
//示例 1：
//
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//示例 2：
//
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
class Solution55 {
    //贪心算法
    public boolean canJump(int[] nums) {
        int len = nums.length;     //数组长度
        int max = 0;                    //定义最大可到达处
        for(int i = 0 ; i < len ; i++){
            if(i <= max){           //如果现在所在位置<=最大可到达处
                max =Math.max(i + nums[i], max);    //看看nums[i] + i和max哪个大，将大的赋值给max
                if(max >= len - 1)                  //看看变化后的max有没有到达最后一位，如果到达最后一位直接返回true
                    return true;
            }else{                              ////如果现在所在位置>最大可到达处,说明走不到这个地方，这里直接返回false
                return false;
            }
        }
        return false;
    }
}
