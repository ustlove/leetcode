package org.example.niuke;

/**
 * @ClassName CC15 只出现一次的元素 其余元素出现2次
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/25 13:00
 * @Version 1.0
 */
public class CC15 {

    public int singleNumber (int[] A) {
        int res = 0;
        for (int i=0;i<A.length;i++){
            res ^=A[i];
        }
        return res;
    }
}
