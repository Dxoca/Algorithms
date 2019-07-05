package LuoGu;
//记忆搜索 Function
import java.util.Scanner;

public class P1464 {
    static long f[][][] = new long[30][30][30];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long a, b, c;
        while (true) {
            a = cin.nextLong();
            b = cin.nextLong();
            c = cin.nextLong();
            if (a == b && b == c && c == -1) {
                break;
            }
            long ans = dfs(a, b, c);
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + ans);
        }
    }

    public static long dfs(long a, long b, long c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;//如果有小于等于0的，返回1
        if (a > 20 || b > 20 || c > 20) return dfs(20, 20, 20);//如果有大于20的，返回w(20,20,20)
        if (a < b && b < c) {
            if (f[(int) a][(int)b][(int)c] == 0) f[(int)a][(int)b][(int)c] = dfs(a, b, c - 1) + dfs(a, b - 1, c - 1) - dfs(a, b - 1, c);
        }//如果a<b且b<c，没被计算过，就进行计算，保留结果
        else if (f[(int)a][(int)b][(int)c] == 0)
            f[(int)a][(int)b][(int)c] = dfs(a - 1, b, c) + dfs(a - 1, b - 1, c) + dfs(a - 1, b, c - 1) - dfs(a - 1, b - 1, c - 1);//如果前面都不对，没被计算过，就进行计算，保留结果
        return f[(int)a][(int)b][(int)c];//最后返回值

    }
}
