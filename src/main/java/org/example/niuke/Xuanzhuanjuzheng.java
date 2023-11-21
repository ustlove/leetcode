package org.example.niuke;

import java.util.ArrayList;

/**
 * @ClassName Xuanzhuanjuzheng
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/23 16:56
 * @Version 1.0
 */
public class Xuanzhuanjuzheng {
    ArrayList<Integer> res = new ArrayList<>();

    public void solution(int [][] matrix){

        int height = matrix.length-1;
        int length = matrix[0].length;
        int top = 0,left = 0,right = length-1;

        while (true){
            //从左到右
            if(left>right) break;
            for(int i = left; i <=right ;i++){
                res.add(matrix[top][i]);
            }
            top = top+1;
            //从上到下
            if(top>height) break;
            for (int i = top;i<=height ;i++){
                res.add(matrix[i][right]);
            }
            right=right-1;
            //从右到左
            if(right<left) break;
            for (int i = right;i>=left;i--){
                res.add(matrix[height][i]);
            }
            height= height - 1;
            //从下到上
            if(top>height) break;
            for (int i = height;i>= top ;i--){
                res.add(matrix[left][i]);
            }
            left=left+1;
        }
        System.out.println(res);



    }
}
