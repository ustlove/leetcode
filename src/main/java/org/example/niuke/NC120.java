package org.example.niuke;

/**
 * @ClassName NC120 32位二进制中1的个数
 * @Description TODO
 * @Author ASUS
 * @Date 2024/2/7 14:30
 * @Version 1.0
 */
public class NC120 {
    public int NumberOf1 (int n) {

        int res = 0;
        for (int i = 0;i<32;i++){
           n = n>>1;
          res+=n&1;
        }
        return  res;

        // write code here
    }
}
