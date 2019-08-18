package cf._580D2;

import java.util.Scanner;
//1274968094
import static java.lang.Math.abs;
import static java.util.Arrays.sort;

public class B {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] fu = new int[n];
        int f = 0;
        long ans = 0, fans = 0;
        int zeroCount = 0;
        for (int i = 0; i < n; i++) {
            int x = cin.nextInt();
            if (x < 0) {
                fu[f++] = x;
                fans += abs(x) - 1;
            } else {
                if (x == 0) {
                    zeroCount++;
                }
                if (x > 1) {
                    ans += x - 1;
                }
            }
        }
        if (f % 2 == 0) {
            System.out.println(ans + fans + zeroCount);
        } else {
            int[] rec = new int[f];
            for (int i = 0; i < f; i++) {
                rec[i] = fu[i];
            }
            sort(rec);//- 16 -15
            for (int i = 0; i < f - 1; i++) {
                ans += abs(rec[i]) - 1;
            }
            if (zeroCount != 0) {//有0
                ans += abs(rec[f - 1]) - 1;
                System.out.println(ans + zeroCount );//其中一个0是 转-1,
            } else {//没0 最小-x 变1
                ans += abs(rec[f - 1]) + 1;
                System.out.println(ans);
            }
        }

    }
}
