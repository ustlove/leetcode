package org.example.leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode3
 * @Description 滑动窗口 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author ASUS
 * @Date 2024/3/29 8:53
 * @Version 1.0
 */
public class LeetCode3 {

    static HashMap<Character,Integer> window = new HashMap<>();


    public int solution(String s){
        int right = 0;
        int left = 0;
        int res = 0;

        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if(window.containsKey(c)){
                window.put(c,window.get(c)+1);
            }else window.put(c,1);

            while (window.get(c) > 1){

                char c1 = s.charAt(left);
                left++;
                window.put(c,window.get(c)-1);
            }
            res = Math.max(res,right - left+1);

        }
        return res;
    }








}
