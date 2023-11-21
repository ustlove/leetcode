package org.example.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName RandomSet
 * @Description TODO
 * @Author ASUS
 * @Date 2024/4/1 11:26
 * @Version 1.0
 */
public class RandomSet {

    ArrayList<Integer> nums = new ArrayList<>();
    HashMap<Integer,Integer> map = new HashMap<>();

    boolean insert(Integer num){
        if(nums.contains(num)) return  false;
        map.put(num,nums.size());
        nums.add(num);
        return true;
    }
    boolean remove(Integer num){
        if(!nums.contains(num)) return false;
        Integer index = map.get(num);
        Integer last = nums.get(nums.size() - 1);
        nums.set(index,last);
        map.put(last,index);
        nums.set(nums.size()-1,num);
        map.remove(num);
        return true;
    }
    int randomGet(){
        Random R = new Random();
        int random =R.nextInt() % nums.size();
        return nums.size();
    }




}
