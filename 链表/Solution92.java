package 链表;

//反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
//
//说明:
//1 ≤ m ≤ n ≤ 链表长度。
//
//示例:
//
//输入: 1->2->3->4->5->NULL, m = 2, n = 4
//输出: 1->4->3->2->5->NULL
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    ListNode(int x, ListNode pNext){
        val = x;
        next = pNext;
    }
}
//递归法
public class Solution92 {

    ListNode left; //左指针
    boolean flag = false; //是否交换数字判断条件

    //递归函数
    public void changeVal(ListNode right, int m, int n){
        if(n == 1){
            return ;
        }

        right = right.next;// 让right到达n处

        if(m > 1){
            this.left = this.left.next; //让left到达m处
        }

        this.changeVal(right,m-1,n-1);  //递归调用

        if(this.left == right || right.next == this.left){
            this.flag = true;       //如果满足条件，则让flag = true;
        }

        if(!this.flag){
            int t = right.val;
            right.val = this.left.val;
            this.left.val = t;
            //交换数字之后，要让left变到下一位，与回溯后的right保持对应
            this.left = this.left.next;
        }

    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        this.left = head;
        this.flag = false;
        changeVal(head,m,n);
        return head;
    }
}
