package org.example.niuke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CC16 分糖果
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/28 15:53
 * @Version 1.0
 */
public class CC16 { //[ 1,2,1] 4  [1,1,1] [1,2,1]
    public int candy (int[] ratings) {
        int sum = 0;
        int dp[] = new int[ratings.length];
        for (int i =0;i<dp.length;i++){
            dp[i]=1;
        }
        if(ratings.length == 0) return  0;
        else if (ratings.length ==1 ) {
            return 1;
        }else {
            //从左到右
            for (int i =0;i<ratings.length-1;i++){
                if(ratings[i]<ratings[i+1]){
                    dp[i+1] = dp[i]+1;
                }
            }
            //从右到左
            for (int i = ratings.length-1;i>0;i--){
                if(ratings[i-1]>ratings[i] && dp[i]>=dp[i-1]){
                    dp[i-1]=dp[i]+1;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                sum+=dp[i];
                
            }
            return sum;

        }



        // write code here
    }
     //找到最小数的索引

}
