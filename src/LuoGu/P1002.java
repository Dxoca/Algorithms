package LuoGu;

import javax.security.auth.login.AccountException;
import java.util.Scanner;
import java.util.zip.Deflater;

import static java.lang.Math.abs;
//错误
public class P1002 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, m, my, mx;
        n = cin.nextInt();//列
        m = cin.nextInt();//行
        my = cin.nextInt();//列
        mx = cin.nextInt();//行
        //B(n,m) ,C(o,p)
        long[][] dp = new long[m + 1 ][n + 1 ];//主义mn与 xy关系
        //从11 到mn 的矩阵  初始化1行1列 动态从 22 开始
        for (int i = 2; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 2; i <= m; i++) {
            dp[0][1] = 1;
        }
        int as=-1;
        dp[my][mx] = as;
        dp[my + 2][mx + 1] = as;
        dp[my + 2][mx - 1] = as;
        dp[my - 2][mx + 1] = as;
        dp[my - 2][mx - 2] = as;
        dp[my + 1][mx + 2] = as;
        dp[my + 1][mx - 2] = as;
        dp[my - 1][mx + 2] = as;
        dp[my - 1][mx - 2] = as;

        for (int i = 3; i <= m; i++) {//行
            for (int j = 3; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        System.out.println(dp[mx][my]);

    }

}
