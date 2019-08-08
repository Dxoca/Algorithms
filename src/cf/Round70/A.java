package cf.Round70;

import java.util.Scanner;

import static java.lang.Math.pow;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int i = 0; i < t; i++) {
            for (int i2 = 0; i2 < 100; i2++) {
                int x = Integer.valueOf(cin.next(), 2);
                int y = Integer.valueOf(cin.next(), 2);
                String min = "1111111111111";
                int ans = 0;
                for (int k = 0; k <= 10; k++) {
                    int tamp = x + y * (int) pow(2, k);
                    StringBuilder s1 = new StringBuilder(Integer.toBinaryString(tamp)).reverse();
//                    System.out.println(tamp + ":" + s1);
                    String ting = Integer.valueOf(s1.toString(), 2).toString();
                    if (min.compareTo(ting) > 0) {
                        ans = k;
                        min = ting;
                    }
                }
                System.out.println(ans);
            }
        }

    }
}
