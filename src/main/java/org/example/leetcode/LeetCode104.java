package org.example.leetcode;

/**
 * @ClassName LeetCode104
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/1 14:28
 * @Version 1.0
 */
public class LeetCode104 {

    int deep = 0;
    int res = 0;

    public void traverse(TreeNode root){
        if(root ==null) return;
        deep++;
        if(root.left == null && root.right == null) res = Math.max(res,deep);
        traverse(root.left);
        traverse(root.right);
        deep--;
    }

}
