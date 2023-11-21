package org.example.leetcode;

import java.util.ArrayList;

/**
 * @ClassName LeetCode78
 * @Description 子集 bfs 回溯
 * @Author ASUS
 * @Date 2024/4/3 8:10
 * @Version 1.0
 */
public class LeetCode78 {


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();


    public ArrayList<ArrayList<Integer>> subsets(int [] nums) {
        trackback(nums, 0);
        return res;
    }

    private void trackback(int[] nums, int start) {
        if(track.size() == 3) res.add(new ArrayList<>(track));
        for (int i = 0; i < nums.length; i++) {
            track.add(nums[i]);
            trackback(nums,i+1);
            track.remove(nums.length-1);
        }
    }
}
