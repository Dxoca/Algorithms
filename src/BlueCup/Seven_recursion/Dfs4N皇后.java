package BlueCup.Seven_recursion;

import java.util.Scanner;

import static java.lang.System.out;

public class Dfs4N皇后 {
    static int n;
    static int[] rec;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        rec = new int[n];//记录皇后的位置
        dfs(0);
        System.out.println(cnt);
    }

    /**
     * @param row 正在处理的行
     */
    private static void dfs(int row) {
        if (row == n) {
            cnt++;
            return;
        }
        for (int col = 0; col < n; col++) {//皇后所在行的位置（依次每个列防止皇后）
            if (check(rec, col, row)) {//检查位置 是否与之前的皇后冲突
                rec[row] = col;//标记皇后
                dfs(row + 1);
            }
        }
    }

    /**
     * @param rec 皇后的位置 索引位行 值该位置
     * @param col 所在行的位置 i-->col 所在列的位置
     * @param row 所处的行
     * @return 是否可以在该位置防止皇后
     */
    private static boolean check(int[] rec, int col, int row) {
        for (int i = 0; i < row; i++) {//遍历行
            if (rec[i] == col) {//列相同了
                return false;
            }
            if (i + rec[i] == row + col) {//正斜线
                return false;
            }
            if (i - rec[i] == row - col) {//反斜线
                return false;
            }
        }
        return true;
    }
}
