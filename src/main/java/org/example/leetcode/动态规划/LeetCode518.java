package org.example.leetcode.动态规划;

/**
 * @ClassName LeetCode518
 * @Description 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 *
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 *
 * 假设每一种面额的硬币有无限个。
 * @Author ASUS
 * @Date 2024/4/9 14:42
 * @Version 1.0
 */
public class LeetCode518 {


    public int solution(int []  coins, int amount){
        int[][] dp = new int[coins.length+1][amount+1]; // dp[i][j] 前i个物品装满容量为j的背包有几种方法
        for (int i = 0; i <coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <=coins.length; i++) {
            for (int j = 1; j <=amount ; j++) {
                if(coins[i]>amount){
                    // 物品重量大于 背包容量不能装
                dp[i][j] = dp[i-1][j];
                }
                dp[i][j] =
                        // 不装该物品
                dp[i-1][j]+
                        //装该物品 背包容量 j-i
                dp[i][j-coins[i]];
            }
        }
        return dp[coins.length][amount];
    }
}
