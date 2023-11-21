package org.example.niuke;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * @ClassName NC73 数组中出现次数超过一半的数字
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/29 11:46
 * @Version 1.0
 */
public class NC73 {


    public int MoreThanHalfNum_Solution (int[] numbers) {
       Map<Integer,Integer> map = new HashMap();
       for (int i = 0 ;i< numbers.length;i++){
           int j = 0;
           map.put(numbers[i],++j);
       }
       int res = 0;
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if(next.getValue() > numbers.length / 2)
                return  next.getKey().intValue();
        }
        return 0;
        // write code here
    }
}
