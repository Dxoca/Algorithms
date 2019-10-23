package CometOJ._12_;

import java.util.HashSet;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            int m = cin.nextInt();
            HashSet<String> set=new HashSet<>();
            boolean flag = true;

            for (int j = 0; j < m; j++) {
                String s = cin.next().substring(0,2);
                String a=""+s.charAt(0)+s.charAt(1)+s.charAt(2);
                set.add(a);
            }
            if (set.size()<m) {
                flag = false;
            }
            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

        }

    }

}
