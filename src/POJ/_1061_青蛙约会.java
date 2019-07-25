package POJ;


import java.util.Scanner;

import static java.lang.Math.abs;

public class _1061_青蛙约会 {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int ansx=cin.nextInt(), ansy=cin.nextInt(),m=cin.nextInt(),
                n=cin.nextInt(),L=cin.nextInt();
        /*
        同余
        x +km同余数y+kn (mod L);
        x+
         */
        int a=m-n;
        int b=L;
        m=ansy-ansx;
        long d;
        try{
            d=LinearEquation(a,b,m);//求解线性方程
            long x0=x;// 可能为负数 次数一定大于0
            long t=b/d;//x的增长倍数 是 b/gcd
            t=abs(t);
            x0=(x0%t+t)%t;//要求第一个大于0的解
            System.out.println(x0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
//解线性方程
    static long x,y;
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
