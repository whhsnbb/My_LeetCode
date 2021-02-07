package 链表;
//21. 合并两个有序链表
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
//
//
//示例：
//
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
public class Solution21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    //迭代法
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null && l2 == null){
                return null;
            }else if(l1 == null){
                return l2;
            }else if(l2 == null){
                return l1;
            }
            ListNode head = null , pre = null;
            if(l1.val<=l2.val){
                head = pre = l1;
                l1 = l1.next;
            }else{
                head = pre = l2;
                l2 = l2.next;
            }
            while(l1 != null && l2 != null){
                if(l1.val <= l2.val){
                    pre.next = l1;
                    pre = pre.next;
                    l1 = l1.next;
                }else{
                    pre.next = l2;
                    pre = pre.next;
                    l2 = l2.next;
                }
            }
            pre.next = l1 == null ? l2 : l1;
            return head;
        }
}
