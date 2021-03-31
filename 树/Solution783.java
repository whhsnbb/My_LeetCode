package 树;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.DelayQueue;

//783. 二叉搜索树节点最小距离
//给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值。
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class Solution783 {
    //二叉搜索树中序遍历后是有序数列
    int pre = -1;
    int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        dfs(root);                                  //中序遍历
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        //比较后将pre重新赋值
        if (pre != -1) {
            ans = Math.min(ans, root.val - pre);        //全局变量ans记录最小的值
        }
        pre = root.val;         //如果pre没有初值，就赋初值为根节点的值
        dfs(root.right);
    }
}
