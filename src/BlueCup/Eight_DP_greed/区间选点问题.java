package BlueCup.Eight_DP_greed;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class 区间选点问题 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] t = new int[n];
        int[] s = new int[n];
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
        int res = f(jobs);
        System.out.println("ans:"+res);
    }

    private static int f(Job[] jobs) {
        int y = jobs[0].t;
        int cnt = 1;
        System.out.println(y);
        for (int i = 1; i < jobs.length; i++) {
            if (jobs[i].s >y) { //起始小于上次结束
                cnt++;

                y = jobs[i].t;
                System.out.println(y);
            }
        }
        return cnt;
    }

    private static class Job implements Comparable<Job> {
        int s, t;

        Job() {
        }

        /**
         * @param s start
         * @param t target
         */
        public Job(int s, int t) {
            this.s = s;
            this.t = t;
        }

        //先比较后面的
        public int compareTo(Job other) {
            int x = this.t - other.t;
            if (x == 0) {
                return this.s - other.s;
            }
            return x;
        }

    }
}
