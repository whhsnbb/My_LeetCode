package 数组;
//45. 跳跃游戏 II
//给定一个非负整数数组，你最初位于数组的第一个位置。
//
//数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//你的目标是使用最少的跳跃次数到达数组的最后一个位置。
//
//示例:
//
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
class Solution45 {
    public int jump(int[] nums) {
        int sum = 0;
        if(nums.length == 1)            //如果数组长度为1 就说明不用走
            return 0;
        for(int i = 0; i < nums.length;){
            if(nums[i] + i + 1 >= nums.length){    //如果位于i处的数字+i >= 数组长度，说明就可以走一步完成
                sum += 1;
                return sum;
            }
            int max = 0;
            int flag = 0;
            for(int j = 1; j <= nums[i]; j++){      //如果位于i处的数字+i < 数组长度,说明就要选出最短路径，就依次看（走出<=该处数字+下一步落点数字）谁更大，更大的占优势。
                if(max < j + nums[i+j]){
                    max = j + nums[i+j];
                    flag = i+j;
                }
            }
            sum += 1;                               //走到下一个优势位置，花费一步
            i = flag;                               //让i变到下一次的优势位置
        }
        return sum;
    }
}
