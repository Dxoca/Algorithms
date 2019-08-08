package BlueCup.Seven_recursion.Test;

import java.util.Scanner;

public class 取球游戏 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] ans = new int[10010];
        int[] b = new int[]{1, 3, 7, 8};
        for (int i = 0; i <10000; i++) {
            if (ans[i] == 0)
                for (int j = 0; j < b.length; j++) {
                    ans[i+b[j]] =1;
                }
        }
        while(n-->0){
            System.out.println(ans[cin.nextInt()]);
        }
    }
}
