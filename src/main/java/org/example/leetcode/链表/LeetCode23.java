package org.example.leetcode.链表;

import java.util.PriorityQueue;

/**
 * @ClassName LeetCode23
 * @Description 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @Author ASUS
 * @Date 2024/4/8 8:57
 * @Version 1.0
 */
public class LeetCode23 {
    /**
     * 小顶堆
     * @param listNodes
     * @return
     */


    public ListNode mergeSorted_k_List(ListNode[] listNodes){
        ListNode dummy = new ListNode(-1),p = dummy;
        PriorityQueue<ListNode> queue  = new PriorityQueue<>((a,b)->a.val - b.val);
        for (ListNode listNode : listNodes) {
            queue.offer(listNode);
        }
        while (!queue.isEmpty()){
            ListNode poll = queue.poll();
            ListNode temp = poll;
            queue.offer(poll.next);
            temp.next = null;
            p.next = temp;
        }
        return dummy.next;
    }
}
