package cf._577D2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CMaximumMedian {
    public static void main(String[] args) {
        Scanner cin= new Scanner(System.in);
        int n=cin.nextInt();
        int k=cin.nextInt();
        int[] num =new int[n];
        for (int i = 0; i < n; i++) {
            num[i]=cin.nextInt();
        }
        Arrays.sort(num);
        System.out.println(Arrays.toString(num));
    }
}
