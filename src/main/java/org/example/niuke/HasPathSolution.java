package org.example.niuke;

/**
 * @ClassName HasPathSolution
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/22 17:53
 * @Version 1.0
 */
public class HasPathSolution {

    public  boolean hasPath(char [][] matrix,String word){
        if (matrix.length ==0 || matrix == null ) return false;
        char [] words = word.toCharArray();
        int length = matrix.length;
        for (int i = 0; i<length;i++){
            for ( int j = 0; j<matrix[0].length; j++){
                if(dfs(matrix,i,j,0,words))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char [][] matrix,int i ,int j ,int index,char[] words){

         //越界
        if(i>= matrix.length || j>=matrix[0].length||i<0||j<0 ||words[index]!=matrix[i][j]) return  false;
        if(index == words.length -1) return true;
        char temp = matrix[i][j];
        matrix[i][j] = '.';
    //上下 左右
        boolean res = dfs(matrix,i-1,j,index+1,words)||
                dfs(matrix,i+1,j,index+1,words)||
                dfs(matrix,i,j-1,index+1,words)||
                dfs(matrix,i,j+1,index+1,words);
        matrix[i][j]= temp;
        return res;




    }


}
