package 链表;
//142. 环形链表 II
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
//说明：不允许修改给定的链表。
//
//进阶：
//
//你是否可以使用 O(1) 空间解决此题？
//
//
//示例 1：
//输入：head = [3,2,0,-4], pos = 1 ( 2 和 0 和 - 4 连 成 一 个 环 )
//输出：返回索引为 1 的链表节点
//解释：链表中有一个环，其尾部连接到第二个节点。
public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode low = head;
        ListNode fast = head;                       //快慢指针判断是否有环，
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;

            if(fast == low){                        //根据快慢指针位移关系可得2(x+y)=n(y+z)+x+y
                ListNode index = head;              //x = (n-1)(y+z) + z;
                while(index !=  low){               //这就得到了x = n-1倍的圈长 + z
                    index = index.next;             //说明在相遇点处和head处同时设置指针，让他们向后移，相遇出就是入环处
                    low = low.next;
                }
                return index;
            }
        }
        return null;
    }
}
