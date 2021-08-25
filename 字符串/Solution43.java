package 字符串;
//43. 字符串相乘
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
//示例 1:
//
//输入: num1 = "2", num2 = "3"
//输出: "6"
//示例 2:
//
//输入: num1 = "123", num2 = "456"
//输出: "56088"
class Solution43 {
    //如果直接把字符串化成整数，可能会出现越界情况，所以不能直接化成整数
    //利用小学分别相乘最后相加那种方法，19*19就成了 9*9   9*1   1*9  1*1 分别四次运算，然后在不同位置进行相加即可
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length();
        int n = num2.length();
        int [] res = new int [m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int num = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int p1 = i+j;
                int p2 = i+j+1;
                int sum = num+res[p2];
                res[p2] = sum%10;
                //此处的+=是为了处理进位用的，例如19*19，列出竖式看一下就知道了。
                res[p1] += sum/10;
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<res.length;i++){
            //这里的i==0是因为只可能出现首位为0的情况，例如一个三位数乘一个两位数不可能出现结果是一个三位数的情况。所以只需要判断首位即可。
            if(res[i]==0&&i==0){
                continue;
            }
            result.append(res[i]);
        }
        return result.toString();
    }
}
