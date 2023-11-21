package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName LeetCode438
 * @Description 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * @Author ASUS
 * @Date 2024/3/28 17:44
 * @Version 1.0
 */
public class LeetCode438 {

    static HashMap<Character,Integer> window = new HashMap<>();
    static HashMap<Character,Integer> need = new HashMap<>();

    static List<Integer> indexs = new ArrayList<>();

    public static List<Integer> findAnagrams(String s, String p) {

        for (char c : p.toCharArray()) {
            if (need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else need.put(c, 1);
        }
        int right = 0;
        int left = 0;
        int start = 0;
        int valid = 0;
        while (right<s.length()){
            char c = s.charAt(right);
            right++;
            if(need.containsKey(c)){
                if(window.containsKey(c)){
                    window.put(c,window.get(c)+1);
                }
                else window.put(c,1);
                if(need.get(c).equals(window.get(c))) valid++;
            }
            while (right - left>=p.length()){
                if(valid == need.size())
                indexs.add(left);
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)){
                    if(window.containsKey(c1)){
                        window.put(c1, window.get(c1)-1);
                    }
                    if(!need.get(c1).equals(window.get(c1))) valid--;
                }
            }
        }
        return indexs;
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}
