package 字符串;
//38. 外观数列
//给定一个正整数 n ，输出外观数列的第 n 项。
//
//「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
//
//你可以将其视作是由递归公式定义的数字字符串序列：
//
//countAndSay(1) = "1"
//countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
//前五项如下：
//
//1.     1
//2.     11
//3.     21
//4.     1211
//5.     111221
//第一项是数字 1
//描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
//描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
//描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
//描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
class Solution38 {


//countAndSay(1) = "1"
//countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }                       //如果n==1,返回值是1
        //如果n不是1，则遍历countyAndSay（n-1）这个字符串（实际上就是递归），对字符串进行描述
        StringBuilder res = new StringBuilder();
        int count = 0;
        String arr = countAndSay(n-1);
        for(int i = 0 ; i < arr.length() ; i ++) {
            for (int j = i; j < arr.length(); j++) {
                if (arr.charAt(i) == arr.charAt(j)) {
                    count++;
                } else {
                    res.append(count);
                    res.append(arr.charAt(--j));
                    i = j;
                    count = 0;
                    break;
                }
                if (j == arr.length() - 1) {
                    res.append(count);
                    res.append(arr.charAt(j));
                    i = j;
                    break;
                }
            }
        }
        return res.toString();
    }
}