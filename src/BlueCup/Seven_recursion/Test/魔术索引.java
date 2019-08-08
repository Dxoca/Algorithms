package BlueCup.Seven_recursion.Test;

public class 魔术索引 {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};//false
        int[] b = {1, 1, 3, 4, 5};//true
        int[] c = {1, 1, 3, 4, 5, 6, 7, 8, 9};//true
        int[] d = {1, 2, 3, 4, 5, 6, 6, 8, 9};//flase

        boolean ans;
        ans = solve2(a);
        System.out.println(ans);

    }

    private static boolean solve2(int[] c) {
        for (int i = 0; i < c.length; ) {
            if (i == c[i])
                return true;
            else if (c[i] > i) {
                i = c[i];
            } else {
                i++;
            }
        }
        return false;
    }


}

