package cf._581D2;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String S = cin.next();
        int ans = S.length() / 2;
        if ((S.length() - 1) % 2 == 0) {//首位是4倍数
            for (int i = 1; i < S.length(); i++) {
                if (S.charAt(i) == '1') {
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
        // 1 0 1 0 0 0 0
        //    16 8 4 2 1
    }
}
