package org.example.leetcode.链表;

/**
 * @ClassName LeetCode160
 * @Description 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null
 * @Author ASUS
 * @Date 2024/4/8 8:32
 * @Version 1.0
 */
public class LeetCode160 {
    /**
     * 让两个链表到达结尾的长度一样 先让长的链表走到和短的链表长度一样
     * @param headA
     * @param headB
     * @return
     */

    public ListNode ifX(ListNode headA,ListNode headB){
        int lengthA= 0,lengthB = 0;
        for (ListNode node= headA; node!=null ; node = node.next) {
            lengthA++;
        }
        for (ListNode node = headB; node!=null ; node = node.next) {
            lengthB++;
        }
        ListNode A = headA,B = headB;
        int x= lengthA - lengthB;
        if(x < 0 ){
            while (x<0){
                B = B.next;
                x++;
            }

        }else {
            while (x>0){
                A = A.next;
                x--;
            }
        }
        while (A!=null && B!=null){
            if(A == B) return A;
            A=A.next;
            B=B.next;
        }
        return null;
    }

    /**
     *两个链表相加
     */
    public ListNode ifX2(ListNode headA,ListNode headB){
        ListNode A = headA,B = headB;
       while (A !=B){

           if(A == null) A.next = headB;
           else A =A.next;
           if(B == null) B.next = headA;
           else B = B.next;
       }
       return A;

    }



}
