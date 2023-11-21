package org.example.leetcode.链表;

/**
 * @ClassName LeetCode876
 * @Description 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 *
 * 如果有两个中间结点，则返回第二个中间结点。
 * @Author ASUS
 * @Date 2024/4/7 18:34
 * @Version 1.0
 */
public class LeetCode876 {


    ListNode findMidNode(ListNode head){
        ListNode slow = head,fast = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
