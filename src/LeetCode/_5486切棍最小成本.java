package LeetCode;

public class _5486切棍最小成本 {

}

class Solution {
    public int minCost(int n, int[] cuts) {
        boolean[] mark = new boolean[cuts.length];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cuts.length; i++) {
            dfs(cuts, i, mark, min);
        }
    }

    /**
     *
     * @param cuts 棍子位置
     * @param i 切的位置
     * @param mark 是否已经切除的标记
     * @param min 记录min的sum
     */
    private void dfs(int[] cuts, int i, boolean[] mark, int min) {
        for (int j = 0; j < cuts.length; j++) {
            if(mark[j])
        }

    }
}