package BlueCup.Seven_recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class Dfs2部分和 {
    static int kk;

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 7};
        int n = a.length;//
        int k = 13;
        kk = k;
        getSubsets(a, n, k);
        dfs(a, k, 0, new ArrayList<>());
    }

    private static void dfs(int[] a, int k, int cur, ArrayList<Integer> ints) {
        if (k == 0) {
            System.out.print("Yes ("+kk+" = ");
            for (int i = 0; i < ints.size(); i++) {
                System.out.print(ints.get(i)+(ints.size()-1!=i?" + ":")"));
            }
            System.exit(0);
        }
        if (k < 0 | cur == a.length) {
            return;
        }
        dfs(a, k, cur + 1, ints);//不要
        ints.add(a[cur]);
        int index = ints.size() - 1;
        dfs(a, k - a[cur], cur + 1, ints);//要
        ints.remove(index);
    }

    /**
     * 二进制法子集
     *
     * @param A
     * @param n
     * @param k
     * @return
     */
    public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n, int k) {
        Arrays.sort(A);//正序排序
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();//大集合
        for (int i = (int) Math.pow(2, n) - 1; i > 0; i--) {//大数字减1
            ArrayList<Integer> s = new ArrayList<>();//对每个i建立集合
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                //检查哪个位上的二进制为1，从高位开始检查，高位对应这素组靠后的元素
                if (((i >> j) & 1) == 1) {
                    s.add(A[j]);
                    sum += A[j];
                }
            }
            if (sum == k) {
                for (int j = 0; j < s.size(); j++) {
                    System.out.print(s.get(j) + (j != s.size() - 1 ? "+" : ""));
                }
                System.out.println();
            }
            res.add(s);
        }
        return res;
    }
}
