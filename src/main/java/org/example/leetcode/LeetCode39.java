package org.example.leetcode;

import java.util.LinkedList;

/**
 * @ClassName LeetCode39
 * @Description
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target
 * ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
 * 你可以按 任意顺序 返回这些组合。
 * 元素可重复
 * @Author ASUS
 * @Date 2024/4/3 14:34
 * @Version 1.0
 */
public class LeetCode39 {

    LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public LinkedList<LinkedList<Integer>> sum(int[] candidates,int target){
        if(candidates.length == 0) return res;
        backtrack(candidates,0,target,0);
        return res;
    }

    private void backtrack(int[] candidates,int start, int target,int sum) {
        if(sum == target) res.add(new LinkedList<>(track));
        if(sum > target) return;
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates,i,target,sum);
            track.removeLast();
            sum-= candidates[i];
        }
    }


}
