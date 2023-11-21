package org.example.leetcode.单调栈;

import java.util.HashMap;
import java.util.Stack;

/**
 * @ClassName LeetCode496
 * @Description nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 *
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 *
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
 * 并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 *
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 *
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2]. 输出：[-1,3,-1]
 * @Author ASUS
 * @Date 2024/4/12 9:21
 * @Version 1.0
 */
public class LeetCode496 {
    public int [] nextGreaterElement(int [] nums1, int [] nums2){

        Stack<Integer> stack = new Stack<>();
        int n2 = nums2.length;
        int [] res = new int[n2];
        for (int i =n2 - 1; i>=0 ;i--){
            while (!stack.isEmpty() && nums2[i]>stack.peek()){
                stack.pop();
            }
            res[i] = stack.isEmpty()? -1:stack.peek();
            stack.push(nums2[i]);
        }
        HashMap<Integer,Integer> index = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            index.put(nums2[i],res[i]);
        }
        int[] ints = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ints[i] = index.get(nums1[1]);
        }
        return ints;
    }
}
