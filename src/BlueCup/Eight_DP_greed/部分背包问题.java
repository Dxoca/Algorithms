package BlueCup.Eight_DP_greed;

import java.util.Scanner;

import static java.util.Arrays.sort;

public class 部分背包问题 {
    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
        double C = 10;//总重量
        int[] w = {1, 2, 3, 4, 5};
        int[] v = {3, 4, 3, 1, 4};
        Obj[] obj = new Obj[5];
        for (int i = 0; i < 5; i++) {
            obj[i] = new Obj(w[i], v[i]);
        }
        sort(obj);//按照（价值）排序（升序）
        f(C, obj);
    }

    private static void f(double c, Obj[] obj) {
        double maxValue = 0;
        for (int i = obj.length - 1; i >= 0; i--) {//逆序遍历
            if (obj[i].w <= c) {//重量够 最大价值
                c -= obj[i].w;
                maxValue += obj[i].v;
            } else { //剩下的c不够最大价值 要且 （c/w）是需求/总量
                maxValue += (c / obj[i].w) * obj[i].v;
                break;
            }
        }
        System.out.println(maxValue);
    }

    public static class Obj implements Comparable<Obj> {
        double w;
        double v;

        public Obj(double w, double v) {
            this.w = w;
            this.v = v;
        }

        public double getPrice() {//求价值
            return v / (double)w;
        }

        @Override
        public int compareTo(Obj o) {
            if (this.getPrice() < o.getPrice()) {
                return -1;
            } else if (this.getPrice() > o.getPrice()) {
                return 1;
            } else
                return 0;
        }
//DeBUG
        @Override
        public String toString() {
            return "Obj{" +
                    "w=" + w +
                    ", v=" + v +
                    ",Price"+getPrice()+
                    '}';
        }
    }
}
