package BlueCup.Eight_DP_greed;

import java.util.Scanner;

import static java.lang.Math.min;

public class 贪心硬币问题 {
    static int[] count;

    static int[] coin = {1, 5, 10, 50, 100, 500};

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        count = new int[6];
        for (int i = 0; i < 6; i++) {
            count[i] = cin.nextInt();
        }
        int value = cin.nextInt();
        int ans = f(value, 5);
        System.out.println(ans);
    }

    private static int f(int value, int cur) {
        if (value <= 0) return 0;//提前凑够了
        if (cur == 0) return value;//面值是1

        int maxGeshu = value / coin[cur];//需要
        int t = min(count[cur], maxGeshu);// 我有的和我需要的 选出最小的 去换

        return t + f(value - t * coin[cur], cur - 1);
    }

}
