package org.example.niuke;

/**
 * @ClassName NC19 连续子数组最大和
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/30 10:43
 * @Version 1.0
 */
public class NC19 {

    public int FindGreatestSumOfSubArray (int[] array) {
        int sum = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(sum+array[i],array[i]);
            max = Math.max(max,sum);
        }
        return max;
        // write code here
    }
}
