package org.example.leetcode.二叉树;

import java.util.LinkedList;

/**
 * @ClassName LeetCode116
 * @Description 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * @Author ASUS
 * @Date 2024/4/15 9:01
 * @Version 1.0
 */
public class LeetCode116 {
    class Node{

        int val;
        Node left;
        Node right;
        Node next;
    }

    LinkedList<Node> q = new LinkedList<>();



    public Node solution(Node root){
        int index = 0;
        q.offer(root);
        while (!q.isEmpty()){
            Node node = q.poll();
            index ++;
            if((index & index-1)==0){
                node.next = null;
            }
            else {
                    node.next = q.peek();
            }
            Node r = node.right;
            Node l = node.left;
            if(r!= null){
                q.offer(r);
            }
            if(l!=null){
                q.offer(l);
            }
        }
        return root;

    }
}
