package org.example.HJ;

/**
 * @ClassName HJ1 字符串最后一个单词的长度
 * @Description TODO
 * @Author ASUS
 * @Date 2024/2/8 17:56
 * @Version 1.0
 */
public class HJ1 {
    public static int solution(String string){
        int last = string.lastIndexOf(" ");
       return string.length()-last-1;
    }

    public static void main(String[] args) {
        int helloNowcoder = solution("hello nowcoder abc");
        System.out.println(helloNowcoder);
    }
    
}
