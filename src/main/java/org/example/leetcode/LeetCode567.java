package org.example.leetcode;

import java.util.HashMap;

/**
 * @ClassName LeetCode567
 * @Description 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * @Author ASUS
 * @Date 2024/3/28 17:39
 * @Version 1.0
 */
public class LeetCode567 {
    static HashMap<Character, Integer> need = new HashMap<>();
    static HashMap<Character, Integer> window = new HashMap<>();

    public boolean checkInclusion(String s1, String s2) {
        for (char c : s1.toCharArray()) {
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else need.put(c, 1);
        }
        int right = 0;
        int left = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }
                if (window.get(c).equals(need.get(c))) valid++;
            }
            while (right - left >= s1.length()) {

                if (valid == need.size()) return true;
                char c1 = s2.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.containsKey(c1)) {
                        window.put(c1, window.get(c) - 1);
                        if (!window.get(c1).equals(need.get(c1))) valid--;
                    }
                }
            }
        }
        return false;
    }
}
