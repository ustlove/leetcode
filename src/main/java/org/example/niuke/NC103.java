package org.example.niuke;

/**
 * @ClassName NC103 反转字符串
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/29 11:14
 * @Version 1.0
 */
public class NC103 {
    public String solve (String str) {
        String reverse = "";
        for (int i = 0;i< str.length();i++){
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
        // write code here
    }
}
