package org.example.dongtaiguihua;

import java.util.Arrays;

/**
 * @ClassName HuiShuoone
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/27 16:32
 * @Version 1.0
 */
public class HuiShuoone {
    public void solveNQueues(int n){
        char [][] matrix = new char[n][n];
        int h = matrix.length;
        int l = matrix[0].length;
        int row = 0;
        rollback(l,row,matrix);
    }

    public void rollback(int l,int row,char[][] matrix){
        if(row+1 > matrix.length)   {
            System.out.println();
        }

        for (int col = 0;col<l ; col ++) {
            if(!isValid(col,row,matrix)) continue;
            matrix[row][col] = 'Q';
            rollback(col,row+1,matrix);
            matrix[row][col] = '.';
        }

    }
    private boolean isValid(int col,int row,char[][] matrix){
        return true;
        //左上
        //左下
        //右上
        //右下
        //竖
    }





}
