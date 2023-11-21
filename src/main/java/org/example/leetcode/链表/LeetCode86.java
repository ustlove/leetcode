package org.example.leetcode.链表;

/**
 * @ClassName LeetCode86
 * @Description 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * @Author ASUS
 * @Date 2024/4/7 17:52
 * @Version 1.0
 */
public class LeetCode86 {

    public ListNode spiltList(ListNode head,int target) {

        ListNode dummy1 = new ListNode(-1), d1 = dummy1; //小于
        ListNode dummy2 = new ListNode(-1), d2 = dummy2;//大于
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val < target) {
                d1.next = p;
                d1 = d1.next;
            } else {
                d2.next = p;
                d2 = d2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;

        }
        d1.next = dummy2.next;
        return dummy1;
    }
}
