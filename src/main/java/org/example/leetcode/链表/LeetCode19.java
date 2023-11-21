package org.example.leetcode.链表;

/**
 * @ClassName LeetCode19
 * @Description 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * @Author ASUS
 * @Date 2024/4/7 18:42
 * @Version 1.0
 */
public class LeetCode19 {
    public ListNode removeLastNNode(ListNode head,int target){

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy,slow = dummy;
        for (int i = 0; i < target; i++) {
            fast = fast.next;
        }
        if(fast ==null) return null;
        while (fast.next!= null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;








    }
}
