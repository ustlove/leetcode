package org.example.niuke;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName CC4 链表排序  30-> 20-> 40  -> 20-> 30->  40
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/26 15:46
 * @Version 1.0
 */
public class CC4 {
    public ListNode sortList(ListNode head){
        if(head ==null || head.next ==null){
            return head;
        }
        ListNode fast = head; // 快指针
        ListNode slow = head; //满指针
        while (fast.next!=null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        fast= slow.next; //后一半链表
        slow.next= null; //前一半链表
       ListNode l1 =  sortList(fast);
       ListNode l2 =  sortList(head);
       return merge(l1,l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }

        }

        if (l1 != null)
            cur.next = l1;
        if (l2 != null)
            cur.next = l2;

        return dummy.next;

    }

    public static class ListNode{
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode() {
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        Random r = new Random();
        ListNode head = new ListNode();
        ListNode t ;
        head.val = 5;
        t = head;
        for (int i =0 ; i < 5;i++){
            ListNode node = new ListNode();
            node.val =r.nextInt(11);
            t.next = node;
            t=t.next;
        }
        System.out.println(head);
        System.out.println(new CC4().sortList(head));


    }

}

