package NowCoder.普及组_模拟1;

import java.util.Arrays;

import java.util.Scanner;

import static java.lang.Math.abs;

public class _NOIP2004花生采集 {
    /**
     * 坐标对象
     */
    static class Point {
        int x, y;
        int k;

        Point() {
        }

        /**
         * @param x 横坐标
         * @param y 纵坐标
         * @param k 坐标值
         */
        Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }

        @Override
        public String toString() {
            return "[" + k + "(" + x + "," + y + ")]";
        }
    }

    /**
     * O(nLogN)
     * 对点降序排序 然后模拟即可
     * @param args
     */
    public static void main(String[] args) {
        int m, n, step;
        Scanner cin = new Scanner(System.in);
        m = cin.nextInt();
        n = cin.nextInt();
        step = cin.nextInt();
        Point[] p = new Point[(m + 1) * (n + 1)];
        int cur = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //注意坐标 从1开始！
                p[cur++] = new Point(i + 1, j + 1, cin.nextInt());//存入坐标和内容
            }
        }
        Arrays.sort(p, 0, m * n, (o1, o2) -> {
            return -(o1.k - o2.k);//比较 花生数目的大小 //降序排序
        });
        //test
        for (int i = 0; i <m*n; i++) {
            System.out.println(p[i].toString());
        }

        int maxCur = 0;//最大值索引
        Point t = p[maxCur++];//第一个最大值 1
        if (step < t.x * 2 + 1) {//采摘不到第一步就走不了 小于 来回 + 采摘 的时间
            System.out.println(0);
        } else {//可以采集到花生
            int res = t.k;//记录下来
            step -= t.x + 1;//走过去的时间+采摘的时间

            while (maxCur < m * n) {//迭代
                Point r = p[maxCur];//下一个花生
//                System.out.println(r.toString());
                if (r.k == 0) break;//没有可以摘取的了 当前最大值0
                int d = abs(r.x - t.x) + abs(r.y - t.y);//曼哈顿距离 t是当前花生 r是要去的下一个花生
                if (step < d + 1 + r.x) break;//当前可用时间不足以采摘下个花生然后回去 r.x是回去马路的距离
                res += r.k;//可以的话 花生数记录
                step -= d + 1;//可用时间缩小
                maxCur++; //移动下一个最大花生数
                t = r;
            }
            System.out.println(res);
        }

    }
}
