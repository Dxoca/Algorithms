package CometOJ.match.shui;

import java.util.Scanner;

import static java.lang.Math.abs;

public class B {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i]=cin.nextInt();
        }
        int ans=0;
        for (int i = 1; i < n; i++) {
            if(abs(num[i]-num[i-1])<k){
                ans++;
                i++;
            }

        }
        System.out.println(ans);
    }
}
