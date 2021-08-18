package 字符串;
import java.util.Deque;
import java.util.LinkedList;
//32. 最长有效括号
//给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
//
//示例 1:
//
//输入: "(()"
//输出: 2
//解释: 最长有效括号子串为 "()"
//示例 2:
//
//输入: ")()())"
//输出: 4
//解释: 最长有效括号子串为 "()()"
class Solution32 {
    //栈
    public int longestValidParentheses(String s) {
        int max = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0 ; i < s.length() ; i ++){
            if(s.charAt(i) == '(')
                stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}