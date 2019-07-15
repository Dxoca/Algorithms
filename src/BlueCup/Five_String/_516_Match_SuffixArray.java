package BlueCup.Five_String;

import java.util.Arrays;

/**
 * 1.什么是后缀数组
 *      就是传的所有子串按字典序排序后，在数组中记录后缀的起始下标，
 *      后缀数就是：排序和原下标的映射 sa[0]=6 ,起始下标为6的后缀在所有后缀中字典序最小
 *      rank数组：给定后缀的下标 返回其字典序 rk[6]=0;  sa[rk[6]]=6;    sa[rk[i]]=i;
 *  2.后缀数组有啥用
 *      匹配
 *      子串：一定是某个后缀的前缀
 *          BABB
 * Suff{str='AB',index=6}
 * Suff{str='ABAB',index=4}
 * Suff{str='ABABAB',index=2}
 * Suff{str='ABABABAB',index=0}
 * Suff{str='B',index=7}
 * Suff{str='BAB',index=5}
 * Suff{str='BABAB',index=3} >>here
 * Suff{str='BABABAB',index=1}
 * 3.怎么求后缀数组
 *  3.1 把所有后缀数组，放入 Arrays.Sort() nlog(n) 作比较 》》逐字符比较
 *          n个元素 元素和元素之间比较 n
 *          所以整体 【消耗n²log(n)】
 *   3.2 倍增法
 *   k=1 一个字符 排序得sa rk
 *   k=2 利用上一轮的rk快速比较两个后缀
 *   k=4，k=8...
 *
 */
public class _516_Match_SuffixArray {
    public static void main(String[] args) {
        String str = "ABABABAB";
        /**n²log(n) 暴力排序 求后缀数组*/
        Suff[] suff=getSa(str);
        for (int i = 0; i <suff.length ; i++) {
            System.out.println(suff[i].toString());
        }
    }

    /**
     *直接对所有的后缀排序，因为字符串的比较消耗o(n)
     *所以整体消耗n²log(n)
     */

    public static Suff[] getSa(String src) {
        //Sa是排名下标的映射 sa[i]=k 是从k开始的
        Suff[] suffixArray=new Suff[src.length()];
        for (int i = 0; i < src.length(); i++) {
            String suufI=src.substring(i);//从i开始截取全部
            suffixArray[i]=new Suff(suufI,i);
        }
        Arrays.sort(suffixArray);//依据suff的排序比较规则 排序
        return suffixArray;
    }

    static class Suff implements Comparable<Suff> {//compareTo接口
        String str;
        int index;

        /**
         * 把str和index帮到一起
         * @param str 后缀内容
         * @param index 起始下标
         */

        public Suff(String str, int index) {
            this.str = str;
            this.index = index;
        }

        public Suff() {
            str = "NUll";
            index = -1;
        }

        @Override//对象比较 我们比较的是 字符串的字典序
        public int compareTo(Suff s2) {return this.str.compareTo(s2.str);
        }

        @Override
        public String toString() {
            return "Suff{" +
                    "str='" + str + '\'' +
                    ",index=" + index + '}';
        }
    }
    //倍增法

}

