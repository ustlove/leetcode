package org.example.leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode76
 * @Description 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @Author ASUS
 * @Date 2024/3/28 16:55
 * @Version 1.0
 */
public class LeetCode76 {
    static HashMap<Character,Integer> window = new HashMap<>();
    static HashMap<Character,Integer> need = new HashMap<>();

//滑动窗口
    public static String minWindow(String s, String t) {
        for (char c :t.toCharArray()){
            if (need.containsKey(c)) need.put(c,need.get(c)+1);
            else need.put(c,1);
        }
        int valid = 0;

        int right = 0; int left = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)) {
                if (window.containsKey(c)) window.put(c, window.get(c) + 1);
                else window.put(c, 1);

                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (valid == need.size()){
                if(right - left<len) {
                    start= left;
                    len = right - left;
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.containsKey(c1)) window.put(c1, window.get(c1) - 1);
                    if (!window.get(c1).equals(need.get(c1))) valid--;
                }
            }
        }
        return s.substring(start,start+len);
    }
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));

    }




}
