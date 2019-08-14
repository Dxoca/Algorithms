package cf._579D3;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        StringBuilder s1 = new StringBuilder(cin.next());
        StringBuilder s2 = new StringBuilder(cin.next());
        int k = 0;
        int start = 0;
        int max = -2;
        while (start < s1.length()) {
            k = s1.indexOf(s2.toString(), k);
            if (k - start > max) {
                max = k - start;
            }
            System.out.println(k-start);
            start += k + s2.length();
            System.out.println("K:" + k + "start:" + start);

        }
        System.out.println(k);
    }
}
