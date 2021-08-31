package 字符串;
//316. 去除重复字母
//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
//
//注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
//
//
//
//示例 1：
//
//输入：s = "bcabc"
//输出："abc"
//示例 2：
//
//输入：s = "cbacdcbc"
//输出："acdb"
class Solution316 {
//主要解题思路，差不多是栈吧，先看看进去的元素在栈里存在不，存在的话直接跳过，不存在的话和栈顶的元素作比较，
//如果比栈顶元素小，就要看看之后的字符串里还有没有这个栈顶元素，如果没有就不能移除栈顶元素，如果有才可以移除，为了保证字典序
//最后循环出来以后，看看这个栈里有没有这个元素，没有的话把它添加进去
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();  //建立一个，相当于栈
        for(int i = 0 ;i < s.length() ;i ++){
            char c = s.charAt(i);      //这个就是进入的元素
            if(containsChar(sb,c))          //如果栈里有这个元素了，直接跳过
                continue;
            while(sb.length() > 0 && sb.charAt(sb.length() -1) > c){   //如果没有这个元素，判断栈顶元素和该元素的大小必须比这个元素大，才能进入循环
                char ch = sb.charAt(sb.length()-1);
                if(containString(s,i,ch)){                        //如果剩余的字符串里还有栈顶元素，弹出栈顶元素；
                    sb.deleteCharAt(sb.length() -1);
                }else{                                             //如果剩余的字符串里没有栈顶元素，就跳出while循环
                    break;
                }
            }
            if(!containsChar(sb,c)){                                //跳出循环后，或者是栈空时，栈里没有这个元素的话，把它添加到栈顶
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public boolean containsChar(StringBuilder sb, char c){    //判断栈里有没有要进入的元素
        for(int i = 0 ; i < sb.length() ; i ++){
            if(sb.charAt(i) == c){
                return true;
            }
        }
        return false;
    }

    public boolean containString(String s, int i, char ch) {    //判断字符串后面是否含有栈顶元素
        for(int j = i + 1 ; j < s.length() ; j ++){
            if(s.charAt(j) == ch){
                return true;
            }
        }
        return false;
    }
}
