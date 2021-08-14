package 字符串;
//28. 实现 strStr()
//实现 strStr() 函数。
//
//给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
//
//示例 1:
//
//输入: haystack = "hello", needle = "ll"
//输出: 2
//示例 2:
//
//输入: haystack = "aaaaa", needle = "bba"
//输出: -1
public class Solution28 {
    public int strStr(String haystack, String needle) {

        //当 needle 是空字符串时
        if ("".equals(needle)) return 0;

        //使用indexOf返回在haystack中needle子串第一次出现的下标
        int i = haystack.indexOf(needle);
        if (i >= 0)
            return i;
        else
            //找不到
            return -1;
    }
}
