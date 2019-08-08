package BlueCup.Seven_recursion.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _9_6括号 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        System.out.println( solve(n));
    }

    private static Set<String> solve(int n) {
        Set<String> s_n = new HashSet<>();
        s_n.add("()");
        if (n == 1) {
            return s_n;
        }
        for (int i = 1; i < n; i++) {
            Set<String> s = new HashSet<>();
            for (String x : s_n) {
                s.add(x + "()");
                s.add("(" + x + ")");
                s.add("()" + x );
            }
            s_n = s;
        }
        return s_n;

    }
}
