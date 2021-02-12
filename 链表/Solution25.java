package 链表;
//25. K 个一组翻转链表
//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//k 是一个正整数，它的值小于或等于链表的长度。
//
//如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//
//
//
//示例：
//
//给你这个链表：1->2->3->4->5
//当 k = 2 时，应当返回: 2->1->4->3->5
//当 k = 3 时，应当返回: 3->2->1->4->5
public class Solution25 {
    //主函数
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pHead = new ListNode(-1 , head);  //创建头结点
        ListNode pre = pHead;

        while(head != null){
            ListNode tail = pre;
            for(int i = 0; i < k ; i ++){       //如果到达不了五个直接返回头结点后的节点
                tail = tail.next;
                if(tail == null){
                    return pHead.next;
                }
            }
            ListNode[] myReverse = reverse(head,tail);    //获取反转后的头和尾
            head = myReverse[0];
            tail = myReverse[1];
            pre.next = head;                              //让原链表与反转后的链表相连；
            pre = tail;
            head = tail.next;                             //让pre和head找=变到新的位置
        }
        return pHead.next;
    }

    //反转k个节点的函数
    public ListNode[] reverse(ListNode head,ListNode tail){
        ListNode prev = tail.next;                         //尾节点的下一节点
        ListNode p = head;
        while(prev != tail){
            ListNode nex = p.next;                            //记录下p的下一节点，否则后面会因反转而失去
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail,head};
    }
}
