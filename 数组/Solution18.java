package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//18. 四数之和
//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
//
//注意：
//
//答案中不可以包含重复的四元组。
//
//示例：
//
//给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
//
//满足要求的四元组集合为：
//[
//  [-1,  0, 0, 1],
//  [-2, -1, 1, 2],
//  [-2,  0, 0, 2]
//]
class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);                                      //排序数组
        for(int i = 0 ; i < nums.length - 3 ; i ++){
            if( i > 0 && nums[i] == nums[i-1]){                 //如果第一个数组元素和上一次的相同，直接跳过，否则添加相同的集合
                continue;
            }

            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3] > target){     //如果最小项都大于目标值，就不用判断以后了，直接跳出循环
                break;
            }

            if(nums[i]+nums[nums.length -1]+nums[nums.length -2]+nums[nums.length -3] < target){            //如果对于现在的这个最大项都小于目标值，则说明现在这个元素太小了，跳过
                continue;
            }

            for(int j = i+1 ; j < nums.length - 2; j++){                //二层循环，及第二个元素
                if( j > i+1 && nums[j] == nums[j-1]){                   //如果第一个数组元素和上一次的相同，直接跳过，否则添加相同的集合
                    continue;
                }

                int right = j+1;
                int left = nums.length -1;

                if(nums[i]+nums[j]+nums[right]+nums[right+1] > target){                         //如果最小项都大于目标值，就不用判断以后了，直接跳出循环
                    break;
                }

                if(nums[i]+nums[j]+nums[left]+nums[left - 1] < target){                         //如果对于现在的这个最大项都小于目标值，则说明现在这个元素太小了，跳过
                    continue;
                }
                while (right<left){                                                               //双指针探索法
                    int curr=nums[i]+nums[j]+nums[right]+nums[left];
                    if(curr==target){
                        list.add(Arrays.asList(nums[i],nums[j],nums[right],nums[left]));
                        right++;
                        while(right<left&&nums[right]==nums[right-1]){
                            right++;
                        }
                        left--;
                        while(right<left&&j<left&&nums[left]==nums[left+1]){
                            left--;
                        }
                    }else if(curr>target){
                        left--;
                    }else {
                        right++;
                    }
                }
            }
        }
        return list;
    }
}