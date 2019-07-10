package BlueCup.Five_String;

public class _514_MatchKMP {
    public static void main(String[] args) {
        String s = "babababcbabababb";
        String p = "bababb";
        int ans = violence(s, p);
        System.out.println(ans);
    }

    /**
     * 暴力法
     * @param s  源串
     * @param p  子串
     * i    子串 第一次出现的索引位置
     * sc   s的指针 扫描指针
     * j    p的指针 匹配指针
     * i    子串第一次出现的索引
     * 思路：一次一次的 对应比较 失配 就从头开始，
     */
    private static int violence(String s, String p) {
        int i = 0;
        int sc = i;
        int j = 0;
        while (sc <= s.length()) {
            if (s.charAt(sc) == p.charAt(j)) {
                j++;
                sc++;
                if (j == p.length())
                    return i;
            } else {
                i++;
                sc=i;//>sc++; 第一次的位置 和 s的指针同进 扫描指针 以i为起点
                j = 0;
            }
        }
        return -1;
    }

}


