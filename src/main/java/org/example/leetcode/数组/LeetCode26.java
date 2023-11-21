package org.example.leetcode.数组;

/**
 * @ClassName LeetCode26
 * @Description 给你一个 非严格递增排列 的数组 nums ，
 * 请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，
 * 返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 然后返回 nums 中唯一元素的个数。
 * @Author ASUS
 * @Date 2024/4/8 9:25
 * @Version 1.0
 */
public class LeetCode26 {

    public int removeRepeatedNum(int [] nums){
        int slow = 0;
        for (int fast = 0; fast <nums.length ; fast++) {
            if(nums[slow] == nums[fast]) continue;
            slow++;
            nums[slow] = nums[fast];
        }
        return slow+1;
    }
    public int removeTarget(int[] nums,int target){
        //[1,2,1,3,4,1] 1
        int slow = 0;
        for (int fast = 0;fast<nums.length;fast++){
            if(nums[fast] == target){
                continue;
            }
            nums[slow]=nums[fast];
            slow++;
        }
        return slow;




    }



    public static void main(String[] args) {
        int[] ints = {1, 1, 2, 2, 3, 3, 4, 5, 6, 6};

        int i = new LeetCode26().removeRepeatedNum(ints);
        for (int i1 = 0; i1 < ints.length; i1++) {
            System.out.println(ints[i1]);
        }
        System.out.println("size:"+i);

    }
}
