package org.example.leetcode.字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LeetCode3
 * @Description 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @Author ASUS
 * @Date 2024/4/15 8:17
 * @Version 1.0
 */
public class LeetCode3 {

    Map<Character,Integer> hash = new HashMap<>();

    public int maxlength(String s){
        int res = 0;
        int right = 0 ;
        int left  =  0;
        String sub = "";

        while (left <=right ){
            char key = s.charAt(right);
            right++;
            if (hash.containsKey(key)){
                hash.put(key,hash.get(key)+1);
            }
            hash.put(key,1);
            while (hash.get(key) > 1){
                char c = s.charAt(left);
                left++;
                hash.put(c,hash.get(c)-1);
            }
            sub = res > right+1-left?sub:s.substring(left,right+1);
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
