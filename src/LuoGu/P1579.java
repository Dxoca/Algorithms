package LuoGu;

import java.util.Scanner;

/**
 * P1579 哥德巴赫猜想（升级版）
 */
public class P1579 {
    public static void main(String[] args) {
        int[] x = new int[20001];
        int i=0;
        for (int ans = 2; ans <=20000 ; ans++) {
           if(isPrimeNormal(ans)){
               x[i++] = ans;
//               System.out.println(ans);
           }
        }
        int end =i;//数组结束 也就是 数字的个数
        //
        Scanner  cin =new Scanner(System.in);
        int k=cin.nextInt();
        seed(x,k,end);

    }

    /**
     *
     * @param x mark好的数组
     * @param k 是需要求和的奇数
     * @param end
     */
    private static void seed(int[] x, int k,int end) {
//        System.out.println(end);
        boolean flag=true;
        for (int i = 0; i < end; i++) {
            for (int j = 0; j < end; j++) {
                for (int z = 0; z < end; z++) {
                    if(x[i]+x[j]+x[z]==k){
                        System.out.println(x[i]+" "+x[j]+" "+x[z]);
                        return ;
                    }

                }

            }

        }
    }

    /** 求素数
     * 判断是否为素数/质数的常规方法
     * 判断n是否为素数，根据定义直接判断从2到n-1是否存在n的约数即可
     * @param num 判断的目标数
     * @return
     */
    public static boolean isPrimeNormal(int num) {
        for(int i=2; i<=Math.sqrt(num); i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
