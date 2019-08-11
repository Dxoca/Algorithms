package BlueCup.Eight_DP_greed;

import sun.util.resources.sl.CalendarData_sl;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class 区间调度问题 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] s = new int[n];
        int[] t = new int[n];
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            s[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = cin.nextInt();
        }
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(s[i], t[i]);
        }
        sort(jobs);
        int res = f(n, jobs);
        System.out.println("ans:"+res);

    }

    private static int f(int n, Job[] jobs) {
        int cnt = 1;
        int y = jobs[0].t;
        System.out.println(y);
        for (int i = 1; i < n; i++) {
            if (jobs[i].s > y) {//起始大于上次结束
                cnt++;
                y = jobs[i].t;//更新为这次的 起始的 结束时间 做下次比较
                System.out.println(y);
            }
        }
        return cnt;
    }

    /**
     * 必须 实现排序（comparable）规则
     */
    private static class Job implements Comparable<Job> {
        int s, t;

        public Job(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Job other) {
            int x = this.t - other.t;
            if (x == 0) {//结束时间相同 对 起始时间排序
                return this.s - other.s;
            } else {
                return x;
            }
        }
    }
}
