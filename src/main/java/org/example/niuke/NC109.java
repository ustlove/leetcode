package org.example.niuke;

/**
 * @ClassName NC109 岛屿数量 dfs
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/29 11:19
 * @Version 1.0
 */
public class NC109 {
    public void dfs (char[][] grid ,int i,int j){
        int n = grid.length;
        int m = grid[0].length;
        grid[i][j] = '0';
        // 上
        if(i-1>=0 && grid[i-1][j]== '1')
            dfs(grid, i-1, j);
        //下
        if(i+1<n && grid[i-1][j]== '1')
            dfs(grid, i+1, j);
        // 左
        if(j-1 >=0 && grid[i][j-1] == '1')
            dfs(grid,i,j-1);
        //右
        if(j+1<m && grid[i][j+1] == '1')
            dfs(grid,i,j+1);

    }

    public int solve (char[][] grid) {
        int n = grid.length;
        int count = 0;
        if ( n==0) return 0;
        int m = grid[0].length;
        for (int i = 0; i<n;i++ ){
            for (int j = 0; j<m;j++){
                if(grid[i][j] == '1'){
                    count ++;
                    dfs(grid,i,j);
                }

            }
        }
        return count;
        // write code here
    }
}
