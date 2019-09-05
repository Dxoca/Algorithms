package PAT.BasicLevel;

import java.util.Scanner;

public class _1016_部分AaddB {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        long a = cin.nextLong(), a1 = cin.nextInt(), b = cin.nextInt(), b1 = cin.nextInt();
        long t1 = a1;
        long t2 = b1;
        while (a != 0) {
            long x = a % 10;
            if (x == t1) {
                a1 *= 10;
                a1 += x;
            }
            a /= 10;
        }
        while (b != 0) {
            long x = b % 10;
            if (x == t2) {
                b1 *= 10;
                b1 += x;
            }
            b /= 10;
        }
        System.out.println(a1 / 10 + b1 / 10);
    }
}
