package cf._577D2;

import java.util.Scanner;

public class BZeroArray {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int a = cin.nextInt();
            sum += a;
            if (a > m) m = a;
        }
        if (sum % 2 == 0 && sum - m >= m) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }
    }
}
