package org.example.niuke;

/**
 * @ClassName CC167 二进制插入
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/25 15:22
 * @Version 1.0
 */
public class CC167 {

          /* 1024 19 2 6*/
        public int binInsert(int n, int m, int j, int i) {
            // write code here
            m = m << j;
            return n | m;
        }

}
