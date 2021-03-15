package 链表;
//203. 移除链表元素
//删除链表中等于给定值 val 的所有节点。
//
//示例:
//
//输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
public class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode pHead = new ListNode(0,head);
        ListNode p = pHead;
        while(p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        return pHead.next;
    }
}
