package org.example.leetcode;

/**
 * @ClassName LeetCode304
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/7 16:18
 * @Version 1.0
 */
public class LeetCode304 {



}

class NumMatrix{

    int [][] matrix;
    NumMatrix(int [][] matrix){
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
    }
    int m;
    int n;
    int sumRegion(int row1,int col1,int row2,int col2){
        int [][] dp =  new int[m+1][n+1];//dp[i][j]表示 matrix[i-1][j-1] [0,0]的和
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                dp[i][j] = matrix[i-1][j-1] - dp[i-1][j-1]+dp[i][j-1]+dp[i-1][j];
            }
        }
        return  dp[row2+1][col2+1]+dp[row1][col1]-dp[row1][col2]-dp[row2][col1];
    }
}
