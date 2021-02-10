package 链表;
//23. 合并K个升序链表
//给你一个链表数组，每个链表都已经按升序排列。
//
//请你将所有链表合并到一个升序链表中，返回合并后的链表。
//
//
//
//示例 1：
//
//输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
public class Solution23 {
    //分治，两两配对后合并，0，1，2，3，4，5，6，7
    //    第一次合并后0，2，4，6
    //    第二次合并后0，4
    //    第三次合并后0
        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if(l1 == null && l2 == null){
                return null;
            }else if(l1 == null){
                return l2;
            }else if(l2 == null){
                return l1;
            }

            ListNode head = new ListNode(-1);
            ListNode pre = head;
            while (l1 != null && l2 != null){
                if(l1.val<=l2.val){
                    pre.next = l1;
                    l1 = l1.next;
                }else{
                    pre.next = l2;
                    l2 = l2.next;
                }
                pre = pre.next;
            }

            pre.next = l1 == null ? l2 : l1;
            return head.next;
        }

        public ListNode mergeKLists(ListNode[] lists) {
            int len = lists.length;
            int count = 1;
            ListNode head = null;
            while(count < len){
                for(int i = 0 ; i < len - count ; i = i + count*2){
                    lists[i] = mergeTwoLists(lists[i] , lists[i+count]);
                }
                count = count*2;
            }
            if(len > 0)
                return lists[0];
            return null;
        }
}
