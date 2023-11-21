package org.example.niuke;

/**
 * @ClassName NC40  链表相加
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/29 16:27
 * @Version 1.0
 */
public class NC40


        // 9 -> 3 -> 7
        //      6 -> 3
    //           0    0  <-
{

    public CC4.ListNode addInList (CC4.ListNode head1, CC4.ListNode head2) {
        if(head1 ==null) return head2;
        if(head2 ==null) return head1;
        head1 = reverse(head1);
        head2 = reverse(head2);
        int tmp = 0; //进位
        CC4.ListNode head =new CC4.ListNode(-1);
        CC4.ListNode nhead = head; //新链表头节点
        while ( head1 !=null || head2 !=null){
            int val = tmp;
            if(head1 != null){
                val += head1.val;
                head1=head1.next;
            }
            if(head2 != null){
                val += head2.val;
                head2= head2.next;
            }
            tmp = val /10;
            nhead.next = new CC4.ListNode(val % 10);
            nhead = nhead.next;
        }
        if(tmp >0){
            nhead.next = new CC4.ListNode(tmp);
        }
        return reverse(head.next);

        // write code here
    }
    public CC4.ListNode reverse(CC4.ListNode head){
        if(head == null) return  head;
        CC4.ListNode pre = null;
        CC4.ListNode next = null;
        while (head!= null){

            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return head;




    }

}

