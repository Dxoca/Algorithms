package cf;

import java.util.Scanner;

import static java.lang.Integer.min;
import static java.lang.Math.max;

public class cityday {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int x = cin.nextInt();
        int y = cin.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            boolean flag=true;
            for (int j = (max(i-x,0)); j < i; j++) {
                if(a[j]<a[i]){
                    flag=false;
                    break;
                }
            }
            if(!flag)continue;
            for (int j = min(i+y,n-1); j >i ; j--) {
                if(a[j]<a[i]){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(i+1);
                return;
            }
        }
    }
}