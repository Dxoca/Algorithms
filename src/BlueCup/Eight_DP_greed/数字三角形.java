package BlueCup.Eight_DP_greed;

import java.util.Scanner;

import static java.lang.Math.max;

public class 数字三角形 {
    //改问题不是贪心，不能通过上一步决定下一步
    static int n;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        int[][] triangel = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                triangel[i][j] = cin.nextInt();
            }
        }
        int ans = dp(triangel);
        System.out.println(ans);
        ans = dpOne(triangel);
        System.out.println(ans);
        ans = maxAns(0, 0, triangel);
        System.out.println(ans);
    }

    /**
     * -位置在变 分析依赖 先求什么后求什么
     * 所以我们从最后一行开始解决问题 maxLine-i
     *
     * @param triangel
     * @return
     */
    private static int dp(int[][] triangel) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangel[n - 1][i];//最后一行
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangel[i][j] + max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    /**
     * 滚动数组DP 节约空间
     * 把dp压缩为一维
     * 注意 dp是 i的索引
     */
    private static int dpOne(int[][] triangel) {
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = triangel[n - 1][i];//最后一行
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangel[i][j] + max(dp[j], dp[j + 1]);
            }
        }
        return dp[0];
    }

    /**
     * 递归解法
     * @param i
     * @param j
     * @param triangel
     * @return
     */
    private static int maxAns(int i, int j, int[][] triangel) {
        if (i == n - 1) {//到达最后一行
            return triangel[i][j];
        } else {//定点的数值 +左侧 右侧 的最大值
            return triangel[i][j] + max(maxAns(i + 1, j + 1, triangel), maxAns(i + 1, j, triangel));
        }
    }
}
