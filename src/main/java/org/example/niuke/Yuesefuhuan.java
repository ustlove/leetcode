package org.example.niuke;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName Yuesefuhuan
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/24 16:33
 * @Version 1.0
 */
public class Yuesefuhuan {


    public static  int solution(int n,int m){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int temp = 0;
        while (list.size()>1){
            temp = (temp+m-1) % list.size();
            System.out.println(list.get(temp));
           list.remove(temp);
        }

return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(solution(5,3));
    }
}
