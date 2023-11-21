package org.example.niuke.链表合并;

import java.util.Stack;

/**
 * @ClassName DubbleStack
 * @Description TODO
 * @Author ASUS
 * @Date 2024/3/23 13:53
 * @Version 1.0
 */
public class DubbleStack {


    Stack<Integer> push = new Stack<>();
    Stack<Integer> pop = new Stack<>();

    public Integer pop(){

        while (!push.isEmpty()){
            pop.push(push.pop());
        }
       return pop.pop();
    }
    public Integer push(Integer item){
       return push.push(item);
    }

    public static void main(String[] args) {
        DubbleStack dubbleStack = new DubbleStack();
        dubbleStack.push(1);
        dubbleStack.push(3);
        System.out.println(dubbleStack.pop());
        System.out.println(dubbleStack.pop());
    }


}
