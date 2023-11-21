package org.example.niuke;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName NC137 整数计算器  (2*(3-4))*5
 * @Description TODO
 * @Author ASUS
 * @Date 2024/2/1 10:33
 * @Version 1.0
 */
public class NC137 {

    public int calculate(String s){
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0 ; i < s.length() ; i++){
            if(Character.isDigit(s.charAt(i))){
                num = Integer.valueOf(s.charAt(i));
            }
            if(s.charAt(i)=='('){
                int j = i+1;
                int counterPartition = 1;
                while (counterPartition >0){
                    if(s.charAt(j) == '('){
                        counterPartition++;
                    }
                    if(s.charAt(j)==')'){
                        counterPartition--;
                    }
                    j++;
                }
                num = calculate(s.substring(i+1,j-1));
                i= j-1;
            }
            if(!Character.isDigit(s.charAt(i)) || i ==s.length() - 1){
                switch (sign){
                    case '+':stack.push(num);num=0;sign=s.charAt(i);break;
                    case '-':stack.push(-1 *num);num=0;sign=s.charAt(i);break;
                    case '*':stack.push(stack.pop() * num);num=0;sign=s.charAt(i);break;

                }
            }

        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans+=stack.pop();
        }
        return ans;
    }



}
