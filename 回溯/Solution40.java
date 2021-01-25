package 回溯;
//40. 组合总和 II
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次。
//
//说明：
//
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//示例 2:
//
//输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);      //无序数组先排序
        List<List<Integer>> list = new ArrayList<>();
        getSonList(list,0,target,candidates,new ArrayList<>());
        return list;
    }

    public void getSonList(List<List<Integer>> list, int start, int target, int[] candidates, List<Integer> ziList){ //回溯法
        if(target==0){
            list.add(new ArrayList<>(ziList));
        }else if(target > 0){
            for(int i = start; i < candidates.length ; i++){
                if(target - candidates[i] < 0) //         （大剪枝）如果这里目标值减后都小于零了，后面更大的数字就不用看了。
                    break;
                if (i > start && candidates[i] == candidates[i - 1]) { //（小剪枝） 示意图如下
                    continue;
                }
                /*
                  1
                 / \
                2   2  这种情况不会发生 但是却允许了不同层级之间的重复即：
               /     \
              5       5
                  1
                 /
                2      这种情况确是允许的
               /
              2  */
                ziList.add(candidates[i]);
                getSonList(list,i+1,target-candidates[i],candidates,ziList); //继续搜下一个
                ziList.remove(ziList.size() - 1);//搜完记得删除
            }
        }
    }
}
