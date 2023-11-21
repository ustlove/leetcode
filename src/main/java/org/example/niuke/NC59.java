package org.example.niuke;

/**
 * @ClassName NC59 矩阵最短路径
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/30 19:41
 * @Version 1.0
 */
public class NC59 {
    public int minPathSum (int[][] matrix) {
        if (matrix.length == 0) return 0;
        int dp[][] = new int[matrix.length][matrix[0].length];
        // 填充dp
        dp[0][0] = matrix[0][0];
        //第一行
        for(int i = 1;i<matrix[0].length;i++){
            dp[0][i]=dp[0][i]+dp[0][i-1];
        }
        //第一列
        for (int i = 1 ;i<matrix.length;i++){
            dp[i][0] = dp[i-1][0]+dp[i][0];
        }

        for(int i =1;i<matrix.length;i++){
            for(int j = 1; j<matrix[0].length;j++){
                dp[i][j] = matrix[i][j]+Math.min(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
        // write code here
    }
}
