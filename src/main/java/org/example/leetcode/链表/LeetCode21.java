package org.example.leetcode.链表;

/**
 * @ClassName LeetCode21
 * @Description 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author ASUS
 * @Date 2024/4/7 17:23
 * @Version 1.0
 */
public class LeetCode21 {

    public ListNode mergeList(ListNode h1,ListNode h2){
        ListNode dumpy = new ListNode(-1);
        ListNode p = dumpy,l1 =h1,l2=h2;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 == null){
            p.next = l2;
        }
        if(l2 == null){
            p.next = l1;
        }
        return dumpy.next;

    }






}
