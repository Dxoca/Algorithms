package BlueCup;

public class _401_Print2DArr {

    //顺时针打印二维数组
    //Print2DArr
    //Row 行
    //Col 列
    //写一步测一步
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3, 4,100},
                {5, 6, 7, 8,101},
                {9, 10, 11, 12,102},
                {13, 14, 15, 16,103},
                {104,105,106,107,108}
        };
        clockwisePrint(arr);
    }

    private static void clockwisePrint(int[][] arr) {
        int leftUpRow = 0, leftUpCol = 0;//左上角 行 列
        int rightDownRow = arr.length - 1, rightDownCol = arr[0].length - 1;//右下角行列
        while (leftUpRow <= rightDownRow && leftUpCol <= rightDownCol) {//俩对顶角相互调换
            int r = leftUpRow;
            int c = leftUpCol;
            //上边
            while (c <= rightDownCol) {
                System.out.print(arr[r][c++] + " ");//行不变 列++
            }
            c = rightDownCol;//恢复溢出
            r++;//向下一行

            while (r <= rightDownRow) {
                System.out.print(arr[r++][c] + " ");//行++ 列不变
            }
            r = rightDownRow;//恢复列溢出
            c--;//从左边一列开始

            while (c >= leftUpCol) {//
                System.out.print(arr[r][c--] + " ");//行不变 列--
            }
            c = leftUpCol;//恢复列溢出
            r--;//上边一行开始

            while (r > leftUpRow) {
                System.out.print(arr[r--][c] + " ");
            }
            leftUpCol++;
            leftUpRow++;
            rightDownCol--;
            rightDownRow--;
        }
    }
}
