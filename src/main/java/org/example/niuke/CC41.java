package org.example.niuke;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @ClassName CC41 最长无重复子数组
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/30 13:56
 * @Version 1.0
 */
public class CC41 {
    // 1 2 3 4 5 4 4 6
    //  4 6
    //  1 2 3

    public int maxLength (int[] arr) {
     if(arr.length == 0) return  0;
     int max = 0;

     HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0,j = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
               j = map.get(arr[i])+1;
            }
            map.put(arr[i],i);
            max = Math.max(max,i-j+1);
        }
        return max;
        // write code here
    }
    public int maxLength(int[] arr,int a){
        Queue<Integer>  queue = new LinkedList<>();
        int res = 0;
        for (int c : arr){
            while (queue.contains(c)){
                queue.poll();
            }
            queue.offer(c);
            res = Math.max(res,queue.size());
        }
        return res;
    }
}
