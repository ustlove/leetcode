package org.example.leetcode.数组;

/**
 * @ClassName LeetCode176
 * @ 给你一个下标从 1 开始的整数数组 numbers ，
 * 该数组已按 非递减顺序排列 ，
 * 请你从数组中找出满足相加之和等于目标数 target 的两个数。
 * 如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，
 * 则 1 <= index1 < index2 <= numbers.length 。
 * @Author ASUS
 * @Date 2024/4/8 10:02
 * @Version 1.0
 */
public class LeetCode176 {

    public int[] findSumsOfTowNum(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left<right){

            if(nums[left]+nums[right]>target){
                 right--;
            } else if (nums[left]+nums[right] == target) {
                return new int[]{left,right};
            }
            else {
                left++;
            }
        }
        return new int[]{-1,-1};
    }

}
