package 字符串;

import java.util.LinkedList;
//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
//有效字符串需满足：
//
//左括号必须用相同类型的右括号闭合。
//左括号必须以正确的顺序闭合。
//注意空字符串可被认为是有效字符串。
//
//示例 1:
//
//输入: "()"
//输出: true
//示例 2:
//
//输入: "()[]{}"
//输出: true
//示例 3:
//
//输入: "(]"
//输出: false
//示例 4:
//
//输入: "([)]"
//输出: false
//示例 5:
//
//输入: "{[]}"
//输出: true
class Solution20 {
    public boolean isValid(String s) {

        LinkedList <Character> stack = new LinkedList <>();

        for (char c: s.toCharArray()){
            if (c == '[') stack.push(']'); //如果是右括号，则入栈左括号
            else if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if(stack.isEmpty()||c!=stack.pop())        //如果弹出的左括号不匹配或者栈已空，返回false
                return false;
        }
        return stack.isEmpty();
    }
}