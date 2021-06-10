package 数组

import java.util.ArrayList
import java.util.LinkedList
import java.util.Arrays

//15. 三数之和
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//
//
//示例：
//
//给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
internal class Solution15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val list: MutableList<List<Int>> = LinkedList()
        if (nums.size < 3) {         //如果数组长度不够3，那么直接返回一个空集合
            return list
        }
        Arrays.sort(nums) //将数组排序
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break //如果最小的那一位都大于0了，就直接不用判断了
            if (i > 0 && nums[i - 1] == nums[i]) {        //如果最小的一位和之前的那一位相同，说明已经判断过了，不用再判断了
                continue
            }
            var left = i + 1 //将下一位定义为left
            var right = nums.size - 1 //将最后一位定义为right
            while (left < right) {
                if (nums[i] + nums[right] + nums[left] == 0) {      //三者相加等于0
                    list.add(ArrayList(Arrays.asList(nums[i], nums[left], nums[right]))) // 添加进集合里
                    left++ //左边往右移
                    right-- //右边往左移
                    while (left < right && nums[left] == nums[left - 1]) left++ //移动以后，如果等于前一位，继续移动
                    while (left < right && nums[right] == nums[right + 1]) right--
                } else if (nums[i] + nums[right] + nums[left] < 0) {                       //如果三者相加小于0，说明左边的太小了，左边右移
                    left++
                } else {
                    right-- //如果三者相加大于0，说明右边太大了，右边左移
                }
            }
        }
        return list
    }
}