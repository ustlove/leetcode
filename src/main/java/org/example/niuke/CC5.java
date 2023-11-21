package org.example.niuke;

/**
 * @ClassName CC5 链表的插入排序
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/27 18:44
 * @Version 1.0
 */
public class CC5 {

    public CC4.ListNode insertionSortList(CC4.ListNode head){
        if(head ==null || head.next ==null){
            return head;
        }
        CC4.ListNode h = new CC4.ListNode();
        h.next = head;
        CC4.ListNode pre_cur = h;
        CC4.ListNode cur = h.next;
        while (cur!=null){
            if( pre_cur.val < cur.val){
                pre_cur = pre_cur.next;
                cur = cur.next;
            }
            pre_cur.next = cur.next; // 删除节点
            CC4.ListNode  pre = h;
            while (pre != null && pre.val < cur.next.val){
                pre = pre.next;
            }
            cur.next= pre.next; //拼接
            pre.next = cur;

            cur = pre_cur.next;
        }
        return h.next;
    }
}
