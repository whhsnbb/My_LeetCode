package 哈希表;
//204. 计数质数
//统计所有小于非负整数 n 的质数的数量。
//
//
//
//示例 1：
//
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//示例 2：
//
//输入：n = 0
//输出：0
//示例 3：
//
//输入：n = 1
//输出：0
class Solution204 {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;
        int sqrt_n = (int)Math.sqrt(n);
        if(n > 2)                           //特殊判断，为下面for循环做准备
            count ++;
        for (int i = 3; i < n; i += 2) {    //除了2的偶数一定是合数，所以不判断偶数
            if (notPrimes[i])                           //如果是合数就不需要统计，跳过
                continue;
            count++;
            if(i <= sqrt_n){
                for (int j = i;  i * j < n; j += 2)
                    notPrimes[i*j] = true;              //将所有（小于根号n的质数）的（奇数倍）都设置为合数。
            }
        }
        return count;
    }
}
