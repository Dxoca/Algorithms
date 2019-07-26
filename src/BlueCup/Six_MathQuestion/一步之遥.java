package BlueCup.Six_MathQuestion;


public class 一步之遥 {
    public static void main(String[] args) {
        //97*x-127*y=1;
        long F=97;
        long B=-127;
        violence(F,B);
        try {
            LinearEquation(F,B,1);
            System.out.println(x+" "+y);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }



    private static void LinearEquation(long a, long b, long m)throws Exception {
        long d=ext_gcd(a,b);
        if(m%d!=0)throw new Exception("无解");
        long t=m/d;
        x*=t;
        y*=t;
    }
    static long x,y;
    private static long ext_gcd(long a, long b) {
        if(b==0){
            x=1;
            y=0;
            return a;
        }
        long res=ext_gcd(b,a%b);
        long x0=x;
        x=y;
        y=x0-a/b*y;
        return res;
    }

    private static void violence(long f, long b) {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                if(i*f+j*b==1){
                    System.out.println(i+" "+j);
                    return;
                }
            }
        }
    }

}
