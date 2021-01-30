package 回溯;

import java.util.ArrayList;
import java.util.List;
//46. 全排列
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
//示例:
//
//输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        boolean[] numB = new boolean[nums.length]; //创建一个等大的boolean数组，false说明smallList里没有这个数，true说明smallList有这个数
        getFullPermutation(bigList, new ArrayList<>(), nums,numB, 0);
        return bigList;
    }

    public void getFullPermutation(List<List<Integer>> bigList, List<Integer> smallList, int[] nums,boolean[] b,int n){
        if(n != nums.length - 1){
            for(int i = 0 ; i < nums.length ; i ++){
                if(!b[i]){  //判断smallList里是否有nums[i]这个数
                    smallList.add(nums[i]);   //没有就将nums[i]添加进来
                    b[i] = true;              //改变i对应的boolean值
                    getFullPermutation(bigList,smallList,nums,b,n+1);   //回溯
                    smallList.remove(smallList.size() - 1);         //回溯完了记得删掉最后一位
                    b[i] = false;                                         //因为删掉了所以list里面就没有了，boolean值发生变化
                }
            }
        }else{
            bigList.add(new ArrayList<>(smallList));                //n == nums.length说明已经搜到尾部了，不用再搜了
        }
    }
}
