package cf._578D2;

import java.util.Arrays;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.Global.print;

public class D {
    static char[][] a;
    static int n;
    static int eraser;
    static int max = -1;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        a = new char[n][n];
        eraser = cin.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = cin.next().toCharArray();
        }

        int start = 0;
        //行 row 列col
        f(eraser, 0, 0);//擦子右上角 和边缘行
        System.out.println(max);

    }

    public static void print(char[][] a) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static void f(int e, int x, int y) {
        if (x == n) {
            System.exit(0);
        }
        char[][] b = a;
        int t1 = x + (y + 1) / n;
        int t2 = (y + 1) % n;
        if (x + e <= n && y + e <= n) {
            for (int i = x; i < y + e; i++) {
                for (int j = y; j < x + e; j++) {
                    b[i][j] = 'W';
                }
            }

            int tamp = check(b);
            if (tamp > max) {
                max = tamp;
            }
//            print(b);
//            System.out.println("+++++");
//            System.out.println();
//            System.out.println(t1 + "" + t2);
        }
        f(e, t1, t2);
    }

    private static int check(char[][] a) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'W') {//行
                boolean flag = true;
                for (int j = 1; j < n; j++) {
                    if (a[i][j] != 'W') {
                        flag = false;
                    }
                }
                if (flag) count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[0][i] == 'W') {//列
                boolean flag = true;
                for (int j = 1; j < n; j++) {
                    if (a[j][i] != 'W') {
                        flag = false;
                    }
                }
                if (flag) count++;
            }
        }
        return count;
    }
}
