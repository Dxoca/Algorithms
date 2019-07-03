package BlueCup;


public class _402_RowAndColToZeroReset {
    public static void main(String[] args) {
        Integer[][] arr = {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 12},
                {13, 0, 15, 16},
        };
        check(arr);

    }

    private static void check(Integer[][] arr) {
        int M = arr.length;
        int N = arr[0].length;
        int[] rowRecord = new int[M];//行
        int[] colRecord = new int[N];//列
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    rowRecord[i] = colRecord[j] = 1;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (rowRecord[i] == 1 || colRecord[j] == 1) {
                    arr[i][j] = 0;
                }
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
