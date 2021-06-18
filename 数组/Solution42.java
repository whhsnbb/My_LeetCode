package 数组;
//42. 接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

//示例 1：
//
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//示例 2：
//
//输入：height = [4,2,0,3,2,5]
//输出：9
class Solution42 {
    //按列求雨水
    public int trap(int[] height) {
        int sum = 0;            //雨水总量
        int max_left = 0;                           //这个代表正在求的这一列左边最高的高度
        int[] max_right = new int[height.length];       //这个代表正在求的这一列右边最高的高度
        for(int i = height.length - 2; i >= 0; i--){
            max_right[i] = Math.max(max_right[i+1],height[i+1]);        //右边最高高度就是右边挨着的高度与它所对应的右边最高高度作比较，谁大取谁
        }
        for(int i = 1 ; i < height.length ; i++){
            max_left = Math.max(height[i-1],max_left);
            if(height[i] < Math.min(max_right[i],max_left)){         //如果两边的最高高度中最小的那个都大于该列高度，就说明有雨水形成
                sum += Math.min(max_right[i],max_left)-height[i];
            }
        }
        return sum;
    }
}
