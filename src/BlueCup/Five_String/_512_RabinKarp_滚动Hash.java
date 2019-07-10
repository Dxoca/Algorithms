package BlueCup.Five_String;

import static java.util.Objects.hash;

public class _512_RabinKarp_滚动Hash {
    public static void main(String[] args) {
        String s ="ABABAB";
        String p ="BAB";
        match(p,s);

    }

    /**
     *
     * @param p 模式
     * @param s 源串
     *          hash(p)=o(n)
     *          hash(s)=o(m*n);
     *          hash-> 滚动hash=O(m+n)
     */
    private static void match(String p, String s) {
        long hash_p=hash(p);
        int p_len=p.length();
        for (int i = 0; i+p_len <= s.length(); i++) {
            long hash_i=hash(s.substring(i,i+p_len));// 子串[i,i+p_len)
            if(hash_p==hash_i){
                System.out.println("Match:"+i);
            }
        }
    }
}
