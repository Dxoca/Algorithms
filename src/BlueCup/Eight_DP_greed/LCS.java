package BlueCup.Eight_DP_greed;

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.random;

public class LCS {
    public static void main(String[] args) {
        String s1, s2;
        s1 = "3069248";
        s2 = "513164318";
        System.out.println(dfs(s1, s2) + dp(s1, s2));
        s1 = "3563243";
        s2 = "513141";
        System.out.println(dfs(s1, s2)+ dp(s1, s2));
        s1 = "123";
        s2 = "456";
        System.out.println(dfs(s1, s2)+ dp(s1, s2));
    }

    /**
     * DFS求LCS
     * 双重循环 多路分支
     *
     * @param s1
     * @param s2
     * @return
     */
    private static ArrayList<Character> dfs(String s1, String s2) {
        int len1 = s1.length(),
                len2 = s2.length();
        ArrayList<Character> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {//每个打头
            ArrayList<Character> tmp = new ArrayList<>();
            for (int j = 0; j < len2; j++) {//找s1s2相同的
                if (s1.charAt(i) == s2.charAt(j)) {
                    tmp.add(s1.charAt(i));
                    tmp.addAll(dfs(s1.substring(i + 1), s2.substring(j + 1)));//递归 扫描找后续公共子序列
                    break;//找到 退出
                }
            }
            if (tmp.size() > ans.size()) {
                ans = tmp;
            }
        }
        return ans;
    }

    /**
     * 比对范围在做变化
     * 单元格的意义 当前范围S1S2的长度
     *
     * @param s1
     * @param s2
     */
    private static String dp(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];//字符比较与dp保持一致 有无字符 i-1
        //注意 是从索引 1 开始的！！
        //初始化第一列
        int flag = 0;
        for (int i = 1; i <= len1; i++) {
            if (flag == 1) {
                dp[i][1] = 1;
            } else if (s1.charAt(i - 1) == s2.charAt(0)) {//相同一个 后面全是1
                dp[i][1] = 1;
                flag = 1;
            } else {
                dp[i][1] = 0;
            }
        }
        //初始化第一行
        flag = 0;
        for (int i = 1; i <= len2; i++) {
            if (flag == 1) {
                dp[1][i] = 1;
            } else if (s2.charAt(i - 1) == s1.charAt(0)) {
                dp[1][i] = 1;
                flag = 1;
            } else {
                dp[1][i] = 0;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int maxOfLeftAndUp = max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {//上，左贡献度相同 三者比较
                    dp[i][j] = max(maxOfLeftAndUp, dp[i - 1][j - 1] + 1);//左上角+1
                } else
                    dp[i][j] = maxOfLeftAndUp;
            }
        }
        return parseDp(dp, s1, s2);//对已经打表的内容进行反向解析
    }

    /**
     * 解析动态规划表 得到最长公共子序列
     * 恢复子序列 dp（状态转移方程）逆推
     *
     * @param dp
     * @param s1
     * @param s2
     * @return
     */
    private static String parseDp(int[][] dp, String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        StringBuilder sb = new StringBuilder();
        while (m > 0 && n > 0) {
            //比左边上边大一定是当前位置字符 相等
            if (dp[m][n] > max(dp[m - 1][n], dp[m][n - 1])) {
                sb.insert(0, s1.charAt(m - 1));
                m--;
                n--;
            } else {//一定选择左边和上边中最大的
                if (dp[m - 1][n] > dp[m][n - 1]) {
                    m--;//上移动
                } else {
                    n--;//左边移动
                }
            }
        }
        return sb.toString();
    }
}
