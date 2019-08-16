package BlueCup.Eight_DP_greed;

import static java.util.Arrays.sort;

/**
 * 乘船问题
 * <p>
 * 有n个人，第i个人重量为wi。每艘船的最大载重量均为C，且最多只能乘两个人。
 * 用最少的船装载所有人。
 * <p>
 * 动态规划
 */
public class 乘船问题 {
    public static void main(String[] args) {
        int[] w = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = w.length;
        int c = 10;
        int nperson = n;
        int ship = 0;
        int p1 = 0, p2 = n - 1;
        sort(w);
        while (nperson >= 0) {
            if (w[p1] + w[p2] < c) {
                p2--;
                nperson--;
                ship++;
            } else {
                p1++;
                p2--;
                nperson -= 2;
                ship ++;
            }
        }
        System.out.println(ship);
    }
}
