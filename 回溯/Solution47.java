package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//47. 全排列 II
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
//
//
//示例 1：
//
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//示例 2：
//
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        boolean[] b = new boolean[nums.length];
        Arrays.sort(nums);
        getFullPermutation(bigList,new ArrayList<>(),nums,b,0);
        return bigList;
    }

    public void getFullPermutation(List<List<Integer>> bigList, List<Integer> smallList, int[] nums, boolean[] b, int n) {
        if (n != nums.length) {
            for (int i = 0; i < nums.length; i++) {
                if(i > 0 && nums[i-1] == nums[i] && !b[i-1]){
                    continue;                               //比Solution46多了一个剪枝操作
                }
                if (!b[i]) {
                    b[i] = true;
                    smallList.add(nums[i]);
                    getFullPermutation(bigList, smallList, nums, b, n + 1);
                    smallList.remove(smallList.size() - 1);
                    b[i] = false;
                }
            }
        }else{
            bigList.add(new ArrayList<>(smallList));
        }
    }
}