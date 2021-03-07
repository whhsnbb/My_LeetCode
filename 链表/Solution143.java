package 链表;
//143. 重排链表
//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
//将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//示例 1:
//
//给定链表 1->2->3->4, 重新排列为 1->4->2->3.
//示例 2:
//
//给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
public class Solution143 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return ;
        }
        //获取中结点 (利用快慢指针)
        ListNode low = head;
        ListNode fast = head;
        ListNode flag = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            flag = low;
            low = low.next;
        }
        flag.next = null;
        ListNode mid = low;
        //将中结点后的链表逆序（迭代法）
        ListNode cur = null;
        ListNode pre = mid;
        ListNode pNode = null;
        while(pre != null){
            pNode = pre.next;
            pre.next = cur;
            cur = pre;
            pre = pNode;
        }
        mid = cur;
        //连接前（未改变的链表）后（逆序改变的链表）两个链表
        ListNode p1 = head;
        ListNode p2 = mid;
        ListNode pNew = null;
        while(p1 != null && p1.next != null){
            pNew = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p1.next.next;
            p2 = pNew;
        }
        p1.next = p2;
    }
}
