package 字符串;

import java.util.ArrayList;

//6. Z 字形变换
//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
//
//比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
//
//请你实现这个将字符串进行指定行数变换的函数：
//
//string convert(string s, int numRows);
//示例 1:
//
//输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
//示例 2:
//
//输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G
public class Solution6 {
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;               //如果行数小于2，就不能使用z字换行了
        }

        ArrayList<StringBuilder> list = new ArrayList<>();      //创建一个存储StringBuilder的列表

        for(int i = 0 ; i < numRows; i++){
            list.add(new StringBuilder());              //在列表里创建几个StringBuilder()
        }

        int i = 0 , flag = -1;                      //i时行数，flag是标志，-1是向上行走，1是向下行走

        for(char c : s.toCharArray()){
            list.get(i).append(c);                  //存入字符
            if(i == 0 || i == numRows - 1){
                flag = - flag;                      //如果到达最上行，或者最下行，就可以反转flag，进行翻转了
            }
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder sb:list){
            res.append(sb);
        }

        return res.toString();
    }
}
