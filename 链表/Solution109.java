package 链表;
//109. 有序链表转换二叉搜索树
//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//示例:
//
//给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null){
            return new TreeNode(head.val,null,null);
        }
        //找到中点
        ListNode fast = head, low = head,pre = null;
        while(fast != null && fast.next != null){
            pre = low;
            fast = fast.next.next;
            low = low.next;
        }
        pre.next = null;
        //让中点成为树的根
        TreeNode root = new TreeNode(low.val);
        //让根的右边等于low.next;根的左边等于head；
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(low.next);
        return root;
    }
}
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
