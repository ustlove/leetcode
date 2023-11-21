package org.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @ClassName Tianjisaima
 * @Description 田忌赛马问题
 * @Author ASUS
 * @Date 2024/3/29 9:07
 * @Version 1.0
 */
public class Tianjisaima {
    //降序
    static PriorityQueue<int []> queue = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);

    public int [] solution(int [] t,int [] nums) {

        int[] res = new int[t.length];
        //升序
        Arrays.sort(t);


        for (int i = 0; i < nums.length; i++) {
            int[] temp = new int[2];
            temp[0] = i;
            temp[1] = nums[i];
            queue.offer(temp);
        }
        int left = 0;
        int right = t.length - 1;
      while (!queue.isEmpty()) {
          int[] poll = queue.poll();
          if (t[right] > poll[1]) {
              res[poll[0]] = t[right];
              right--;
          } else {
              res[poll[0]] = t[left];
              left++;
          }
      }

        return res;
    }

    public static void main(String[] args) {
        int [] t =  new int[]{20,32,15,40}; // 15 20 32 40   20 15 15 32
        int []nums = new int[]{15,40,12,25}; //40 25 15 12
        int[] solution = new Tianjisaima().solution(t, nums);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }
    }




}
