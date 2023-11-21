package org.example.leetcode;

import org.example.designmodel.factory.Car;

import java.util.Stack;

/**
 * @ClassName LeetCode20
 * @Description 栈 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * @Author ASUS
 * @Date 2024/3/29 9:01
 * @Version 1.0
 */
public class LeetCode20 {

    static Stack<Character> stack = new Stack<>();

    public boolean solution(String s){
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c=='{' || c=='['){
                stack.push(c);
            }else {
                if(!stack.isEmpty() && stack.peek() == of(c)){
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    private Character of(char c){

        if(c ==')') return '(';
        if(c == '}') return '{';
        return '[';
    }
}
