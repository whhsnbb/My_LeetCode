package 字符串;
//67. 二进制求和
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
//输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
//示例 1:
//
//输入: a = "11", b = "1"
//输出: "100"
//示例 2:
//
//输入: a = "1010", b = "1011"
//输出: "10101"
class Solution67 {
    public String addBinary(String a, String b) {
        int sum = 0;
        int CO = 0;
        StringBuilder res = new StringBuilder();
        for(int i = a.length() -1 , j = b.length() - 1; i >= 0 || j >= 0; i -- , j --){
            sum = CO;
            sum += i>=0 ? a.charAt(i)-'0' : 0;
            sum += j>=0 ? b.charAt(j)-'0' : 0;
            res.append(sum % 2);
            CO = sum / 2;
        }
        res.append(CO == 1 ? "1" : "");
        return res.reverse().toString();
    }
}
