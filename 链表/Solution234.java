package 链表;

import java.util.Stack;

//234. 回文链表
//请判断一个链表是否为回文链表。
//
//示例 1:
//
//输入: 1->2
//输出: false
//示例 2:
//
//输入: 1->2->2->1
//输出: true

//将链表用快慢指针分成两个链表，然后反转后面的链表，进行对比
public class Solution234 {

    //分成两个链表，并且进行后面的判断
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head.next,low = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
        }
        ListNode pHead = low.next;
        low.next = null;
        pHead = reverse(pHead);
        while(pHead != null){
            if(pHead.val != head.val){
                return false;
            }
            pHead = pHead.next;
            head = head.next;
        }
        return true;
    }

    //迭代法反转链表
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode pHead = cur.next;
            cur.next = pre;
            pre = cur;
            cur = pHead;
        }
        return pre;
    }
}
