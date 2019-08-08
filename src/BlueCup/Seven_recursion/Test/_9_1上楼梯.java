package BlueCup.Seven_recursion.Test;


public class _9_1上楼梯 {
    public static void main(String[] args) {
        _9_1上楼梯 o=new _9_1上楼梯();

        System.out.println( o.countWays(36196));
    }
    public int countWays(int n) {
        int dp[]=new int[3+n];
        dp[0]=1;
        dp[1]=2;
        dp[2]=4;
        for (int i = 3; i < n; i++) {
            dp[i]=((dp[i-1]+dp[i-2])%1000000007+dp[i-3])%1000000007;
        }
        return dp[n-1];
    }
}
