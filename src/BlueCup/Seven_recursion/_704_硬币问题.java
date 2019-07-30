package BlueCup.Seven_recursion;

public class _704_硬币问题 {
    public static void main(String[] args) {

        question1();//华为面试 1 2 5 分硬币 组合1角 有多少种组合

        int n = 5;
//        int ans = q2(n);//CC150 1 5 10 25分 n分 有多少种组合方法
//        System.out.println(ans);

        //CC150 1 5 10 25分 n分 有多少种组合方法
        for (int i = 0; i <= 10; i++) {//i 是硬币的个数
            int ways = countWays(i);
            System.out.println(i + "\tCouns Ways:" + ways);
        }
        DPcoutWays(20);

    }

    //华为面试 1 2 5 分硬币 组合1叫 有多少种组合 暴力美剧
    private static void question1() {
        int count = 0;
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 5; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (i * 1 + j * 2 + k * 5 == 10) {
                        System.out.println(i + "+" + j + "+" + k);
                        count++;
                    }
                }
            }
        }
        System.out.println("Ways:" + count);
    }

    /**
     * 递归形式
     *
     * @param n
     * @return
     */
    public static int countWays(int n) {
        if (n <= 0) return 0;
        int[] num = new int[]{1, 5, 10, 25};
        return countWayCore(n, num, num.length - 1);//从最大面值开始判断
    }

    public static int countWayCore(int n, int[] coins, int cur) {
        if (cur == 0) return 1;//出口
        int res = 0;
        //不选couns[cur]
        //要一个
        //要两个....
        for (int i = 0; i * coins[cur] <= n; i++) {//
            int shengyu = n - i * coins[cur];
            res += countWayCore(shengyu, coins, cur - 1);
        }
        return res;
    }

    /**
     * 迭代
     */
    public static int DPcoutWays(int n) {
        int[] num = new int[]{1, 5, 10, 25};
        int len = num.length;
        int[][] dp = new int[len][n + 1];
        for (int i = 0; i <= n; i++) {//行初始化
            dp[0][i] = 1;
            System.out.print(dp[0][i]+"\t");
        }
        System.out.println();
        for (int i = 0; i < len; i++) {//列初始化
            dp[i][0] = 1;
        }
        for (int i = 1; i < len; i++) {//行
            for (int j = 0; j <= n; j++) {//列
                if (j < num[i]) dp[i][j] = 1;
                else {
                    for (int k =0; k <i ; k++) {
                        dp[i][j]+=dp[k][num[k]];
                    }
                }//上一行
                //当我在第三行 4-(3-1)2
                System.out.print(dp[i][j]+"\t");
            }
            System.out.println();
        }
        int ans=0;
        ans=dp[3][n];
        System.out.println(ans);
        return 0;

    }

    int[][] state;

    /*递推解法*/
    public int countWays1(int n) {

        int[] coins = {1, 5, 10, 25};
        int[][] dp = new int[4][n + 1];//前i种面值,组合出面值j
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;//凑出面值0,只有一种可能,第一列初始化为1
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 1;//用1来凑任何面值都只有一种凑法,第一行初始化为1
        }
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 0; k <= j / coins[i]; ++k) {
                    dp[i][j] += dp[i - 1][j - k * coins[i]];
                }
            }
        }
        return dp[3][n];
    }

    /*递推解法*/
    public int countWays2(int n) {

        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = coins[i]; j < n + 1; j++) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }


}
