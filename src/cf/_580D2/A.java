package cf._580D2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int a, b;
        a = cin.nextInt();
        int[] A = new int[a];
        int[] ans = new int[1000];
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < a; i++) {
            A[i] = cin.nextInt();
            s.add(A[i]);
        }
        b = cin.nextInt();
        int[] B = new int[b];
        for (int i = 0; i < b; i++) {
            B[i] = cin.nextInt();
            s.add(B[i]);
        }
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (!s.contains(A[i] + B[i])) {
                    System.out.println(A[i] + " " + B[i]);
                    return;
                }
            }
        }

    }
}
