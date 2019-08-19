package BlueCup.Eight_DP_greed;



import java.util.Arrays;
import java.util.Scanner;

public class 斐波那契数列 {
    static int[] rec;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        rec = new int[n + 1];
        f(n);
        System.out.println(Arrays.toString(rec));
        System.out.println(rec[n]);
    }

    private static int f(int n) {
        if (n == 1) return rec[n]=n;
        if (n == 2) return rec[n]=n;
        if(rec[n]!=0) return rec[n];
        rec[n] = f(n - 1) + f(n - 2);
        return rec[n];
    }
}
