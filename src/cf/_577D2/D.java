package cf._577D2;

import java.util.Scanner;

import static java.lang.Math.abs;

public class D {
    static int b;
    static int[] anq;
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int k = cin.nextInt();
        b = cin.nextInt();
        int step = 0;
        int a = 0;
        int p[] = new int[m + 1];
        for (int i = 0; i < k; i++) {
            int t1 = cin.nextInt();
            p[i] = cin.nextInt();

        }
        anq = new int[b];
        for (int i = 0; i < b; i++) {
            anq[i] = cin.nextInt();
        }
        for (int i = 0; i < k; i++) {
            step += p[i] + getmin(p[i]);

        }
        System.out.println(step);
    }

    private static int getmin(int i) {
        int min=999999;
        for (int j = 0; j <b; j++) {
            int tamp=abs(anq[j]-i);
            if(min>tamp){
                min=tamp;
            }

        }
        return min;
    }
}
