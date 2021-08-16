package 字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//30. 串联所有单词的子串
//给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
//注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
//
//
//
//示例 1：
//
//输入：
//  s = "barfoothefoobarman",
//  words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//示例 2：
//
//输入：
//  s = "wordgoodgoodgoodbestword",
//  words = ["word","good","best","word"]
//输出：[]
class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int one_word = words[0].length();      //题目中说明所有单词长度相等，所以只用取其中一个的长度就行
        int word_num = words.length;           //words中有多少个单词
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);       //将所有words中的单词放到一个hashmap中
        }
        for (int i = 0; i < one_word; i++) {        //总共有one_word种分配方式
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmp_map = new HashMap<>();
            while (right + one_word <= s.length()) {            //判断right右边还有没有够one_word长度的单词
                String w = s.substring(right, right + one_word);        //截取一个单词
                right += one_word;                                      //right右移one_word个单位的长度
                if (!map.containsKey(w)) {                              //看下存word的hashmap里有没有这个键
                    count = 0;                                             //没有的话，清空tmp_map，count=0，并且让left跑到right这里来
                    left = right;
                    tmp_map.clear();
                } else {
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);   //如果map中存在这个单词，把这个存到tmp_map中
                    count++;                                                                //count++;
                    while (tmp_map.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {//如果tmp_map中该word的值比map中的大
                        String t_w = s.substring(left, left + one_word);                        //那么就要在tmp_map中将这个word的值减一，并且让count也减一
                        count--;
                        tmp_map.put(t_w, tmp_map.getOrDefault(t_w, 0) - 1);
                        left += one_word;                                                       //left还得右移
                    }
                    if (count == word_num) res.add(left);                                       //如果找到的word数量count和word的总个数相等，那么就向集合中添加left的值
                }
            }
        }
        return res;
    }
}