package 字符串;

import java.util.*;
//49. 字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//示例:
//
//输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        //边界条件判断
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        //map中key存储的是字符串中字母排序后新的字符串
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            //取出字符串，然后把它转化为字符数组
            char[] c = strs[i].toCharArray();
            //对字符数组进行排序
            Arrays.sort(c);
            //排序之后再把它转化为一个字符串
            String keyStr = String.valueOf(c);
            //判断map中有没有这个字符串，如果没有这个字符串，
            //说明还没有出现和这个字符串一样的字母异位词，
            //要新建一个list，把它存放到map中
            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());
            //把字符串存放到对应的list中
            map.get(keyStr).add(strs[i]);
        }
        //最后返回
        return new ArrayList<>(map.values());
    }


    //我的做法，太慢了，超出时间限制
    //    public List<List<String>> groupAnagrams(String[] strs) {
    //        if(strs.length == 0){
    //            return new ArrayList<>();
    //        }if(strs.length == 1){
    //            List<List<String>> list = new ArrayList<>();
    //            List<String> ziList = new ArrayList<>();
    //            ziList.add(strs[0]);
    //            list.add(ziList);
    //            return list;
    //        }
    //        List<List<String>> list = new ArrayList<>();
    //        List<String> ziList = new ArrayList<>();
    //        int[] arr = new int[strs.length];
    //        ziList.add(strs[0]);
    //        arr[0] = 1;
    //        int flag = 0;
    //        for(int i = 1; i < strs.length ; i ++){
    //            if(arr[i] == 0 && isEqual(ziList.get(0),strs[i])){
    //                ziList.add(strs[i]);
    //                arr[i] = 1;
    //                flag = 1;
    //            }
    //            if(i == strs.length - 1){
    //                if(!ziList.isEmpty()){
    //                    list.add(new ArrayList(ziList));
    //                }
    //                ziList.clear();
    //                for(int j = 1 ; j < arr.length ; j ++){
    //                    if(arr[j] == 0){
    //                        arr[j] = 1;
    //                        ziList.add(strs[j]);
    //                        break;
    //                    }
    //                }
    //                if(flag == 0 && ziList.isEmpty())
    //                    break;
    //                flag = 0;
    //                i = 0;
    //            }
    //        }
    //        return list;
    //    }
    //
    //    public boolean isEqual(String s1, String s2){
    //        if(s1.length() != s2.length())
    //            return false;
    //        int len1 = s1.length();
    //        int len2 = s2.length();
    //        HashMap<Character,Integer> map1 = new HashMap<>();
    //        HashMap<Character,Integer> map2 = new HashMap<>();
    //        for(int i = 0; i < len1 ; i ++){
    //            if(!map1.containsKey(s1.charAt(i))){
    //                map1.put(s1.charAt(i),1);
    //            }else{
    //                map1.put(s1.charAt(i),map1.get(s1.charAt(i))+1);
    //            }
    //        }
    //        for(int i = 0; i < len2 ; i ++){
    //            if(!map2.containsKey(s2.charAt(i))){
    //                map2.put(s2.charAt(i),1);
    //            }else{
    //                map2.put(s2.charAt(i),map2.get(s2.charAt(i))+1);
    //            }
    //        }
    //        return map1.equals(map2);
    //    }
}