package cf.EDU71D2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int b, p, f, h, c;

        for (int i = 0; i < n; i++) {
            b = cin.nextInt();
            p = cin.nextInt();
            f = cin.nextInt();
            h = cin.nextInt();
            c = cin.nextInt();
            int ans = 0;
            while (b / 2 > 0 && p > 0 || b / 2 > 0 && f > 0) {
                if (h > c) {//汉堡贵
                    while (b / 2 > 0 && p > 0) {
                        b -= 2;
                        p--;
                        ans += h;
                    }
                    while (b / 2 > 0 && f > 0) {
                        b -= 2;
                        f--;
                        ans += c;
                    }
                } else {
                    while (b / 2 > 0 && f > 0) {
                        b -= 2;
                        f--;
                        ans += c;
                    }
                    while (b / 2 > 0 && p > 0) {
                        b -= 2;
                        p--;
                        ans += h;
                    }
                }

            }
            System.out.println(ans);
        }
    }
}
