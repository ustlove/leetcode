package org.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName LeetCode40
 * @Description 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * @Author ASUS
 * @Date 2024/4/3 15:02
 * @Version 1.0
 */
public class LeetCode40 {


    LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();


    public LinkedList<LinkedList<Integer>> sum(int [] candidates,int target){
        if( candidates.length == 0 ) return res;
        Arrays.sort(candidates);
        backtrack(candidates,0,target,0);
        return res;

    }

    private void backtrack(int[] candidates, int start, int target, int sum) {

        if(sum == target) {
            res.add(new LinkedList<>(track));
            return;
        };
        if(sum > target) return;

        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i-1]) continue;
            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates,i+1,target,sum);
            track.removeLast();
            sum-=candidates[i];
        }
    }

    public static void main(String[] args) {
        LinkedList<LinkedList<Integer>> sum = new LeetCode40().sum(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        System.out.println(sum);
    }
}
