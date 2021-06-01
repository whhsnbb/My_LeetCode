package 数学;

import java.util.Arrays;

//781. 森林中的兔子
//森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。
//
//返回森林中兔子的最少数量。
//
//示例:
//输入: answers = [1, 1, 2]
//输出: 5
//解释:
//两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
//之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
//设回答了 "2" 的兔子为蓝色。
//此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
//因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
//
//输入: answers = [10, 10, 10]
//输出: 11
//
//输入: answers = []
//输出: 0
class Solution781 {
    public int numRabbits(int[] answers) {
        //找规律发现，数组出现的数字最多不能出现answes[i]+1次，如果不超过那么相同颜色就是answers[i]+1个，如果超过，超过的另算就行了
        Arrays.sort(answers);
        int i = 0,count = 0;
        int j = i + 1;
        while(i < answers.length){
            int nums = 1;                       //出现次数
            while(j < answers.length && answers[j] == answers[i] && nums < (answers[i]+1)){ //用是否相等和出现次数做判断
                j++;
                nums++;
            }
            count+=answers[i]+1;
            i=j;
            j++;
        }
        return count;
    }
}
