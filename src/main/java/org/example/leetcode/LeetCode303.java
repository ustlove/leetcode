package org.example.leetcode;

/**
 * @ClassName LeetCode303
 * @Description 前缀和数组
 * @Author ASUS
 * @Date 2024/3/29 8:41
 * @Version 1.0
 */
public class LeetCode303 {
}
class NumArray{
    public int[] pre_sums;

    public NumArray(int[] nums){
        pre_sums = new int[nums.length+1];
        pre_sums[0] = 0;
        for (int i = 1; i < pre_sums.length; i++) {
            pre_sums[i] = nums[i-1]+pre_sums[i-1];
        }
    }
// 1 , 2
    int sumRange(int left,int right){
        return pre_sums[right+1]-pre_sums[left];
    }


}