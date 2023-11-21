package org.example.leetcode.数组;

/**
 * @ClassName LeetCode5
 * @Description 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * @Author ASUS
 * @Date 2024/4/8 10:08
 * @Version 1.0
 */
public class LeetCode5 {

    /**
     * 指针从中间
     * @param s
     * @return
     */
    public String maxLengthPall(String s){
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String a = isPalindrome(s,i,i);
            String b = isPalindrome(s,i,i+1);
            max =max.length() > a.length()?max:a;
            max = max.length()>b.length()?max:b;
        }
return max;
    }

    /**
     * 如果 l==r 则奇数 aba
     * 否则 偶数  abba
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String isPalindrome(String s,int left,int right){


        while (right <s.length()&&(s.charAt(left) == s.charAt(right))){
            if(left-1<0 || right+1>=s.length()){
                return s.substring(left+1,right+1);
            }
            left--;
            right++;
        }
        return s.substring(left+1,right);
    }
    public static void main(String[] args) {
        String s = new LeetCode5().maxLengthPall("babad");
        System.out.println(s);
    }



}
