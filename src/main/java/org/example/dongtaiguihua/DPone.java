package org.example.dongtaiguihua;

/**
 * @ClassName DPone
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/27 8:07
 * @Version 1.0
 */
public class DPone {

    public static int solution(int n){
        if(n< 0) return 0;
        if(n == 1 || n == 2 ) return 1;
        //dp[i] 表示 前i项和
        int [] dp = new int[n+1];
        dp[2] = 1;
        dp[1] = 1;
        dp[0] = 0;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static int solution2(int n){
        if(n==1 || n==2) return  1;
        if(n<0) return 0;
        int pre = 1;
        int cur = 1;
        int res = 0;
        for (int i= 3;i<=n;i++){
            res = pre+cur;
            pre = cur;
            cur = res;
        }
        return res;
        
    }

    public static void main(String[] args) {
        System.out.println(solution2(4));
    }
}
