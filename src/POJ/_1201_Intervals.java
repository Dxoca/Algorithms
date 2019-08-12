package POJ;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class _1201_Intervals {
    static int n;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        Interval[] jobs = new Interval[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            jobs[i] = new Interval(cin.nextInt(), cin.nextInt(), cin.nextInt());
        }
        sort(jobs);
        max = jobs[n - 1].t;//排序过后最大的在最后 t是结束位置
        int[] rec = new int[max + 1];//标记数轴上的点是否已标记
        for (int i = 0; i < n; i++) {
            int s = jobs[i].s;//起点
            int t = jobs[i].t;//终点
            int cnt = sum(rec, s, t);//找到这个区间已经选段的数量 sum[t]~sum[s-1]
            jobs[i].c -= cnt;//需要点的数量
            while ((jobs[i].c > 0)) {
                if (rec[t] == 0) {//从终点开始选点
                    rec[t] = 1;
                    jobs[i].c--;//个数减少
                    t--;//终点左移
                } else
                    t--;
            }

        }
        System.out.println(sum(rec,0,max));
    }

    private static int sum(int[] rec, int s, int t) {
        int sum = 0;
        for (int i = s; i <= t; i++) {
            sum += rec[i];
        }
        return sum;
    }

    public static class Interval implements Comparable<Interval> {
        int s, t, c;

        public Interval(int s, int t, int c) {
            this.s = s;
            this.t = t;
            this.c = c;
        }

        @Override
        public int compareTo(Interval o) {
            int x = this.s - o.s;
            if (x == 0) {
                return this.t - o.t;
            }
            return x;
        }
    }
}
