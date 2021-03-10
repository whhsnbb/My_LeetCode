package 链表;
//147. 对链表进行插入排序
//对链表进行插入排序。
//
//
//插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
//每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
//
//
//
//插入排序算法：
//
//插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
//每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
//重复直到所有输入数据插入完为止。
public class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        ListNode pHead = new ListNode(0),pre; //头结点
        pHead.next = head;

        while(head != null && head.next != null){
            if(head.val <= head.next.val){          //如果有序，直接跳到下一节点
                head = head.next;
                continue;
            }

            pre = pHead;                               //如果后面的值比前面的值小，
            while(pre.next.val < head.next.val){           //遍历前面的链表直到找到插入位置
                pre = pre.next;
            }
            ListNode cur = head.next;
            head.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return pHead.next;
    }
}
