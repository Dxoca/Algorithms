package BlueCup.Seven_recursion.Test;

import java.util.Scanner;

public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 1; i < n; i++) {
            a[i][0]+=a[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            a[0][i]+=a[0][i-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                a[i][j] += Math.min(a[i - 1][j], a[i][j - 1]) ;
            }
        }
        System.out.println(a[n - 1][m - 1]);
    }

}
