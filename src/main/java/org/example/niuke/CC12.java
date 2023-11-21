package org.example.niuke;

import java.util.Collections;
import java.util.Set;

/**
 * @ClassName CC12 拆分词句
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/28 11:16
 * @Version 1.0
 */
public class CC12 {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean []array = new boolean[s.length() +1];
        array[0] = true;
        for (int i =1;i<s.length();i++){
            for (int j = 0 ;j<i; j++){
                if(array[j] && dict.contains(s.substring(j,i))){
                    array[i] = true;
                    break;
                }
            }
        }
        return array[array.length-1];
    }
}
