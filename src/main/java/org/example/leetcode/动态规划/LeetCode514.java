package org.example.leetcode.动态规划;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName LeetCode514
 * @Description 自由之路
 *电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，
 * 并使用表盘拼写特定关键词才能开门。
 *
 * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，
 * 表示需要拼写的关键词。
 * 您需要算出能够拼写关键词中所有字符的最少步数。
 *
 * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，
 * 然后按下中心按钮，
 * 以此逐个拼写完 key 中的所有字符。
 *
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 *
 * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，
 * 并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，
 * 这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）,
 * 直至完成所有拼写。
 * @Author ASUS
 * @Date 2024/4/10 14:39
 * @Version 1.0
 */
public class LeetCode514 {

    Map<Character, LinkedList<Integer>> ringToIndex = new HashMap<>();
    int[][] matrix ;
    public  int minStep(String ring ,String key){
        matrix = new int[ring.length()][key.length()];
        for (int i = 0; i <ring.length() ; i++) {
            char c = ring.charAt(i);
            if(!ringToIndex.containsKey(c)){
                ringToIndex.put(c,new LinkedList());
            }
            ringToIndex.get(c).add(i);
        }
        return dp(ring,0,key,0);
    }

    private int dp(String ring, int i, String key, int j) {
        if(j == key.length()) return 0;
        if(matrix[i][j] != 0){
            return matrix[i][j];
        }
        int res= Integer.MAX_VALUE;
        for (int k:ringToIndex.get(key.charAt(j))){
            //波动指针的次数
            int delta = Math.abs(k-i);
            //选择顺时针还是逆时针
            delta = Math.min(delta,ring.length()-delta);
            //将指针拨到k
            int subProblem = dp(ring,k,key,j+1);
            //记录k到指定位置的最小操作数
            res = Math.min(res,delta+1+subProblem);

        }
        matrix[i][j] = res;
        return res;






    }
}
