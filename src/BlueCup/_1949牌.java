package BlueCup;

import java.util.HashSet;
import java.util.Set;

public class _1949牌 {
    public static void main(String[] args) {
        int[] num = {1, 9, 4, 9};
        solve(num, 0);
        System.out.println(res);
    }

    static Set<Integer> res = new HashSet<>();//去重

    //交换法 全排列
    private static void solve(int[] num, int k) {
        if (k == num.length) {//完成k个
            check(num);

        }
        for (int i = k; i < num.length; i++) {
            swap(num, i, k);
            solve(num, k + 1);
            swap(num, i, k);
        }
    }

    private static void check(int[] num) {//素数判断
        int ans = num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];
        for (int i = 2; i * i <= ans; i++) {
            if (ans % i == 0) {
                return;
            }
        }
        res.add(ans);//是素数
        return;
    }

    private static void swap(int[] num, int i, int k) {
        int tmp = num[i];
        num[i] = num[k];
        num[k] = tmp;
    }
}
