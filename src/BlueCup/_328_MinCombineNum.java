package BlueCup;
//自定义排序
/**
 * 数组能排成的最小数（特殊排序）
 */

import java.util.Arrays;
import java.util.Comparator;

public class _328_MinCombineNum {
    public static void main(String[] args) {
        int res = f(new Integer[]{3,23,321});
        System.out.println(res);
    }

    private static int f(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        String s1 = o1 + "" + o2;
                        String s2 = o2 + "" + o1;
                        return s1.compareTo(s2);
                    }
                }

        );
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }
}
