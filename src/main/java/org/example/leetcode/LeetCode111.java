package org.example.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName LeetCode111
 * @Description 二叉树最小深度
 * @Author ASUS
 * @Date 2024/4/2 16:51
 * @Version 1.0
 */
public class LeetCode111 {

  Queue<TreeNode> queue = new LinkedList<>();

  public int getDeep(TreeNode root){
      int deep = 0;
      if(root == null) return deep;
      queue.add(root);
      while (!queue.isEmpty()){

          deep++;
          //进入下一层 高度+1
          for (int i = 0;i<queue.size();i++) {
              TreeNode poll = queue.poll();
              if(poll.right != null) queue.add(poll.right);
              if(poll.left != null) queue.add(poll.left);
              if(poll.right == null && poll.left == null) return deep;
          }
      }
      return deep;

  }


}
