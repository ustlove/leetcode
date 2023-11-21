package org.example.HJ;

/**
 * @ClassName HJ2 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 * @Description TODO
 * @Author ASUS
 * @Date 2024/2/8 18:03
 * @Version 1.0
 */
public class HJ2 {
    public static int solution(String string,char c){
        String lowerCase = string.toLowerCase();
          int sum = 0;
        for (int i = 0; i <lowerCase .length(); i++) {
            if (Character.toLowerCase(c) == lowerCase.charAt(i)){
                sum++;
            }
        }
        return sum;
    }
}
