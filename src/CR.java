import java.util.Scanner;

import static java.lang.Math.min;
import static java.util.Arrays.sort;

public class CR {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t = cin.nextInt();
        for (int i = 0; i < t; i++) {
            int n = cin.nextInt();
            int[] speed = new int[n];
            for (int j = 0; j < n; j++) {
                speed[j] = cin.nextInt();
            }
            sort(speed);
            f(speed);
        }
    }

    private static void f(int[] speed) {
        int left = speed.length;
        int ans = 0;
        while (left > 0) {
            if (left == 1) {
                ans += speed[0];
                break;
            } else if (left == 2) {
                ans += speed[1];
                break;
            } else if (left == 3) {
                ans += speed[0] + speed[1] + speed[2];//三个人 每个人都必须划一次
                break;
            } else {
                int s1 = 2 * speed[0] + speed[left - 1] + speed[left - 2];
                int s2 = speed[1] + speed[0] + speed[left - 1] + speed[1];
                ans+=min(s1,s2);
                left-=2;
            }
        }
        System.out.println(ans);

    }
}
