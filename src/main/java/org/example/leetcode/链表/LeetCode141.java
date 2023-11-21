package org.example.leetcode.链表;

/**
 * @ClassName LeetCode141
 * @Description 环形链表 给你一个链表的头节点 head ，判断链表中是否有环。
 * @Author ASUS
 * @Date 2024/4/7 16:43
 * @Version 1.0
 */
public class LeetCode141 {
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!= null){
            slow =  slow.next;
            fast = fast.next.next;
            if(slow ==fast)
                return true;
        }
        return false;
    }

    public ListNode hasCycleAndFindNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next!= null){
            slow =  slow.next;
            fast = fast.next.next;
            if(slow ==fast) {
                slow = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }


}


