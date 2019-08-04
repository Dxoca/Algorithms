package BlueCup.Seven_recursion;

import java.util.Scanner;

public class Dfs1数独 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = cin.nextLine().toCharArray();
        }
        dfs(table, 0, 0);
    }
    private static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }
    public static void dfs(char[][] t, int x, int y) {
        if (x==9){//超出边界
            print(t);
            System.exit(0);//完全结束递归
        }
        if (t[x][y] == '0') {
            for (int i = 1; i <= 9; i++) {
                boolean res = check(t, x, y, i);//检查是否重复  行列矩形内
                if (res) {
                    t[x][y] = (char) ('0' + i);
                    dfs(t, x + (y + 1) / 9, (y + 1) % 9);//状态转移
                }
            }
            t[x][y] = '0';//回溯
        } else {
            dfs(t, x + (y + 1) / 9, (y + 1) % 9);//状态转移
        }
    }

    private static boolean check(char[][] t, int x, int y, int i) {
        for (int j = 0; j < 9; j++) {
            int tmp = i + '0';//没有和i重复
            if (t[x][j] == tmp || t[j][y] == tmp) {//行列
                return false;
            }
            for (int k = (x/3)*3; k <(x/3+1)*3 ; k++) {//小矩形
                for (int l = (y/3)*3; l <(y/3+1)*3 ; l++) {
                    if(t[k][l]==tmp)return false;
                }
            }
        }
        return true;

    }

}
