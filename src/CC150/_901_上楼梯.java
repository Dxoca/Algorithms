package CC150;

public class _901_上楼梯 {
    static int count = 0;
    /**
     * 递归
     * n较小的时候会超时 效率低
     * 倒着写 顺这看
     * O(3^n)
     *
     * @param n
     * @return
     */
    public static int rec(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        return rec(n - 1) + rec(n - 2) + rec(n - 3);
    }

    /**
     * 迭代法 通过数学规律
     * 1 2 4 7 13 24
     * O(n)
     * @param n
     * @return
     */
    public static int inter(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        int x1=1;
        int x2=2;
        int x3=4;
        for (int i = 4; i <= n; i++) {
            int x_1=x1;
             x1=x2;
             x2=x3;
             x3=x_1+x1+x2;//递推公式 n=(n-1)+(n-2)-(n-3)
        }
        return x3;
    }

    public static void main(String[] args) {
//        System.out.println(rec(10));
        System.out.println(inter(100000));
    }
}
