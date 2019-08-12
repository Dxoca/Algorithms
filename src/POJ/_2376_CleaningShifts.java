package POJ;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class _2376_CleaningShifts {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int T = cin.nextInt();
        Cow[] cow = new Cow[N];
        for (int i = 0; i < N; i++) {
            cow[i] = new Cow(cin.nextInt(), cin.nextInt());
        }
        sort(cow);
        int start = 1;//要覆盖的目标点，
        int end = 1;//是覆盖该点的所有区间 右端点最右
        int ans = 1;
        for (int i = 0; i < N; i++) {
            int s = cow[i].s;
            int t = cow[i].t;

            if (i == 0 && s > 1) break;//因为从1开始到T

            if (s <= start) {//当前区间可能覆盖start
                end = Math.max(t, end);//包括起点的最长线段的终点
            } else {//下一个区间
                ans++;
                start = end + 1;//更新起点，设置新的覆盖目标
                if (s <= start) {
                    end = Math.max(t, end);
                } else {
                    break;
                }
            }

            if (end >= T) {//当前end超过了终点
                break;
            }
        }
        if (end < T)
            System.out.println("-1");
        else
            System.out.println(ans);

    }

    //按照区间起点排序
    private static class Cow implements Comparable<Cow> {
        int s, t;

        Cow(int s, int t) {
            this.s = s;
            this.t = t;
        }

        @Override
        public int compareTo(Cow o) {
            int x = s - o.s;//起点
            if (x == 0) {
                return t - o.t;
            }
            return x;
        }
    }
}
