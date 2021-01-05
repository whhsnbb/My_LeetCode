package 动态规划;
//64. 最小路径和
//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
//说明：每次只能向下或者向右移动一步。
//
// 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
//
// 输入：grid = [[1,2,3],[4,5,6]]
//输出：12

//思路： 该点的路径数+=上方和左方路径中小的那一个数，第一排和第一列路径只有一种
public class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 1; i < n ; i ++){
            grid[0][i] += grid[0][i - 1];
        }
        for(int i = 1; i < m ; i ++){
            grid[i][0] += grid[i - 1][0];
        }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j ++){
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
