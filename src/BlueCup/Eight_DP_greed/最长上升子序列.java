package BlueCup.Eight_DP_greed;

import java.util.Scanner;

import static java.lang.Math.max;

public class 最长上升子序列 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        System.out.println(f(a, n));
        System.out.println(dp(a, n));
        System.out.println(dp01(a, n));

    }

    /**
     * dp[i] 长度为i的L O(nlgn)
     * IS
     * @param a
     * @param n
     * @return
     */
    private static int dp01(int a[], int n) {
        int[] dp = new int[n + 1];
        int p;//记录dp更新的最后位置
        dp[p = 1] = a[0];//长度为1的最长递增子序列，初始化为第一个元素
        for (int i = 1; i < a.length; i++) {
            if (a[i] > dp[p])//新元素和dp的关系 如果遇到比i大的数 那就 存进去 并指针后移
                dp[p++ + 1] = a[i];//递增子序列长度增加
            else {//递增子序列长度 不 增加
                //扫描dp 替换第一个比arr[i]大的dp
                for (int j = 0; j <= p; j++) {
                    if (dp[j] > dp[i])//
                        dp[j] = a[i];
                }
            }
        }
        return p;
    }

    /**
     * dp 递推 逐步解决
     * O(n^2)pd[i] 是以i结尾的 序列
     * j是待比较 i是比较的目标
     *
     * @param a
     * @param n
     * @return
     */
    private static int dp(int[] a, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int cnt = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j])
                    cnt = max(cnt, dp[j] + 1);//所有dp表中最大的~
            }
            dp[i] = cnt;
        }
        int ans = -1;
        for (int i : dp) ans = max(ans, i);//最后遍历一遍dp[i]
        return ans;
    }

    /**
     * 暴力解法 o(n^2)
     *
     * @param a
     * @param n
     * @return
     */
    private static int f(int[] a, int n) {
        int maxCnt = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;//从1 开始 最短就是1
            int p = i;//记录被大于的数值索引
            for (int j = i + 1; j < n; j++) {
                if (a[j] > a[p]) {
                    cnt++;
                    p = j;
                }
            }
            maxCnt = max(maxCnt, cnt);
        }
        return maxCnt;
    }
}
