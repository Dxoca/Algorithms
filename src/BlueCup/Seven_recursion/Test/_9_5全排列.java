package BlueCup.Seven_recursion.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class _9_5全排列 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        char[] a = cin.next().toCharArray();
        Arrays.sort(a);
        permutation("", a);

    }

    private static void permutation(String prefix, char[] arr) {
        if (prefix.length() == arr.length) {
            System.out.println(prefix);
        }
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (count(prefix, ch) < count(arr, ch))
                permutation(prefix + ch, arr);
        }
    }

    static ArrayList<String> res = new ArrayList<>();

    private static int count(String prefix, char ch) {
        int cnt = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) == ch) cnt++;
        }
        return cnt;
    }

    private static int count(char[] arr, char ch) {
        int cnt = 0;
        for (char c : arr) {
            if (c == ch) cnt++;
        }
        return cnt;
    }


}
