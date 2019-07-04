package BlueCup;

public class _404_Line1Matrix {
    public static void main(String[] args) {
        //边界为1的最大子方阵列
        int[][] Matrix = {
                {0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 1, 1, 1, 0},
                {0, 1, 0, 1, 1}
        };//
        int N = Matrix.length;
        int ans = solve(Matrix, N);
        System.out.println(ans);
    }

    private static int solve(int[][] a, int N) {
        int n = N;
        while (n > 0) {
            for (int i = 0; i < N - 1; i++) {//行
                if (i + n > N) break;
                L3:
                for (int j = 0; j < N - 1; j++) {//列
                    if (j + n > N) break;
                    //(i,j)定点
                    int r = i;//行
                    int c = j;//列
                    //上边 往右
                    while (c < j + n) {//小雨边界 往右走
                        if (a[r][c] == 0) continue L3;
                        c++;//列
                    }
                    c--;
                    //右边 往下
                    while (r < i + n) {
                        if (a[r][c] == 0) continue L3;
                        r++; //行
                    }
                    r--;
                    //下 往左
                    while (c >= j) {
                        if (a[r][c] == 0)continue L3;
                        c--; //行
                    }
                    c++;
                    //左边
                    while (r >= i) {
                        if (a[r][c] == 0)continue L3;
                        r--; //行
                    }
                    r++;
                    return n;
                }
            }
            n--;
        }
        return 0;
    }
}

