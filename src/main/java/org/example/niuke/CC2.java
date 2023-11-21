package org.example.niuke;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName CC2 逆波兰表达式  ["20", "10", "+", "30", "*"] -> ((20 + 10) * 30) -> 900
 *                               ["40", "130", "50", "/", "+"] -> (40 + (130 / 50)) -> 42
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/26 12:36
 * @Version 1.0
 */
public class CC2 {
    public int evalRPN (String[] tokens) {
        Stack<Integer> stack = new Stack<>();
       for (String token:tokens){
           try {
               int i = Integer.parseInt(token);
               stack.add(i);
           }catch (Exception e){
               int a = stack.pop();
               int b = stack.pop();
               stack.add(get(a,b,token));
           }
       }
       return stack.pop();
        // write code here
    }
    int get(int num1,int num2,String operator){
        switch (operator){
            case "+": return num1 + num2;
            case "*": return num1 * num2;
            case "-": return num1 - num2;
            case "/": return num1 / num2;
            default: return 0;
        }

    }
}
