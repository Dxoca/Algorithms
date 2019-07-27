package HDU;

import java.util.Scanner;

public class _1576_ADivideB {
    public static void main(String[] args)throws Exception {
      Scanner cin =new Scanner(System.in);
      long t=cin.nextLong();
        for (long i = 0; i < t; i++) {
            long n=cin.nextLong();
            long B=cin.nextLong();
            inverseElement(B,9973);
            System.out.println((x*n)%9973);
        }
    }
    static long x,y;

    /**
     *ax=1(mod mo),gcd(a,mo)=1;
     * ax=k1*mo+余数
     * 1=k2*mo+余数;
     * a与mo是素数
     */
    public static long inverseElement(long a, long mo) throws Exception {
        long d = LinearEquation(a, mo, 1);//ax+mo*y=1
        x = (x % mo + mo) % mo;//保证x>0 /x就是逆元 逆元是关于模的倒数
        return d;
    }

    static long LinearEquation(long a, long b,long m)throws Exception{
        long d =ext_gcd(a,b);
        if(m%d!=0) throw new Exception("Impossible");
        long t=m/d;
        x*=t;
        y*=t;
        return d;
    }

    private static long ext_gcd(long a, long b) {
        if(b==0) {
            x=1;
            y=0;
            return a;
        }
        long d =ext_gcd(b,a%b);
        long x1=x;
        x=y;
        y=x1-a/b*y;
        return d;
    }
}
