package org.example.leetcode.二叉树;

import org.example.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LeetCode102
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/15 8:09
 * @Version 1.0
 */
public class LeetCode102 {
    Queue<TreeNode>  q  = new LinkedList();
    public void leveltraverse(TreeNode head){
            q.offer(head);
            while (!q.isEmpty()){
                TreeNode poll = q.poll();
                System.out.println(poll.value);
                TreeNode l = poll.left;
                if(l!= null){
                    q.offer(l);
                }
                TreeNode r = poll.right;
                if(r!= null) {
                    q.offer(r);
                }



            }



    }
}
