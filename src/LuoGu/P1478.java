package LuoGu;

import java.util.Scanner;

/**
 * importance：最多可以宅多少个
 * 最暴力的的方法。
 * 2019年6月30日 14:19:49
 * @author Dxoca
 */
public class P1478 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(), s = cin.nextInt(), //果子数，力气
                a = cin.nextInt() + cin.nextInt();//椅子高度+手
        int count = 0;
        int maxn = 1001;
        int[][] tong = new int[maxn][100];// 力气 高度(**相同力气时的 不同高度)
        for (int i = 0; i < n; i++) {//计数排序 用力气做下标
            int high = cin.nextInt();//高度
            int power = cin.nextInt();//力气

            tong[power][0]++;//力气
            tong[power][tong[power][0]] = high;//高度[力气的count]，1>1 ，2>2
        }
        for (int i = 0; i < maxn; i++) {
            while (tong[i][0]-- > 0) {//遍历 每个力气下的所有高度
                if (tong[i][tong[i][0] + 1] <= a && s - i >= 0) {//可以摘
                    s -= i;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}