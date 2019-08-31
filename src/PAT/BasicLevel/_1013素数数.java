package PAT.BasicLevel;

import java.util.Scanner;

import static java.lang.Math.log;

public class _1013素数数 {
    static boolean[] prime;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt(), n = cin.nextInt();
        getPrime(n);
        int i = 2;
        int cnt = 0;
        int sum=0;
        while (true) {
            if (cnt > n) break;
            if (prime[i]) {
                cnt++;
                if (cnt >= m && cnt <= n) {
                    sum++;
                    if (cnt == n) {//是最后一个素数 没有空格
                        System.out.print(i);
                    } else if (sum % 10 == 0) {//每10个 换行
                        System.out.print(i + "\n");
                    } else {
                        System.out.print(i + " ");
                    }
                }
            }
            i++;
        }

    }

    private static void getPrime(int n) {
        int range = 2;
        while (range / log(range) <= n) {//求出最大素数范围 素数定理
            range++;
        }
        prime = new boolean[range];
        for (int i = 2; i < range; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                prime[i] = true;
        }
    }
}
