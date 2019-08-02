package CC150;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Handler;

/**
 * 请编写一个方法，返回某集合的所有非空子集。
 * <p>
 * 给定一个int数组A和数组的大小int n，请返回A的所有非空子集。
 * <p>
 * 保证A的元素个数小于等于20，且元素互异。
 */
public class _904_集合的子集 {
    public static void main(String[] args) {
        int[] A = {12, 22, 32};
        Set<Set<Integer>> Subsets3 = getSubsets3(A, A.length);

        System.out.println(Subsets3);

        System.out.println(getSubsets2(A, A.length));
        System.out.println(getSubsets(A,A.length));
    }

    public static ArrayList<ArrayList<Integer>> getSubsets(int[] A, int n) {
        Arrays.sort(A);//正序排序
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();//大集合
        for (int i = (int) Math.pow(2, n) - 1; i > 0; i--) {//大数字减1
            ArrayList<Integer> s = new ArrayList<>();//对每个i建立集合
            for (int j = n - 1; j >= 0; j--) {
                //检查哪个位上的二进制为1，从高位开始检查，高位对应这素组靠后的元素
                if (((i >> j) & 1) == 1) {
                    System.out.println(Integer.toBinaryString(i)+":"+Integer.toBinaryString(j));
                    s.add(A[j]);
                    System.out.println(A[j]);
                }
            }
            res.add(s);
        }
        return res;
    }

    /**
     * 逐步生成迭代大法
     *
     * @param A
     * @param n
     * @return
     */
    public static Set<Set<Integer>> getSubsets2(int[] A, int n) {
        Set<Set<Integer>> res = new HashSet<>();
        res.add(new HashSet<>());//空集
        //从第一个元素开始
        for (int i = 0; i < n; i++) {
            Set<Set<Integer>> res_new = new HashSet<>();//新建一个大集合
            res_new.addAll(res);//把原来集合中的每个子集都加入到新集合中
            for (Set e : res) {//遍历之前的集合 并克隆加入新的
                Set clone = (Set) ((HashSet) e).clone();
                clone.add(A[i]);
                res_new.add(clone);
            }
            res = res_new;
        }
        return res;

    }

    /**
     * 递归增量构造法
     */
    private static Set<Set<Integer>> getSubsets3(int[] A, int n) {
        return getSubsets3Core(A, n, n - 1);
    }

    private static Set<Set<Integer>> getSubsets3Core(int[] A, int n, int cur) {
        Set<Set<Integer>> newSet = new HashSet<>();
        if (cur == 0) {//处理第一个元素
            Set<Integer> nil = new HashSet<>();//空集
            Set<Integer> first = new HashSet<>();//包括一个元素的集合
            first.add(A[0]);
            newSet.add(nil);
            newSet.add(first);
            return newSet;
        }
        Set<Set<Integer>> oldSet = getSubsets3Core(A, n, cur - 1);
        for (Set<Integer> set : oldSet) {
            //对于每个子集，cur这个元素可以加进去,也可以不加进去
            newSet.add(set);//保留原样 就是不加进去
            //克隆旧的 再旧的里面加上新的
            Set<Integer> clone = (Set<Integer>) ((HashSet) set).clone();
            clone.add(A[cur]);

            newSet.add(clone);
        }
        return newSet;
    }
}
