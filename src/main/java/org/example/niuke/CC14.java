package org.example.niuke;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CC14 只出现一次的元素 其余元素出现3次
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/25 13:04
 * @Version 1.0
 */
public class CC14 {

    public int singleNumber (int[] A) {
        Arrays.sort(A);
       int i = 0;
       while (i+1<A.length){
           if(A[i]==A[i+1]){
               i+=3;
           }
           else return A[i];
       }
       return A[i];
    }
}
