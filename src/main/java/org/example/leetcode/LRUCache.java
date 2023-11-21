package org.example.leetcode;

import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @ClassName LRUCache
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/1 8:11
 * @Version 1.0
 */
public class LRUCache<K,V> {
    int cap;
    int DEFAULT_CAP = 16;
    LinkedHashMap<K,V> map ;
    public LRUCache(int cap){
        if(cap < 0) throw new RuntimeException();
        this.cap = cap;
        init();
    }
    public LRUCache(){
        this.cap = DEFAULT_CAP;
        init();
    }
    void init(){
       if (map == null){
           map = new LinkedHashMap<>(cap);
       }
    }

    public  V get(K k){
        if(!map.containsKey(k)){
            return  null;
        }
        map.remove(k);
        V v = map.get(k);
        map.put(k,v);
        return v;

    }
    public void set(K k, V v){
        if(map.containsKey(k)){
            map.put(k,v);
        }
        if(map.size() ==16){
            K next = map.keySet().iterator().next();
            map.remove(next);
        }
        map.put(k,v);


    }
}
