package org.example.niuke.链表合并;

/**
 * @ClassName Main 链表合并有序
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/30 17:34
 * @Version 1.0
 */

/**
 * if(list1 == null){
 *             return list2;
 *         }
 *         if(list2 == null){
 *             return list1;
 *         }
 *         ListNode mergeHead = null;
 *         ListNode current = null;
 *         while(list1!=null && list2!=null){
 *             if(list1.val <= list2.val){
 *                 if(mergeHead == null){
 *                    mergeHead = current = list1;
 *                 }else{
 *                    current.next = list1;
 *                    current = current.next;
 *                 }
 *                 list1 = list1.next;
 *             }else{
 *                 if(mergeHead == null){
 *                    mergeHead = current = list2;
 *                 }else{
 *                    current.next = list2;
 *                    current = current.next;
 *                 }
 *                 list2 = list2.next;
 *             }
 *         }
 *         if(list1 == null){
 *             current.next = list2;
 *         }else{
 *             current.next = list1;
 *         }
 *         return mergeHead;
 */
public class Main {
    /**
     *  1 -> 2 -> 5
     *  3 -> 4 -> 6
     */
    ListNode solution(ListNode h1,ListNode h2){
        if(h1==null) return h2;
        if(h2==null) return h1;
        ListNode cur = null;
        ListNode mergeHead = null;
        while(h1 != null && h2 != null){
            if(h1.val <= h2.val){
               if(mergeHead == null){
                   mergeHead = cur = h1;
               }else {
                   cur.next = h1;
                   cur = cur.next;
               }
               h1 = h1.next;
            }
            else {
                if( mergeHead == null){
                    mergeHead = cur = h2;
                }
                else {
                    cur.next = h2;
                    cur = cur.next;
                }
                h2 = h2.next;
            }

        }
        if(h1 == null){
            cur .next = h2;
        }else {
            cur.next = h1;

        }
        return mergeHead;


    }

}
class ListNode {

    int val;
    ListNode next;
    public  ListNode(int val){
        this. val = val;
    }
    public ListNode(){

    }
}

