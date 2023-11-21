package org.example.niuke;

/**
 * @ClassName NC68 跳台阶
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/29 11:08
 * @Version 1.0
 */
public class NC68 {
    /**
     *1:1 2:2 3:3 4:5 5:11111 122 212 221 1112 1211 2111 1121
     *
     *
     * @param number
     * @return
     */

    public int jumpFloor (int number) {
        if(number<=3) return number;
        return jumpFloor(number-1) +jumpFloor(number-2);
        // write code here
    }
}
