package org.example.leetcode.动态规划;

import java.util.Arrays;

/**
 * @ClassName LeetCode62
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/16 16:46
 * @Version 1.0
 */
public class LeetCode62 {

  // 不同路径1
    public int differentPath(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
       /* for (int row = 0; row < m; row++) {
            Arrays.fill(matrix[row],1);
        }*/
        int [][] dp = new int[m][n];
        for (int i = 1; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i =1 ; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];







    }
  //不同路径2 有障碍物
    public int differentPath2(int [][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
       /* for (int row = 0; row < m; row++) {
            Arrays.fill(matrix[row],1);
        }*/
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if(isZero(matrix[0][i])){
                dp[0][i] = 0;
            }
            else dp[0][i] = dp[0][i-1];
        }
        for (int i =1 ; i < m; i++) {
            if(isZero(matrix[i][0])){
                dp[i][0] = 0;
            }
            else  dp[i][0] = dp[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    private boolean isZero(int num){
        return num == 0;
    }


}
