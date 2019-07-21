package BlueCup.Six_MathQuestion;

/**
 * 先手：1非0，赢
 *       2 0 输
 *
 *
 */
public class Case2_NimGame {
    public static void main(String[] args) {
        int[] data={3,4,5};
        boolean ans =solve(data);
        System.out.println(ans);
    }

    private static boolean solve(int[] data) {
        int res = 0;
        for (int i = 0; i < data.length; i++) {
            res ^= data[i];
        }
        return res!=0;//不是0 win
    }
}
