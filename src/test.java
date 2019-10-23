public class test {
    public static void main(String[] args) {

        //金字塔
        //1
        // 1 2 1
        // 1 2 3 2 1
        // 1 2 3 4 3 2 1
        int  m = 10;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= i * 2; j++) {
                System.out.print((j <= i ? j + 1 :2*i-(j-1) ) + " ");
            }
            System.out.println();
        }

    }
}
