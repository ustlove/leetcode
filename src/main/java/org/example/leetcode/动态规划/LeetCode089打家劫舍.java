package org.example.leetcode.动态规划;

/**
 * @ClassName LeetCode089打家劫舍
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/11 16:19
 * @Version 1.0
 */
public class LeetCode089打家劫舍 {

    public int maxAmount(int []nums){
        int [] dp = new int[nums.length+1]; // dp[i]表示到第i个房屋能偷取的最大金额
        dp[1] = nums[0];
        for (int i = 2; i<= nums .length;i++){
            dp[i] = Math.max(dp[i-1],nums[i-1]+dp[i-2]);
        }
        return dp[nums.length];
    }
}
