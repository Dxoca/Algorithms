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
        int max=-1;
        for (int i = 0; i < a; i++) {
            A[i] = cin.nextInt();
            if(A[i]>max) max=A[i];
        }
        System.out.print(max+" ");
        b = cin.nextInt();
        max=-1;
        int[] B = new int[b];
        for (int i = 0; i < b; i++) {
            B[i] = cin.nextInt();
            if(B[i]>max) max=B[i];
        }
        System.out.print(max);

    }
}
