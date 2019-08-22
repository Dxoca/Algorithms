package cf.EDU71D2;

import java.util.Scanner;

public class B {
    static int n, m;
    static int[][] a, b;
    static int hashb = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        a = new int[n][m];
        b = a;
        int hash = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = cin.nextInt();
                hash += (i + 1) * a[i][j] + (j + 1) * a[i][j];
            }
        }
        dfs(0, 0);

    }

    private static void dfs(int x, int y) {

        if(x==n-2){
            boolean equal=true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(a[i][j]!=b[i][j]) {
                        equal = false;
                        break;
                    }
                }
            }
            if(equal){
                System.out.println("yes");
            }
        }
        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                b[i][j] = 1;
            }
        }
        dfs(x + (y + 1) / m - 2, (y + 1) % n - 2);
        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                b[i][j] = 0;
            }
        }
    }
}
