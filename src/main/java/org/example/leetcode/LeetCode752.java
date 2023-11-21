package org.example.leetcode;

import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/28 16:33
 * @Version 1.0
 */
public class LeetCode752 {
    // leetcode 752 bfs
    static Set<String> visited =  new HashSet<>();
    static Queue<String> queue = new LinkedList<>();
    public int openLock(String[] deadends, String target) {
        int step = 0;
        for (String dead:deadends){
            visited.add(dead);
        }
        queue.offer(target);

        while (!queue.isEmpty()){
            String poll = queue.poll();
            if (visited.contains(poll)) continue;
            if(poll.equals(target)) return step;
            visited.add(poll);
            step++;
            for (int i = 0; i < 4; i++) {
                String upOne = upOne(poll, i);
                queue.offer(upOne);
                String downOne = downOne(poll, i);
                queue.offer(downOne);
            }
        }
        return -1;
    }

    private String upOne(String s,int j){
        char[] chars = s.toCharArray();
        if(chars[j]=='9') chars[j]='0';
        else chars[j] += 1;
        return Arrays.toString(chars);
    }
    private String downOne(String s,int j){
        char[] chars = s.toCharArray();
        if(chars[j]=='0') chars[j]='9';
        else chars[j]-= 1;
        return Arrays.toString(chars);
    }






}
