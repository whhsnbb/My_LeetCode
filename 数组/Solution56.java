package 数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
//56. 合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
class Solution56{
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>(); //相当于一个动态数组
        int len = intervals.length;
        int[] newints;                              //动态数组里的每一个元素
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); //先根据元素第一位排序成有序数组，方便后面合并数组
        newints = intervals[0];
        for(int i = 1 ; i < len ; i++){
            if(newints[1] >= intervals[i][0])           //比较前元素第二个数和后元素第一个数，以此判断是否可以合并
            {
                if(newints[1] < intervals[i][1])        //可以合并，就看两个元素哪个后面的数大，依此看区间大小
                    newints[1] = intervals[i][1];
            }else{                                      //不可以合并，将元素添加进集合，然后新定义元素
                list.add(newints);
                newints = intervals[i];
            }
        }
        list.add(newints);                              //最后无论如何都会少将最后一个新元素添加，在for循环外添加即可。
        return list.toArray(new int[list.size()][]);    //返回集合转成数组后的结果
    }
}