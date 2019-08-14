package cf._579D3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int count = 0;
        long  a[] = new long[n];
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
            if (a[i] < min) min = a[i];
        }

        for (int i = 1; i <= min; i++) {
            int t = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] % i == 0) {
                    t++;
                }
                if (t == n) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
