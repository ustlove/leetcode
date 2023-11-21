package org.example.leetcode;

import java.util.Stack;

/**
 * @ClassName LeetCode224
 * @Description 基本计算器
 * @Author ASUS
 * @Date 2024/4/1 10:13
 * @Version 1.0
 */
public class LeetCode224 {
    static Stack<Integer> stack = new Stack();
    int index = 0;


    public int solution(String s){
        char[] charArray = s.toCharArray();
        return calutate(charArray);
    }

    private int calutate(char[] charArray) {
        char sign = '+';
        int num = 0;
        for (;index < charArray.length; index++) {
            char c = charArray[index];
            if( c=='('){
                index++;
                num = calutate(charArray);
            }
            else if(Character.isDigit(c)){
                num = Integer.valueOf(c);
            }
            else if(c=='+' || c=='-'||c=='*' || c=='/'|| index==charArray.length-1){
                switch (sign){
                    case '+': stack.push(num);break;
                    case '-': stack.push(-num);break;
                    case '*': num = num * stack.peek();stack.push(num);break;
                    case '/': num = (int) (stack.peek() / num); stack.push(num);break;
                }
                sign = c;
                num = 0;
            } else if (c==')') {
                index++;
                break;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}
