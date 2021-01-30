package 回溯;

import java.util.ArrayList;
import java.util.List;
//78. 子集
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
//解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
//
//
//
//示例 1：
//
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//示例 2：
//
//输入：nums = [0]
//输出：[[],[0]]

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> fuList = new ArrayList<>();
        fuList.add(new ArrayList<>());
        getZiList(fuList, new ArrayList<>(), nums, 0);
        return fuList;
    }

    public void getZiList(List<List<Integer>> fuList, List<Integer> ziList, int[] nums, int n){
        if(n == nums.length) {
            return;
        }else{
            for(int i = n; i < nums.length; i++){
                ziList.add(nums[i]);
                fuList.add(new ArrayList<>(ziList));
                getZiList(fuList,ziList,nums,i + 1);
                ziList.remove(ziList.size() - 1);
            }
        }
    }
}
