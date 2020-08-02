package NowCoder.普及组_模拟1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.lang.Math.max;

public class _NOIP2005校门外的叔 {
    static class MyPair implements Comparable<MyPair> {
        private Integer x;
        private Integer y;

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        public Integer getY() {
            return y;
        }

        MyPair() {

        }

        MyPair(Integer x, Integer y) {
            setX(x);
            setY(y);
        }

        @Override
        public int compareTo(MyPair o) {
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) {
        MyPair[] seg = new MyPair[110];
        Scanner cin = new Scanner(System.in);
        int l = cin.nextInt();
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) seg[i] = new MyPair(cin.nextInt(), cin.nextInt());
        Arrays.sort(seg, new Comparator<MyPair>() {
            @Override
            public int compare(MyPair o1, MyPair o2) {
                return Integer.compare(o1.x, o2.x);
            }
        });
        int start = seg[0].x, end = seg[0].y;
        int sum = 0;
        for (int i = 1; i < n; i++) {//判断交集
            if (seg[i].x > end) {//起点大于终点 无交集
                sum += end - start + 1;
                start = seg[i].x;//更新维护区间
                end = seg[i].y;
            } else {//当前区间和维护 有交集
                //起点一定小于终点，因为已经排序
                end = max(end, seg[i].y);
            }
        }
        sum += end - start + 1;//最后一个区间
        System.out.println(l + 1 - sum);//总长度减去被砍掉的
//        //暴力O(2^6)
//        int[] tree = new int[(int) 1e4 + 1];
//        Scanner cin = new Scanner(System.in);
//        int l = cin.nextInt();
//        int t = cin.nextInt();
//        for (int i = 0; i < t; i++) {
//            int start = cin.nextInt();
//            int end = cin.nextInt();
//            while (start != end + 1)
//                tree[start++] = -1;
//        }
//        int count = 0;
//        for (int i = 0; i <= l; i++)
//            if (tree[i] == 0) count++;
//        System.out.println(count);
    }
}
