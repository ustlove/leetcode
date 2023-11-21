package org.example.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @ClassName LeetCode083
 * @Description 全排列
 * @Author ASUS
 * @Date 2024/4/3 8:27
 * @Version 1.0
 */
public class LeetCode083 {

    LinkedList<LinkedList<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean [] used;


    public LinkedList<LinkedList<Integer>> solution(int [] nums){
        used = new boolean[nums.length];
        rollback(nums);
        //
        Set<LinkedList<Integer>> set = new HashSet<>(res);
        return res;
    }

    private void rollback(int[] nums) {
        if(track.size() == nums.length) res.add(track);
        for (int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
              used[i] = true;
            track.add(nums[i]);
            rollback(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
