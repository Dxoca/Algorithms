package LuoGu;

import java.util.Scanner;
//正整数翻转
public class P1307 {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int n,k=0;
        n=cin.nextInt();
        while(n!=0){
            k=k*10+n%10;
            n/=10;

        }
        System.out.println(k);

    }
}
