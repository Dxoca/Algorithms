package cf._579D3;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int q = cin.nextInt();
        for (int i = 0; i < q; i++) {
            int n = cin.nextInt();
            int[] num = new int[2 * n];
            for (int j = 0; j < n; j++) {
                num[j] = cin.nextInt();
            }
            for (int j = n, k = 0; j < n * 2; j++, k++) {
                num[j] = num[k];
            }
//            System.out.println(Arrays.toString(num));
            boolean ans=f(num, n);
            if(ans){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }

    private static boolean f(int[] num, int n) {
        if (n == 1) {
            return true;
        } else {
            int is = 1;
            for (int i = 0; i < 2 * n; i++) {
                if (num[i] == is) {
                    is++;
                    if (is == n + 1) {
                        return true;
                    }
                } else {
                    is = 1;
                }
            }
            is = n;
            for (int i = 0; i < 2 * n; i++) {
                if (num[i] == is) {
                    is--;
                    if (is == 0) {
                        return true;
                    }
                } else {
                    is = n;
                }
            }

        }
        return false;
    }
}
