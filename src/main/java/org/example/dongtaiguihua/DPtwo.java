package org.example.dongtaiguihua;

import java.util.Arrays;

/**
 * @ClassName DPtwo
 * @Description 凑零钱问题
 * @Author ASUS
 * @Date 2024/3/27 16:10
 * @Version 1.0
 */
public class DPtwo {


    public static int solution(int[] coins ,int amount){

        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for (int i = 1;i<dp.length;i++){
            for (int coin:coins){
                if(i - coin < 0) continue;
                dp[i] = Math.min(dp[i],1+dp[i-coin]);

            }

        }
        return dp[amount]==amount+1?0:dp[amount];
    }

    public static void main(String[] args) {

        int[] coins = new int[]{1,3,5};
        int amount = 15;
        System.out.println(solution(coins,15));






    }

}
