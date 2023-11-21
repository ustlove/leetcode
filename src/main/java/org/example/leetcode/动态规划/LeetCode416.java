package org.example.leetcode.动态规划;

/**
 * @ClassName LeetCode416
 * @Description 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Author ASUS
 * @Date 2024/4/9 15:24
 * @Version 1.0
 */
public class LeetCode416 {
    public boolean canPartition(int [] nums){
        if (nums.length == 1) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum  % 2 != 0) return false; //和为奇数直接返回false
        int target = sum / 2;
        /**
         * 判断数组中的数字能否组成target
         */
        boolean [][] dp = new boolean[nums.length+1][target+1];
        for (int i = 0; i <=target ; i++) {
            dp[0][target] = true;
        }
        for (int i = 1; i <=nums.length ; i++) {
            for (int j =1 ; j<=target ; j++) {
                if(nums[i]> target) {
                    //大于目标数字 能否组成看 上一个
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] || dp[i][j-nums[i]];
                }
            }
        }
        return dp[nums.length][target];
    }
}
