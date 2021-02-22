package 链表;
//86. 分隔链表
//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
//你应当保留两个分区中每个节点的初始相对位置。
//
//
//
//示例:
//
//输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
public class Solution86 {
    //创建两个新的链表，一个存贮<x的值得节点pHead，一个存储>x的值得节点aHead，最后把pHead得尾节点接上aHead的头结点就可以了
    public ListNode partition(ListNode head, int x) {
        ListNode pHead = new ListNode(-1);
        pHead.next = null;
        ListNode aHead = new ListNode(-1);
        aHead.next = null;
        ListNode p = head , pre = pHead , a = aHead;
        while(p != null){
            if(p.val < x){
                pre.next = p;
                p = p.next;
                pre = pre.next;
            }else{
                a.next = p;
                p = p.next;
                a = a.next;
            }
        }
        a.next = null;
        pre.next = aHead.next;
        return pHead.next;
    }
}
