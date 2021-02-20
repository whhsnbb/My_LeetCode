package 链表;
//82. 删除排序链表中的重复元素 II
//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
//
//示例 1:
//
//输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//示例 2:
//
//输入: 1->1->1->2->3
//输出: 2->3
public class Solution82 {
    //双指针法，p指针定位，pre指针探索前面是否与自身数值相等，如果相等，循环判断是否相等，相等pre就蹦到next，不相等退出循环后p连到pre的next，pre蹦到pre的next，如果不相等则p，pre都向前移动
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pHead = new ListNode(-1);       //定义头结点
        pHead.next = head;
        ListNode p = pHead,pre = head;
        while(pre != null && pre.next != null){
            if(pre.next.val != pre.val){
                p = p.next;
                pre = pre.next;
            }else{
                while( pre != null && pre.next != null && pre.next.val == pre.val){
                    pre = pre.next;
                }
                p.next = pre.next;
                pre = pre.next;
            }
        }
        return pHead.next;
    }
}
