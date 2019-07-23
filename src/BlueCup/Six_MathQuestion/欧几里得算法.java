package BlueCup.Six_MathQuestion;

public class 欧几里得算法 {
    //中国的辗转相除法 求最大公约自公因子
    //4 是 4 8 的 最大公约数

    /**
     * 欧几里得算法，既辗转相除法
     * 求出最大公约数(公因子)
     *
     * @param m
     * @param n
     * @return
     */
    public static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }

}
