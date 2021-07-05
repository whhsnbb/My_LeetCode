package 字符串;
//最长回文子串
//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//示例 1：
//
//输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//示例 2：
//
//输入: "cbbd"
//输出: "bb"
public class Solution5 {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }

        int maxLen = 1;//最长回文串长度
        int begin =0;//开始位置

        boolean[][] dp = new boolean[len][len];
        for(int i = 0 ; i < len ; i++){
            dp[i][i] = true;            //当i==j时dp[i][j]一定为true，true代表回文，false代表不回文
        }

        char[] charArray = s.toCharArray();
        for(int j = 1 ; j < len ; j++){
            for(int i = 0; i < j; i++){
                if(charArray[i] != charArray[j]){
                    dp[i][j] = false;               //如果两边的字符不相等，那么就设置false
                }else{
                    if(j - i < 3){
                        dp[i][j] =true;             //否则，如果长度大于三时为true
                    }else{
                        dp[i][j] = dp[i+1][j-1];       //如果长度不大于三，就取决于它去除两端后的子串是否为回文串
                    }
                }

                if(dp[i][j] && j-i+1 > maxLen){         //循环一边完成后比较一下maxLen那个更大，并作记录
                    maxLen = j- i +1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
}
