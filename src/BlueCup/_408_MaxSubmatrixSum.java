package BlueCup;

import java.util.Arrays;

/**
 * 假定只有一行，那就和求最大和子数组一样
 * 如果限定两行，可以把两行按列求和，同上
 * ……
 * 所有我们从把第一行当做起点，依次累加后面的每一行后，都求一个最大子数组和
 * 以第二行作为起点，依次累加后面的每一行后，都求一个最大子数组和
 * <p>
 * 每次求出来的和与历史最大值比较，如果更大，则更新
 */
public class _408_MaxSubmatrixSum {
    //O(n^3)
    public static void main(String[] args) {
        int[][] matrix = {//3+2+1种情况
                {-90, 48, 78},
                {64, -40, 64},
                {-81, -7, 66}
        };
        int[][] arr = {
                {-1, -1, -1},
                {-1, 2, 2},
                {-1, -1, -1},
        };

        int ans = maxSum(matrix);
        System.out.println(ans);
    }

    private static int maxSum(int[][] matrix) {
        int beginRow = 0;
        int M = matrix.length;//行
        int N = matrix[0].length;//列
        int max = 0;
        int[] sum = new int[N];//N列
        while (beginRow < M) {
            for (int i = beginRow; i < M; i++) {//当前行到最后一行
                for (int j = 0; j < N; j++) {
                    sum[j] += matrix[i][j];
                }
                //组(压缩) 降维 求和完成 求出 最大子数组
//                int ans = _407_SubarrayMaxSum.check(sum);//调用已写好的
                int ans = Sms(sum);//调用自己写的
                if (ans > max)
                    max = ans;
            }
            Arrays.fill(sum, 0);
            beginRow++;

        }
        return max;
    }

    static int Sms(int[] arr) {    //返回 子数组最大累加和//负数丢弃 正数保留。
//        arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int max = arr[0];
        int sum = max;
        for (int i = 1; i < arr.length; i++) {
            if (sum >= 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            if (sum > max)
                max = sum;
        }
        return max;
    }
}

