package cf._580D2;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] rec = new int[2 * n + 1];
        for (int i = 1; i <= 2 * n; i++) {
            rec[i] = i;
        }
        int cur = 0;
        dfs(n, rec, cur);
    }

    private static void dfs(int n, int[] rec, int cur) {
        if (cur < n) {
            for (int i = 1; i <= 2 * n; i++) {

            }
        }

    }
}
