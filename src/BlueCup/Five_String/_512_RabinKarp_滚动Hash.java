package BlueCup.Five_String;

import static java.util.Objects.hash;

public class _512_RabinKarp_滚动Hash {
    public static void main(String[] args) {
        String s = "ABABAB";
        String p = "BAB";
        match(p, s);

    }

    /**
     * 初始RabinKarp
     * 算法效率 作用不大 等同于 朴素匹配
     *
     * @param p 模式
     * @param s 源串
     *          hash(p)=o(n)
     *          hash(s)=o(m*n);
     *          hash-> 滚动hash=O(m+n)
     */
    private static void match(String p, String s) {
        long hash_p = hash(p);//o(n)
//        int p_len = p.length();
//        for (int i = 0; i + p_len <= s.length(); i++) {//o(m*n)
//            long hash_i = hash(s.substring(i, i + p_len));// 子串[i,i+p_len)
//            if (hash_p == hash_i) {
//                System.out.println("Match:" + i);
//            }
//        }
        //o(m + n)
        long[] hashOfS = hash(s, p.length());
        match(hash_p, hashOfS);
    }

    /**
     * 滚动hash
     *
     * @param hash_p 模式串
     * @param hash_s s中 的每个子串的hash数组
     */
    private static void match(long hash_p, long[] hash_s) {
        for (int i = 0; i < hash_s.length; i++) {
            if (hash_s[i] == hash_p)
                System.out.println("Math:" + i);
        }
    }

    final static long seed = 31;

    /**
     * @param str
     * @return ∑c(str[i])*pow(seed,2 1 0) 》》进制转换
     */
    static long hash(String str) {
        long hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = seed * hash + str.charAt(i);
        }
        return hash % Long.MAX_VALUE;
    }

    /**
     * 滚动hash
     * 用滚动方法 求出s中长度为n的每个子串的hash，组成一个数组
     * n 子串的长度
     * 注意理解 long  v
     *
     * @param s
     * @param n
     * @return
     */
    static long[] hash(final String s, final int n) {
        long[] res = new long[s.length() - n + 1];//先得出的是最后一次的索引位置 但是数组长度为索引+1
        //前  n个字符的 hash
        res[0] = hash(s.substring(0, n));
        System.out.println(res[0]);
        for (int i = n; i < s.length(); i++) {//n为 子串长度  的数值 所以的大初始索引是 新串的 头
            char newChar = s.charAt(i);
            char oldChar = s.charAt(i - n);//第一次 n-n=0
            long v = (res[i - n] * seed + newChar - ex2(seed, n) * oldChar) % Long.MAX_VALUE;//(31^2 32^1 31^0)31 +newC*31^0 -oldC*31^3
            res[i - n + 1] = v;
            System.out.println(v);
        }
        return res;
    }

    //long 幂
    public static long ex2(long n, long m) {
        if (n == 0) return 1;
        long pingFangShu = n; //n 的 1 次方
        long result = 1;
        while (m != 0) {
            //遇1累乘现在的幂
            if ((m & 1) == 1)
                result *= pingFangShu;
            //每移位一次，幂累乘方一次
            pingFangShu = pingFangShu * pingFangShu;
            //右移一位
            m >>= 1;
        }
        return result;
    }

}


