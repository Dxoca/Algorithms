package CometOJ.match.shui;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        long a=cin.nextLong(),b=cin.nextLong();
        long ans=solve(solve(solve(a)))%b;
        System.out.println(ans);
    }

    private static long solve(long a) {
        long ans=1;
        for (long i = 1; i <= a; i++) {
            ans*=i;
        }
        return ans;
    }

}
