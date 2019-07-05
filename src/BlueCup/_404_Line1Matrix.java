package BlueCup;
//#算法优化 从O(n^4)-->O(n^3)
public class _404_Line1Matrix {
    static int rec[][][];//打表初始化
    // (右,下)

    public static void main(String[] args) {
        //边界为1的最大子方阵列
        int[][] Matrix = {
                {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1}
        };//
        DownRight(Matrix);
        int N = Matrix.length;
        print(rec,N);
        int ans = solve(Matrix, N);
        System.out.println(ans);
    }

    private static void DownRight(int[][] A) {
        int N = A.length;
        rec = new int[N][N][2];
        int row=N-1;

        for (int j = row; j >= 0; j--) {//最后一行
            int value = A[row][j];
            if (value == 1) {
                if (j == N - 1) {//最右边一行
                    rec[row][j][0] = 1;//既然是1 就是自己咯
                } else {
                    rec[row][j][0] = rec[row][j + 1][0]+1;//自身和右侧的+1
                }
                rec[row][j][1] = 1;//最后一行下为0 所以➕自己
            }

        }
        for (int i = row - 1; i >= 0; i--) {//最后一行以及初始化完了所以 开始上一行
            for (int j = N - 1; j >= 0; j--) {
                int value = A[i][j];
                if (value == 1) {
                    if (j == N - 1) {//最右边一行
                        rec[i][j][0] = 1;//既然是1 就是自己咯
                    } else {
                        rec[i][j][0] = rec[i][j + 1][0]+1;//自身和右侧的+1
                    }
                    rec[i][j][1] += rec[i+1][j][1]+1;//加上下一行的数
                }
            }
        }

    }

    private static void print(int[][][] rec, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(rec[i][j][0] + "," + rec[i][j][1] + "\t");
            }
            System.out.println();
        }
    }

    private static int solve(int[][] a, int N) {
        int n = N;
        while (n > 0) {
            for (int i = 0; i < N - 1; i++) {//行
                if (i + n> N) break;
                for (int j = 0; j < N - 1; j++) {
                    if (j + n > N) break;
                    if (check(i, j, n)) {
                        return n;
                    }
                }
            }
            n--;
        }
        return n;
    }

    private static boolean check(int i, int j, int n) {//检查三维矩阵是否合格(右,下)
        if(     rec[i][j][0]>=n&&//左上角 的右边
                rec[i][j][1]>=n&&//左上角的下边
                rec[i][j+n-1][1]>=n&&//右上角的下边
                rec[i+n-1][j][0]>=n) //左下角的右边
        /**
         *  5,1	4,5	3,1	2,1	1,5
         *  0,0	1,4	0,0	0,0	1,4
         *  5,1	4,3	3,2	2,3	1,3
         *  0,0	4,2	3,1	2,2	1,2
         *  2,1	1,1	0,0	2,1	1,1
         */
        {
            return true;
        }

        return false;
    }
}

