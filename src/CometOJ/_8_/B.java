package CometOJ._8_;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] a = new int[n];
        long sum = 0;
        long num = 0;
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
            sum += a[i];
            num += a[i] * a[i];
        }
        for (int i = 0; i < n; i++) {
            long ans = n * a[i] * a[i] - 2 * a[i] * sum + num;
            System.out.print(ans + " ");
        }
    }

}

