package org.example.leetcode;


/**
 * @ClassName Shudu
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/2 17:24
 * @Version 1.0
 */
public class Shudu {

    /**
     * 9 * 9 数独
     */
    public void  ShuduSolution(char[][] board){
        rollBack(board,0,0);
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.println(board[row][col]);
            }
        }}


    public boolean rollBack(char[][] board ,int i,int j){
        int m = 9;
        int n = 9;
        if(j == 9) {rollBack(board,i+1,0); } //如果遍历到最后一列 去下一行
        if(board[i][j] !='.') { rollBack(board,i,j+1); }; //如果是数字 继续向后遍历
        if(i>=m || j>=n )  return true; // 遍历到最后一个返回
        for (char c= '1'; c <='9'; c++) {
            if(!isValid(c,i,j,board)) continue;
            //如果可以填数字 继续遍历
            board[i][j] = c;
            if(rollBack(board,i,j+1)) {
                return true;
            }
            //撤销选择
            board[i][j] = '.';
        }
        return false;

    }

    private boolean isValid(char c, int i, int j,char [][] board) {
        int row = 0;
        int col = 0;
        if(i>=3 && i<6) row = 3;
        if(i>=6 && i<9) row = 6;
        if(j>=3 && j<6) col = 3;
        if(j>=6 && j<9) col = 6;
        for (int k = 0; k < 9; k++) {
            if(board[i][k] ==c) return false;
            if(board[k][j] == c) return false;
    }
        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
            if(board[k+row][col+l] == 'c')
                return false;
            }
        }
        return true;
        }
}
