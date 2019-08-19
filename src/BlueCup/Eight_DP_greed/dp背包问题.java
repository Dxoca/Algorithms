package BlueCup.Eight_DP_greed;

import java.util.Arrays;

import static java.lang.Math.max;

public class dp背包问题 {//01背包问题
    static int[] w = {2, 1, 3, 2};
    static int[] v = {3, 2, 4, 2};
    static int n = 4;//物品数量
    static int W = 5;//承重极限
    static int[][] rec;

    public static void main(String[] args) {

        //dp 做法
        int ans = dfs(0, W);
        System.out.println(ans);

        //重叠子问题不重复求解
        //计算之前做查询，计算之后做记录
        rec = new int[n][W + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(rec[i], -1);
        }
        ans = m(0, W);
        System.out.println(ans);
        //dp 做法
        ans = dp(n, W);
        System.out.println(ans);
    }

    private static int dp(int n, int W) {
        int[][] dp = new int[n][W + 1];//四组 0~W重量
        //初始化
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) {
            if (i >= w[0]) dp[0][i] = v[0];//可以容纳
            else dp[0][i] = 0;
        }
        for (int i = 1; i < n; i++) {//物品编号
            for (int j = 1; j < W + 1; j++) {//背包容量0~W
                if (j >= w[i]) dp[i][j] = max(v[i] + dp[i - 1][j - w[i]], dp[i - 1][j]);
                else dp[i][j] = dp[i - 1][j];//要不起 延用上次
            }
        }
        return (dp[n - 1][W]);
    }

    /**
     * O(2^n)
     *
     * @param i  第几个
     * @param ww 可用重量
     * @return
     */
    private static int dfs(int i, int ww) {
        if (ww <= 0) return 0;//装不进去
        if (i == n) return 0;//没有可选的了
        int v2 = dfs(i + 1, ww);//不选择当前物品
        if (ww >= w[i]) {
            int v1 = v[i] + dfs(i + 1, ww - w[i]);//选择当前问题
            return max(v1, v2);
        } else {
            return v2;
        }

    }

    /**
     * 记忆型递归
     *
     * @param i
     * @param ww
     * @return
     */
    private static int m(int i, int ww) {
        if (i == n) return 0;
        if (ww <= 0) return 0;
        //计算之前先查询
        if (rec[i][ww] != -1) return rec[i][ww];
        int ans;
        int v2 = m(i + 1, ww);
        if (ww >= w[i]) {
            int v1 = v[i] + m(i + 1, ww - w[i]);
            ans = max(v1, v2);
        } else {
            ans = v2;
        }
        rec[i][ww] = ans;
        return ans;
    }

}
