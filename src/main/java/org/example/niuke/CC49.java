package org.example.niuke;

/**
 * @ClassName CC49 判断两个二叉树是否相等
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/25 15:06
 * @Version 1.0
 */
public class CC49 {
    public void main(String[] args) {

    }


    public boolean isSameTree (TreeNode p, TreeNode q) {
        if(p==null&&q!=null || p!=null&&q==null) return false;
        if(p==null && q==null) return true;
        else {
            if(p.val!=q.val){
                return false;
            }
            if(isSameTree(p.left,q.left) && isSameTree(p.right,q.right)){
                return true;
            }
            return true;

        }

        // write code here
    }

    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        }

}
