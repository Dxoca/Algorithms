public class test {
    public static void main(String[] args) {
        //金字塔
        //1
        // 1 2 1
        // 1 2 3 2 1
        // 1 2 3 4 3 2 1
        int i, j, m = 4;
        for (i = 0; i < m; i++) {
            for (j = 0; j < i + 1; j++) {
                System.out.print(j + 1 + " ");
            }
            for (j = 0; j < i; j++) {
                System.out.print(i - j + " ");
            }
        }
    }
}
