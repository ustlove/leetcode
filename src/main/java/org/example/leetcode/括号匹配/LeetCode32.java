package org.example.leetcode.括号匹配;

import java.util.Stack;

/**
 * @ClassName LeetCode32
 * @Description 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * @Author ASUS
 * @Date 2024/4/17 17:36
 * @Version 1.0
 */
public class LeetCode32 {


    public int MaxValidLength(String  s){
        int[] dp  = new int[s.length()+1]; // dp[i] 的定义：记录以 s[i-1] 结尾的最长合法括号子串长度
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
                dp[i+1] = 0;
            }else {
                if(!stack.isEmpty()){
                    int  leftindex = stack.pop();
                    dp[i+1] = i - leftindex + 1 + dp[leftindex];
                }else {
                    dp[i+1] = 0;
                }
            }
        }
        int res = 0;
        for (int i = 1; i <dp.length ; i++) {
            res = Math.max(res,dp[i]);
        }
        return  res;






    }


}
