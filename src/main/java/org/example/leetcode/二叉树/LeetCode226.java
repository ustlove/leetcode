package org.example.leetcode.二叉树;

import org.example.leetcode.TreeNode;
import org.example.leetcode.链表.ListNode;

/**
 * @ClassName LeetCode226
 * @Description 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @Author ASUS
 * @Date 2024/4/15 8:52
 * @Version 1.0
 */
public class LeetCode226 {

    public TreeNode reverseTree(TreeNode root){
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        reverseTree(root.left);
        reverseTree(root.right);
        return root;






    }
}
