package CometOJ._12_;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        for (int i = 0; i < T; i++) {
            int n = cin.nextInt();
            int m = cin.nextInt();
            int r = cin.nextInt();
            int c = cin.nextInt();
            int arr1[][] = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr1[j][k] = cin.nextInt();
                }

            }
            int arr2[][] = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    arr1[j][k] = cin.nextInt();
                }

            }
        }

    }
}
