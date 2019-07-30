package BlueCup.Seven_recursion;

import java.util.Scanner;

public class _703_机器人走方格 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int x = cin.nextInt();
        int y = cin.nextInt();
        int ans = solve(x, y);

        System.out.println(ans);
    }

    private static int solve(int x, int y) {
        //顺着想 倒着写
        if (x == 1) return 1;
        if (y == 1) return 1;
        return solve(x - 1, y) + solve(x, y - 1);
    }

    /**
     * 迭代形式
     */
    //dp公式 f(x,y)=f(x-1,y)+f(x,y-1);
    //当x或y=1时 无论怎样都只有一部
    public static int f(int m, int n) {
        int[][] state = new int[m + 1][n + 1];//缓存 想染色
        for (int i = 1; i <= n; i++) {//每一列的第一行
            state[1][i] = 1;
        }
        for (int i = 1; i <= m; i++) {//每一行的第一列
            state[i][1] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                state[i][j] = state[i][j - 1] + state[i - 1][j];
            }
        }
        return state[m][n];

    }

}
