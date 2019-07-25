package BlueCup.Six_MathQuestion;

public class 欧几里得算法 {
    //中国的辗转相除法 求最大公约自公因子
    //4 是 4 8 的 最大公约数

    public static long x, y;//全局变量存储 xy的推算

    public static void main(String[] args) throws Exception {
        //ax+by=ans
        long ans;
        try {
            ans = LinearEquation(2, 3, 1);
            System.out.println(x + "+" + y + "=" + ans);//2x+3y=1 >x=-1 y=1
            ans = LinearEquation(2, 7, 1);
            System.out.println(x + "+" + y + "=" + ans);//2x+7y=1 >x=-3 y=1
            ans = LinearEquation(12, 42, 6);
            System.out.println(x + "+" + y + "=" + ans);//12x+42y=6 >x=-3 y=1
            ans = LinearEquation(12, 42, 5);
            System.out.println(x + "+" + y + "=" + ans);//无解
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 欧几里得算法，既辗转相除法
     * 求出最大公约数(公因子)
     */
    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 最小公倍数 lowest common multiple*/
    public static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    /**
     * 扩展欧几里得算法
     * 调用完成后的 xy是ax+by=gcd(a,b)的解*/
    public static long ext_gcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long res = ext_gcd(b, a % b);
        //到最后一层开始递推x，y
        //已经最下一次更新了 x0 y0 在b==0时候就初始化了
        long x1 = x;//备份
        x = y;//更新x
        y = x1 - a / b * y;//更新y
//        System.out.println(x + " " + y);测试变化
        return res;
    }

    /**
     * 线性方程
     * ax+by=m 当m是gcd(a,b)的倍数时有解
     * 等价于 ax = m mod b*/
    public static long LinearEquation(long a, long b, long m) throws Exception {
        long d = ext_gcd(a, b);
        if (m % d != 0) throw new Exception("无解");//m不是d的倍数无解
        long t = m / d;//倍数 m是d的几倍
        x *= t;
        y *= t;
        return d;
    }

}
