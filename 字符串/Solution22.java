package 字符串;

import java.util.ArrayList;
import java.util.List;
//22. 括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
//示例：
//
//输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
class Solution22 {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        getPosition(new StringBuilder(),list,0,0,n);
        return list;
    }

    //res 是已存在的字符串，list是存符合条件括号的集合，Lnum是res中左括号的个数，Rnum是res中有括号的个数，n是题目中的n
    public void getPosition(StringBuilder res,List<String> list , int Lnum, int Rnum, int n){
        if(Lnum < n){
            if(Rnum < Lnum){
                StringBuilder sb = new StringBuilder(res);
                getPosition(res.append("("), list, Lnum + 1 , Rnum, n);
                getPosition(sb.append(")"), list, Lnum, Rnum + 1 , n);
            }
            if(Rnum == Lnum){
                getPosition(res.append("("),list,Lnum+1,Rnum,n);
            }
        }
        if(Lnum == n){
            if(Rnum < n){
                getPosition(res.append(")"), list, Lnum, Rnum + 1, n);
            }
            if(Rnum == n){
                list.add(res.toString());
            }
        }
    }
}
