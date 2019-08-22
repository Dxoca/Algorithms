package BlueCup.Eight_DP_greed;

import java.util.ArrayList;

public class LCS {
    public static void main(String[] args) {
        String s1, s2;
        s1 = "3069248";
        s2 = "513164318";
        System.out.println(dfs(s1, s2));
        s1 = "3563243";
        s2 = "513141";
        System.out.println(dfs(s1, s2));
        s1 = "123";
        s2 = "456";
        System.out.println(dfs(s1, s2));
    }

    /**
     * DFS求LCS
     * 双重循环 多路分支
     * @param s1
     * @param s2
     * @return
     */
    private static ArrayList<Character> dfs(String s1, String s2) {
        int len1 = s1.length(),
                len2 = s2.length();
        ArrayList<Character> ans = new ArrayList<>();
        for (int i = 0; i < len1; i++) {//每个打头
            ArrayList<Character> tmp = new ArrayList<>();
            for (int j = 0; j < len2; j++) {//找s1s2相同的
                if (s1.charAt(i) == s2.charAt(j)) {
                    tmp.add(s1.charAt(i));
                    tmp.addAll(dfs(s1.substring(i + 1), s2.substring(j + 1)));//递归 扫描找后续公共子序列
                    break;//找到 退出
                }
            }
            if (tmp.size() > ans.size()) {
                ans = tmp;
            }
        }
        return ans;
    }

    /**
     * 比对范围在做变化
     * 单元格的意义 当前范围S1S2的长度
     * @param s1
     * @param s2
     */
    private static void dp(String s1, String s2){

    }
}
