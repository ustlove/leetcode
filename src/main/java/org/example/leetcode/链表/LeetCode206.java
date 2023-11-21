package org.example.leetcode.链表;

/**
 * @ClassName LeetCode206
 * @Description 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @Author ASUS
 * @Date 2024/4/15 8:31
 * @Version 1.0
 */
public class LeetCode206 {

    public ListNode reverseList(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}

