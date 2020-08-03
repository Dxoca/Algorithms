package NowCoder.普及组_模拟1;

import java.util.Arrays;

import java.util.Scanner;

import static java.lang.Math.max;

public class _NOIP2005校门外的树 {
    static class MyPair<K, V> implements Comparable<MyPair> {
        Integer x;
        Integer y;

        public void setX(Integer x) {
            this.x = x;
        }

        public void setY(Integer y) {
            this.y = y;
        }

        MyPair() {
        }

        MyPair(Integer x, Integer y) {
            setX(x);
            setY(y);
        }

        /**
         * 调用Comparable接口 实现compareTo方法 便于直接sort
         * 自定义类sort规则
         *
         * @param o
         * @return
         */
        @Override
        public int compareTo(MyPair o) {
            return this.x - o.x == 0 ? this.y - o.y : this.x - o.x;

        }
    }

    public static void main(String[] args) {
        MyPair[] seg = new MyPair[110];
        Scanner cin = new Scanner(System.in);
        int l = cin.nextInt();
        int n = cin.nextInt();
        int a, b;
        for (int i = 0; i < n; i++) {
            a = cin.nextInt();
            b = cin.nextInt();
            seg[i] = new MyPair(a, b);
        }
//        Arrays.sort(seg,0,n);//使用类的比较器
        Arrays.sort(seg, 0, n, (o1, o2) -> {//自建比较器 lambda
            return o1.x - o2.x == 0 ? o1.y - o2.y : o1.x - o2.x;
        });
        //比较繁杂的比较
//        Arrays.sort(seg, 0, n, (o1, o2) -> {
//            if (o1.x.compareTo(o2.x) == 0) {
//                if (o1.y == o2.y) return 0;
//                else if (o1.y > o2.y) return 1;
//                else return -1;
//            } else if (o1.x.compareTo(o2.x) > 0) return 1;
//            else if (o1.x.compareTo(o2.x) < 0) return -1;
//            else return 0;
//        });
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

    }
}
