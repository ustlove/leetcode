package org.example.niuke.最长公共子序列;

import java.util.concurrent.*;

/**
 * @ClassName Main
 * @Description TODO
 * @Author ASUS
 * @Date 2024/1/31 13:56
 * @Version 1.0
 */
public class Main {
    // abcde
    // abcfe
    public String  LCS(String s1,String s2){


        int max= 0;
        String s="";
        for (int i = 0; i < s1.length(); i++) {
          for(int j = i+1;j<=s1.length();j++){
              if(!s2.contains(s1.substring(i,j))){
                  i=j;
              }
              if(s1.substring(i,j).length()>s.length()){
                  s=s1.substring(i,j);
              }
              max = Math.max(max,j-i);
          }

        }
        return max+"::"+s;
        
        
    }

    public static void main(String[] args) {

        String lcs = new Main().LCS("abcdakhdaoabc", "abcdpdj");
        System.out.println(lcs);
        ScheduledThreadPoolExecutor  scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);

    }
}
