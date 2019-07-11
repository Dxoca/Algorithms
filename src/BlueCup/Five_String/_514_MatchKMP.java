package BlueCup.Five_String;

public class _514_MatchKMP {
    public static void main(String[] args) {
        String s = "sbabababcbabababb";
        String p = "baba";
        int ans = violence(s, p);
        System.out.println(ans);
        ans =indexOf(s,p);
        System.out.println(ans);
    }

    /**
     * 1.暴力法 o(m*n)
     * 2.next数组o(m+n)
     * 3.求next数组
     *
     * @param s 源串 m个元素
     * @param p 模式串（子串） n个元素
     *          s[l,l+n)=p
     *          i    子串 第一次出现的索引位置
     *          sc   s的指针 扫描指针
     *          j    p的指针 匹配指针 失陪就回溯
     *          i    子串第一次出现的索引
     *          1.思路：一次一次的 对应比较 失配 就从头开始，
     *          <p>
     *          2.F(l)=k; l失配 s回溯 p[0~l-1]的pre. suff 最大匹配数 前后重叠
     *          j 失配了应该回溯到的位置
     */
    private static int violence(String s, String p) {
        int i = 0;
        int sc = i;
        int j = 0;
        while (sc <= s.length()) {
            if (s.charAt(sc) == p.charAt(j)) {//源串 和模式 相同 同时推进匹配
                j++;
                sc++;
                if (j == p.length())
                    return i;
            } else {//失配
                i++;
                sc = i;//>sc++; 第一次的位置 和 s的指针同进 扫描指针 以i为起点 从i开始扫
                j = 0;//从头开始 回溯
            }
        }
        return -1;
    }

    /**
     * next[j]=k;>> j=next[j]
     * b    a   b   a   b   b
     * -1   0   0   1   2   3
     * -1的时候失配 从0开始 因为j++; 模式串
     * j位失配 j回溯到k
     *
     * @param ps
     * @return
     */
    private static int[] ansNext(String ps) {
        int pLength = ps.length();
        int[] next = new int[pLength + 1];
        char[] p = ps.toCharArray();
        next[0] = -1;
        if (ps.length() == 1) {
            return next;
        }
        next[1] = 0;
        int j = 1;
        int k = next[j];//看看位置j的最长匹配前缀在哪
        while (j < pLength) {
            //推出next[j+1] 检查 jk位置关系
            if (k < 0 || p[j] == p[k]) {
                next[++j] = ++k;
            } else
                k = next[k];
        }
        return next;
    }

    public static int indexOf(String s, String p) {
        if (s.length() == 0 || p.length() == 0) return -1;
        if (p.length() > s.length()) return -1;

        int count = 0;
        int[] next = ansNext(p);
        int i = 0;
        int j = 0;
        int sLen = s.length();//源长度
        int pLen = p.length();//模式长度

        while(i<sLen){
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            //j=-1，因为next[0]=-1,说明p的第一位和i这个位置无法匹配，这时i，j都增加1，i移位，j从0开始
            if (j==-1||s.charAt(i)==p.charAt(j)){
                j++;
                i++;//扫描指针
            }else{
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                j=next[j];
            }
            if(j==pLen){
                count++;
                i--;//i ，j 成功的时候 越界了 len是 长度 🙊不是索引
                j=next[j-1];
//                return (i-j); 返回第一次出现的 索引
            }

        }
        return count;
    }

}


