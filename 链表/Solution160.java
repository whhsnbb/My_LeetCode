package 链表;
//160. 相交链表
//编写一个程序，找到两个单链表相交的起始节点。
public class Solution160 {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            //走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
            //pA走过的路径为A链+B链
            //pB走过的路径为B链+A链
            //pA和pB走过的长度都相同，都是A链和B链的长度之和，相当于将两条链从尾端对齐
            //如果相交，则会提前在相交点相遇，如果没有相交点，则会在最后相遇。
            if (headA == null || headB == null) return null;
            ListNode pA = headA, pB = headB;
            while (pA != pB) {
                pA = pA == null ? headB : pA.next;
                pB = pB == null ? headA : pB.next;
            }
            return pA;
        }
}
