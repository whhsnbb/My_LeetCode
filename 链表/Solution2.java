package 链表;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int flag = 0,sum = 0;
        while(l1 != null && l2 != null){
            ListNode node = new ListNode(0);
            sum = l1.val + l2.val;
            node.val = sum % 10 + flag;
            if(sum >= 10){
                flag = 1;
            }else{
                flag = 0;
            }
            if(node.val == 10){
                node.val = 0;
                flag += 1;
            }
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1 != null){
            pre.next = l1;
            while(l1 != null){
                l1.val = l1.val + flag;
                if(l1.val >= 10){
                    flag = 1;
                    l1.val = l1.val % 10;
                }else{
                    flag = 0;
                }
                l1 = l1.next;
                pre = pre.next;
            }
            if(flag != 0){
                ListNode node = new ListNode(flag);
                pre.next = node;
            }
        }
        else if(l2 != null){
            pre.next = l2;
            while(l2 != null){
                l2.val = l2.val + flag;
                if(l2.val >= 10){
                    flag = 1;
                    l2.val = l2.val % 10;
                }else{
                    flag = 0;
                }
                l2 = l2.next;
                pre= pre.next;
            }
            if(flag != 0){
                ListNode node = new ListNode(flag);
                pre.next = node;
            }
        }
        else if(flag != 0){
            ListNode node = new ListNode(flag);
            pre.next = node;
        }

        return head.next;
    }
}
