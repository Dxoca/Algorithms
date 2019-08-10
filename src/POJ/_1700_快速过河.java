package POJ;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.min;

public class _1700_快速过河 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = sc.nextInt();
            }
            //排序
            Arrays.sort(speed);
            f(n, speed);
        }
    }

    private static void f(int n, int[] speed) {
        int left = n;//最慢的
        int ans = 0;
        while (left > 0) {
            if (left == 1) {
                ans += speed[0];
                break;
            } else if (left == 2) {
                ans +=  speed[1];//两人就是 最慢的人
                break;
            } else if (left == 3) {
                ans += speed[0] + speed[1] + speed[2];
                break;
            } else {
                //第一种 最快的带最慢的 1，2-1； 1，3-1 ；1，4
                int s1 = 2 * speed[0] + speed[left - 1] + speed[left - 2];
                //第二种 顾眼前 相对最快都过去 回来一个 最快的
                //12 出发 返回1 最后两个出发 返回2
                //1 ，2-1；3，4——2 ； 1 2
                int s2 = speed[1] + speed[0] + speed[left - 1] + speed[1];
                ans += min(s1, s2);
                left -= 2;//left代表剩余人数
            }
        }
        System.out.println(ans);
    }
}
