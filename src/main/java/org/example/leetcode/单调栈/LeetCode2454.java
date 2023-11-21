package org.example.leetcode.单调栈;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @ClassName LeetCode2454
 * @Description 给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。
 *
 * 如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：
 *
 * j > i
 * nums[j] > nums[i]
 * 恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
 * 如果不存在 nums[j] ，那么第二大整数为 -1 。
 *
 * 比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。
 * 请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。
 * @Author ASUS
 * @Date 2024/4/12 10:35
 * @Version 1.0
 */
public class LeetCode2454 {
  int a= 0 ;
   public LeetCode2454(int a){
     super();



   }
    Stack<Integer> stack = new Stack<>();
    PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->a[0]- b[0]);

    public int [] nextSecondGreaterElement(int [] nums){
        int [] answer = new int[nums.length];
        Arrays.fill(answer,-1);


        for (int i = 0; i < nums.length; i++) {

            while (!pq.isEmpty() && nums[i] > pq.peek()[0]){
                // 找到第二大元素
                answer[pq.poll()[1]] = nums[i];
            }
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                pq.offer(new int[]{nums[stack.peek()],stack.peek()});
                stack.pop();

            }
        stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        LeetCode2454 leetCode2454 = new LeetCode2454(156);
        System.out.println(leetCode2454.a);
        //静态方法访问不了实例变量



        short a=128;
        byte b  = (byte)a;
        System.out.println(b);
    }
}
