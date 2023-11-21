package org.example.leetcode;

/**
 * @ClassName LeetCode144
 * @Description 二叉树遍历
 * @Author ASUS
 * @Date 2024/4/1 14:43
 * @Version 1.0
 */
public class LeetCode144 {

    public void pre_traverse(TreeNode root){
        if(root  == null) return;
        System.out.println(root.value);
        pre_traverse(root.left);
        pre_traverse(root.right);
    }
    public void mid_traverse(TreeNode root){
        if(root == null) return;
        mid_traverse(root.left);
        System.out.println(root.value);
        mid_traverse(root.right);
    }
    public void post_traverse(TreeNode root){
        if(root == null) return;
        post_traverse(root.left);
        post_traverse(root.right);
        System.out.println(root.value);
    }

}
