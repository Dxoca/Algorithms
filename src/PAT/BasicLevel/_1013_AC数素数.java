package PAT.BasicLevel;

import java.util.Scanner;

public class _1013_AC数素数 {
    static int cnt = 0;
    static int flag = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt(), n = cin.nextInt();
        for (int i = 2; cnt <= n; i++) {
            getPrime(i, m, n);
        }
    }

    private static boolean getPrime(int i, int m, int n) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        cnt++;
        if (cnt >= m && cnt <= n) {//在区间内 不加判n 会多输出一个
            flag++;
            if (flag % 10 == 0) {//十个换行
                System.out.print(i + "\n");
            } else if (cnt == n) {//最后一个特判断 盘 cnt
                System.out.print(i);
            } else {//正常情况
                System.out.print(i + " ");
            }

        }
        return true;
    }
    //2 3 4 5 6
}
