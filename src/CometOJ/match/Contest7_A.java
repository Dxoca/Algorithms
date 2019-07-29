package CometOJ.match;

import java.util.Scanner;

public class Contest7_A {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        long t=cin.nextLong();
        for (long i = 0; i < t; i++) {
            long l=cin.nextLong();
            long r=cin.nextLong();
            solve(l,r);
        }
    }

    /**
     * 最小公倍数 最大  最小
     * 最大公约数 最大 最小
     * @param l
     * @param r
     */
    private static void solve(long l, long r) {
//最小公倍数 =量整数/最大公约数 最小

        //最大公约数 最大 最小：
        long ans2= gcd(l,r);//最小 公约数
        long ans1=l>r?l:r;//最大


        long anss1=l*r/ans2;//初一最大的
        long anss2=l*r/ans1;
        System.out.print(anss1+" ");//公倍数 最大
        System.out.print(anss2+" ");//最小
        System.out.print(ans1+" ");//公约数 最大
        System.out.println(ans2);//公约数 最小

    }


    private static long gcd(long   a, long b) {
        return b==0?a:gcd(b,a%b);
    }

}
