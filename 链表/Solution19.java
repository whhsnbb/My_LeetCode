package 链表;

//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

        //示例：

        //给定一个链表: 1->2->3->4->5, 和 n = 2.

        //当删除了倒数第二个节点后，链表变为 1->2->3->5.
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
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode pre = head;
        while( pre != null){
            length += 1;
            pre = pre.next;
        }
        if(length == 1){
            return null;
        }
        if(length == n){
            head = head.next;
            return head;
        }
        pre = head;
        n = length - (n - 1);
        for(int i = 1 ;i < n - 1; i ++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
