package LuoGu;

import java.util.Scanner;

//P1014 Cantor表
public class P1014 {
    public static void main(String[] args) {
        int X = 1000;//1000*1000=1000000 //X其实 应该再乘 10
        int[][] arr = new int[X][X];
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int t1 = 0, t2 = 0;

        ///Z字形模拟.....
        int r = 0, c = 0;//行列
        int m = arr.length, n = arr[0].length;//最大行列
        boolean lor = true;//上或者下的斜线
        int count = 1;
        while (count <= X * X) {
            if (lor) {//上坡
                arr[r][c] = count++;
                // 上坡 第一行列未到边界，只能向右走
                if (r == 0 && c < n - 1) {
                    lor = !lor;//方向切换
                    c++;
                } else if (r > 0 && c == n - 1) {//上坡  最后一列向下走
                    lor = !lor;
                    r++;
                } else {//上坡 行减 列增
                    r--;
                    c++;
                }
            } else {//走下坡
                arr[r][c] = count++;
                if (c == 0 && r < m - 1) {// 下坡 到第一列 只能往下走 切 不是最后一行
                    lor = !lor;
                    r++;
                } else if (r == m - 1) {//最后一行 只能往右
                    lor = !lor;
                    c++;
                } else {//行增 列减
                    r++;
                    c--;
                }
            }
        }
        //out put ans
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (N == arr[i][j]) {
                    t1 = i + 1;
                    t2 = j + 1;
                    break;
                }
            }
        }
        System.out.println(t1 + "/" + t2);
    }
}
