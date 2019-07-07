package LuoGu;

import java.util.Scanner;

public class P_1014_new {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int cs = 0, tot = 0;//cs记录层数，tot记录到这一层总共有多少数
        while (tot < n) {
            cs++;//行数
            tot += cs;
        }
        if (cs % 2 == 1)//当是奇数行时
            //个数-层数+1 / 行数-（个数-目标数字）
            System.out.println((tot - n + 1) + "/" + (cs - (tot - n)));
        else
            System.out.println((cs - (tot - n)) + "/" + (tot - n + 1));
    }

}
