package cf._578D2;

import java.util.Arrays;
import java.util.Scanner;

public class A {
    static int[] room = new int[10];
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        char[] res;
        res = cin.next().toCharArray();
        for (int i = 0; i < n; i++) {
            if (res[i] == 'L')
                leftInput();
            else if (res[i] == 'R')
                rightInput();
             else
                room[res[i] - '0'] = 0;

        }
        for (int i = 0; i < room.length; i++) {
            System.out.print(room[i]);
        }
    }
    private static void leftInput() {
        for (int i = 0; i < 10; i++)
            if (room[i] == 0) {
                room[i] = 1;break;
            }
    }

    private static void rightInput() {
        for (int i = 9; i >= 0; i--)
            if (room[i] == 0) {
                room[i] = 1;break;
            }
    }

}
