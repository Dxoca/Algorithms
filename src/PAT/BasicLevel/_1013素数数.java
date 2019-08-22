package PAT.BasicLevel;

import java.util.Scanner;

public class _1013素数数 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m = cin.nextInt(), n = cin.nextInt();
        int cnt = 0;
        for (int i = m; i <= n; i++) {
            boolean flag = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
                if (cnt % 10 != 0) {
                    System.out.print(i+" ");
                }else
                    System.out.print(i+"\n");
            }
        }
    }
}
