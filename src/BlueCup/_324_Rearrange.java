package BlueCup;

/**
 * @Author Dxoca
 * @Source Case08_Rearrange.java
 * 题8 需要排序的子数组
 * 给定一个无需数组arr 求出需要排序的最短子数组长度
 * 要求：O(n)
 * input arr 2 3 7 5 4 6  return 4 because only 7546 need Rearrange.
 */
public class _324_Rearrange {
    public static int[] findSegment(int[] A, int n) {//find 部分
        int max = A[0];
        int min = A[n - 1];
        int l = -1;
        int r = -1;
        for (int i = 0; i < n; i++) {

            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < max) {//只要低于 最高峰 右边拓展
                r = i;
            }

        }
        for (int i = n - 1; i >= 0; i--) {
            if (A[i] < min) {//最低的点
                min = A[i];
            }
            if (A[i] > min) {
                l = i;
            }
        }
        if (l == -1) {
            return new int[]{0, 0};
        }
        return new int[] {l,r};
    }
    public static void main(String[] args) {
        int[] A ={1, 4, 6, 5, 9, 10};
        int[] res=_324_Rearrange.findSegment(A,A.length);
        System.out.println(A[res[0]]+","+A[res[1]]);
    }
}
