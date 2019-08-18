package BlueCup.Eight_DP_greed;

import static java.lang.Math.log;
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
                ship++;
            }
        }
//        System.out.println(ship);
        int l = 5000035;
        m1(l);
        System.out.println();
        m2(l);
    }

    public static void m1(int N) {
        //由素数定理：
        //从不大于n的自然数随机选一个，它是素数的概率大约是1/ln n
        //N是第N 个素数
        //已知在整数x内大概有 x* 1/ln (x)个素数
        //现在我们要逆推：要想求第N个素数，我们的整数范围是什么
        //n就是整数范围
        int n = 2;
        while (n / log(n) <= N) {
            n++;
        }
        //开辟数组，下标自然数，数值mark
        //筛选法 标记素数
        int arr[] = new int[n];
        int x = 2;
        while (x < n) {
            //标记过了 继续下一个
            if (arr[x] != 0) {
                x++;
                continue;
            }
            int k = 2;
            //对于每个x 我们从2倍开始，对x的k倍 都mark -1
            while (x * k < n) {
                arr[x * k] = -1;
                k++;
            }
            x++;
        }
        //筛完之后，这个很长的数组里面非素数下标对应的值都是-1
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            //是素数 计数+1
            if (arr[i] == 0) {
                sum++;
            }
            if (sum == N) {//素数的计数
                System.out.println(i); //索引是数值
                return;
            }
        }
    }

    public static void m2(int a) {
        int cnt = 0;
        for (int i = 2; ; i++) {
            boolean yes = true;
            for (int j = 2; j * j <= i; j++)
                if (i % j == 0) {
                    yes = false;
                    break;
                }
            if (yes && ++cnt == a) {
                System.out.println(i);
                return;
            }
        }
    }
}
