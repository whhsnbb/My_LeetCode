package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//90. 子集 II
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
//
//
//
//示例 1：
//
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]
class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> fuList = new ArrayList<>();
        fuList.add(new ArrayList<>());
        Arrays.sort(nums);          //必须先排序，否则会出现一些案例无法通过
        boolean[] b = new boolean[nums.length];
        getZiList(fuList, new ArrayList<>(), nums,b, 0);
        return fuList;
    }

    public void getZiList(List<List<Integer>> fuList, List<Integer> ziList, int[] nums,boolean[] b, int n){
        if(n == nums.length) {
            return;
        }else{
            for(int i = n; i < nums.length ; i++){
                if(i > 0 && nums[i-1] == nums[i] && !b[i-1]){   //b数组是判断i这个数是不是子集合中重复的，重复就continue
                    continue;
                }
                if(!b[i]) {         //如果不是重复的
                    b[i] = true;        //先将这个数设为重复，以方便后面判断
                    ziList.add(nums[i]);
                    fuList.add(new ArrayList<>(ziList));
                    getZiList(fuList, ziList, nums, b, i + 1);
                    ziList.remove(ziList.size() - 1);
                    b[i] = false;               //子集合移除这个元素后，就将这个判断移除
                }
            }
        }
    }
}
