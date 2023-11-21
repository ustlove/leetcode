package org.example.leetcode.括号匹配;

import java.util.Stack;

/**
 * @ClassName LeetCode1541
 * @Description 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 *
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 * 比方说 "())"， "())(())))" 和 "(())())))" 都是平衡的， ")()"， "()))" 和 "(()))" 都是不平衡的。
 *
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 *
 * 请你返回让 s 平衡的最少插入次数。
 *
 * 示例 1：
 *
 * 输入：s = "(()))"
 * 输出：1
 * 解释：第二个左括号有与之匹配的两个右括号，但是第一个左括号只有一个右括号。我们需要在字符串结尾额外增加一个 ')' 使字符串变成平衡字符串 "(())))" 。
 * @Author ASUS
 * @Date 2024/4/17 18:27
 * @Version 1.0
 */
public class LeetCode1541 {
public static int minAddNum(String s){
    Stack<Character> stack = new Stack<>();
    int length = 0;
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == '('){
            stack.push(c);
        }else {
            if(!stack.isEmpty() ){
                if( i+1 <s.length()) {
                    if (s.charAt(i + 1) == ')') {
                        stack.pop();
                        i = i + 1;
                    }
                }else {
                    length = s.length()-i;
                }
            }else {
                length = (s.length() - i) ;
                break;
            }

        }

    }
    return stack.isEmpty()?length/2:stack.size()* 2- length;
    
    
    
    
}
public static void main(String[] args){
    System.out.println(minAddNum("))())("));
}


}
