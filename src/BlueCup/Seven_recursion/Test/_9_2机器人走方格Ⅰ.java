package BlueCup.Seven_recursion.Test;

public class _9_2机器人走方格Ⅰ {
    public static void main(String[] args) {

        System.out.println(countWays(2,3));
    }

    public static int countWays(int x, int y) {
        int[][] dp = new int[x][y];
        for (int i = 0; i < x; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < y; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return  dp[x-1][y-1];
    }
}
