package 链表;
//61. 旋转链表
//给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
//
//示例 1:
//
//输入: 1->2->3->4->5->NULL, k = 2
//输出: 4->5->1->2->3->NULL
//解释:
//向右旋转 1 步: 5->1->2->3->4->NULL
//向右旋转 2 步: 4->5->1->2->3->NULL
//示例 2:
//
//输入: 0->1->2->NULL, k = 4
//输出: 2->0->1->NULL
//解释:
//向右旋转 1 步: 2->0->1->NULL
//向右旋转 2 步: 1->2->0->NULL
//向右旋转 3 步: 0->1->2->NULL
//向右旋转 4 步: 2->0->1->NULL
public class Solution61 {
    //思路：将链表通过循环到最后一位，将链表连成环，然后根据补余的思想找到末尾，获取到下一位，让末尾指向空，返回下一位。
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        int count = 0;    //标记链表长度
        ListNode p = head;      //让p遍历链表
        while(p != null){
            count ++;
            if(p.next == null){                 //如果是末尾，让他的next等于head并且退出循环
                p.next = head;
                break;
            }
            p = p.next;
        }
        p = p.next;                                      //让p = head；
        for(int i = 1; i <= (count - k%count -1) ; i++){        //补余思想找到末尾
            p = p.next;
        }
        ListNode nex = p.next;                      //记录下一位
        p.next = null;                              //末尾指向空
        return nex;                                 //返回下一位
    }
}
