package org.example.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * @ClassName LeetCode131
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/3 10:11
 * @Version 1.0
 */
public class LeetCode131 {

    LinkedList<LinkedList<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();

    public LinkedList<LinkedList<String>> split(String s){
        backtrack(s,0);
        return res;
    }


    private void backtrack(String s, int start) {
        if(start == s.length()){
            res.add(new LinkedList<>(track));
        }
        for (int i = start; i < s.length(); i++) {

            if(!isPalindrome(start,i,s)){
                continue;
            }
            track.add(s.substring(start,i+1));
            backtrack(s,i+1);
            track.removeLast();
        }
    }

    private boolean isPalindrome(int start, int i, String s) {
        while (start<i){
            if (s.charAt(start) != s.charAt(i)) return false;
            start++;
            i--;
        }
        return true;
    }

}
