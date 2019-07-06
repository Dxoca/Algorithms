package BlueCup;

public class _403_ZPrintArr {
    //Z形打印 1 2 5 9 0 3 4 7 10 13 0 11 模拟
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 12},
                {13, 0, 15, 16},
        };
        //r 行
        //c 列
        Check(arr);

    }
    private static void Check(int[][] arr) {
        int r = 0, c = 0;//行列
        int m = arr.length, n = arr[0].length;//最大行列
        boolean lor = true;//上或者下的斜线
        while (r < m && c < n) {
            if (lor) {//上坡
                System.out.print(arr[r][c] + " ");
                //第一行列未到边界，只能向右走
                if (r == 0 && c < n - 1) {
                    lor = !lor;//方向切换
                    c++;

                } else if (r > 0 && c == n - 1) {//最后一列向下走
                    lor = !lor;
                    r++;

                } else {//行减 列增
                    r--;
                    c++;
                }
            } else {//走下坡
                System.out.print(arr[r][c] + " ");
                if (c == 0 && r < m - 1) {//周到第一列 只能往下走
                    lor = !lor;
                    r++;
                }else if(r==m-1){//最后一行 只能往右
                    lor=!lor;
                    c++;
                }else{//行增 列减
                    r++;
                    c--;
                }
            }
        }
    }
}
