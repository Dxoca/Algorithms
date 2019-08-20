package BlueCup.Eight_DP_greed;

import java.util.Arrays;

import static java.lang.Math.max;

public class 钢条切割问题 {
    static int n = 10;
    static int[] p = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30};

    public static void main(String[] args) {
        Arrays.fill(rec, -1);//务必 rec初始化
        int ans = r(n);
        System.out.println(ans);
        Arrays.fill(dp, -1);
        ans = dp(n);
        System.out.println(ans);

    }
    static int[] dp = new int[n + 1];
    private static int dp(int n) {
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {//拥有钢条的长度
            for (int j = 1; j <= i; j++) {//保留为 j的段数
                dp[i] = max(p[j - 1] + dp[i - j], dp[i]);//查整段+ 查 最佳切割方案 求出最大
            }
        }
        return dp[n];
    }


    static int[] rec = new int[n + 1];
    private static int r(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i <= x; i++) {
            if (rec[x - i] == -1) {//计算之前做查询
                rec[x - i] = r(x - i);
            }
            int v = p[i - 1] + rec[x - i];
            ans = max(v, ans);
        }
        rec[x] = ans;//计算之后做记录
        return ans;
    }

}

