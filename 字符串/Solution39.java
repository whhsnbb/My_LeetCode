package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//39. 组合总和
//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的数字可以无限制重复被选取。
//
//说明：
//
//所有数字（包括 target）都是正整数。
//解集不能包含重复的组合。
//示例 1：
//
//输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
//示例 2：
//
//输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//]
class Solution39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        getList(0,list,candidates,target,new ArrayList<>());
        return list;
    }

    public void getList(int start, List<List<Integer>> fuList,int[] candidates, int target, List<Integer> ziList){
        if(target == 0){
            fuList.add(new ArrayList<>(ziList));    //一定要传一个新数组，不能直接传入ziList，否则为空
        }
        if(target > 0){
            for(int i = start ;i < candidates.length ; i ++){
                if(candidates[i] <= target){
                    ziList.add(candidates[i]);      //如果当前元素小于target，就可以将此元素加入集合
                    getList(i,fuList,candidates,target - candidates[i],ziList);         //进行下一次遍历
                    ziList.remove(ziList.size() - 1);                                   //记得回溯完成以后删除已经添加到集合中的元素，以便进行下一次遍历
                }
            }
        }
    }
}
