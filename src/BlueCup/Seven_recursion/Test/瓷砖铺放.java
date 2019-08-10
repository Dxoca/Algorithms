package BlueCup.Seven_recursion.Test;

import java.util.Scanner;

public class 瓷砖铺放 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int ans = dfs(n);
        System.out.println(ans);
    }
    private static int dfs(int n) {
       if(n==1)
           return 1;
       if(n==2)
           return 2;
        return dfs(n-1)+dfs(n-2);
    }
}
