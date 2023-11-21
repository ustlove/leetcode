package org.example.leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName LeetCode300
 * @Description 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 *子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * @Author ASUS
 * @Date 2024/4/8 14:31
 * @Version 1.0
 */
public class LeetCode300 {

    public int lengthOfLIS(int [] nums){
        int res = 0;
        // dp数组 dp[i] 表示前i项最长严格递增子序列的长度
        int [] dp =  new int[nums.length];
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < j; j++) {
                if(nums[i]> nums[j]){
                    dp[i] =Math.max(dp[i],dp[j]+1);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;




    }






}
