package org.example.leetcode.动态规划;

import sun.text.resources.cldr.zh.FormatData_zh_Hans_MO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @ClassName LeetCode354
 * @Description 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 *
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 *
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 *
 *
 *
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * [2,3]
 * [5,4]
 * [6,7]
 * [6,4]
 * 输出：3
 * 解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。
 *
 * 示例 2：
 * @Author ASUS
 * @Date 2024/4/8 15:16
 * @Version 1.0
 */
public class LeetCode354 {

    public int maxEnvelopesNum(ArrayList<int []> envelopes){
        int [] dp = new int[envelopes.size()];
        Arrays.fill(dp,1);
        // 对信封排队
        envelopes.sort((a,b)->{
            if(a[0] ==b[0] ) return b[1]-a[1];
            return a[0]-b[0];
        });
        for (int i = 0; i < envelopes.size(); i++) {
            for (int j = 0; j < i; j++) {
                int[] is = envelopes.get(i);
                int[] js = envelopes.get(j);
                if(is[0]>js[0] && is[1]>js[1] ){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int r = 0;
        for (int i = 0; i < dp.length; i++) {
            r =Math.max(dp[i],r);
        }
        return  r;





    }

    public static void main(String[] args) {

    }





}
