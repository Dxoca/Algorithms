package BlueCup.Seven_recursion;

import java.util.Scanner;

public class Dfs6空困难的串 {
    static int n;
    static int l;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();//第n个困难
        l = cin.nextInt();//前几个字符
        dfs("");

    }

    static int count = 0;

    private static void dfs(String prefix) {
        //尝试在每个prefix后面追加一个字符
        for (char i = 'A'; i < 'A' + l; i++) {
            if (isHard(prefix, i)) {//难点
                String x = prefix + i;
                System.out.println(x);//输出[0,n) n-1就是最后一个了
                count++;
                if (count == n) {
                    System.exit(0);
                }
                dfs(x);//继续搜索
            }
        }
    }

    /**
     * 判断 是否有 两个相邻的重复子串
     * 即判断 prefix+i是否是困难的串
     * 方法1：检查所有长度为偶数的子串，判断前一半=后一半 相比二 效率低下 因为前面的绝对是困难的串
     * 方法2:只需判断当前串的后缀  减少不必要的判断
     * @param prefix 旧串
     * @param i      要加进去的字符
     * @return
     */
    private static boolean isHard(String prefix, char i) {
        int width = 0;//截取的宽度
        for (int j = prefix.length() - 1; j >= 0; j -= 2) {
            final String s1 = prefix.substring(j, j + width + 1);//[)前缀 后缀
            final String s2 = prefix.substring(j + width + 1) + i;//[]
            if (s1.equals(s2)) return false;//有相同 不符合
            width++;
        }
        return true;
    }
}
