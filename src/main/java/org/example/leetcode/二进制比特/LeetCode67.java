package org.example.leetcode.二进制比特;

/**
 * @ClassName LeetCode67
 * @Description 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 *
 * 示例 1：
 *
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 *
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * @Author ASUS
 * @Date 2024/4/16 17:06
 * @Version 1.0
 */
public class LeetCode67 {

    public String sumOfBin(String a,String b){
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int m = a.length(), n = b.length();
        // carry 记录进位
        int carry = 0; int i = 0;
        while (i < Math.max(m, n) || carry > 0) {
            int val = carry;
            val += i < m ? (a.charAt(i) - '0') : 0;
            val += i < n ? (b.charAt(i) - '0') : 0;
            sb.append(val % 2);
            carry = val / 2;
            i++;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
    }
}
