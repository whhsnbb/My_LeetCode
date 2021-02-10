package 链表;
//24. 两两交换链表中的节点
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
//示例:
//
//给定 1->2->3->4, 你应该返回 2->1->4->3.

//方法新建头结点，pre(头节点处pHead) 空1 cur(空2) 空3 空4 空5 空6
//交换后        pre(头结点处pHead)  cur(空1) 空1 空3 空4 空5 空6
//接着          头结点处pHead  空1 pre(空2) 空3 cur(空4) 空5 空6
//             头结点处pHead  空1 pre(空2) cur(空4) 空3 空5 空6
//             头结点处pHead  空1 空2 空4 pre(空3) 空5 cur(空6)
//             头结点处pHead  空1 空2 空4 pre(空3) cur(空6) 空5
//             头结点处pHead  空1 空2 空4 空3 空6 空5(pre和cur都在这，然后循环跳出，返回头结点的next)

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pHead = new ListNode(-1,head);
        ListNode pre = pHead,cur = pHead.next.next;
        while(cur != null && pre != cur){
            pre.next.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = cur.next;
            if(pre.next != null){
                cur = pre.next.next;
            }else{
                cur = pre;
            }
        }
        return pHead.next;
    }
}
