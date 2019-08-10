package BlueCup.Seven_recursion.Test;

import java.util.Scanner;

public class 变态跳台梯 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int ans=JumpStairs(n);
        System.out.println(ans);

    }

    private static int JumpStairs(int n) {
        if (n <=0)
            return 0;
        else if (n == 1)
            return 1;
        else return  2*JumpStairs(n-1);
    }
}
