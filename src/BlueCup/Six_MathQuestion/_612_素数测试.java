package BlueCup.Six_MathQuestion;

import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.log;

//注意点 不要丢了 <= num 和 i从2开始。
public class _612_素数测试 {
    /**
     * 判断是否是素数模板
     * O(log(n))
     *
     * @param num
     * @return
     */
    public static boolean inPrime(long num) {
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }

    /**
     * 任何整数质因数分解是唯一的
     *
     * @param num
     * @return
     */
    public static Map<Integer, Integer> pirmeFactor(int num) {
        Map<Integer, Integer> map = new HashMap<>();//质因数，出现次数
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                Integer v = map.get(i);
                if (v == null)
                    map.put(i, 1);
                else
                    map.put(i, v + 1);
                num /= i;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        boolean res = inPrime(7L);
        System.out.println(res);
        System.out.println(pirmeFactor(100));
        //遍历map
        Map<Integer, Integer> map = pirmeFactor(100);//质因数 出现的次数
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            for (int i = 0; i < v; i++) {
                sb.append("*" + k);
            }
        }
        System.out.println(sb.substring(1));//从第一个字符开始
        //
        m1(100002);
    }
    //埃氏筛法>预处理
    /**
     * 2的倍数 干掉
     * 3的倍数干掉
     * 4的倍数干掉
     * logn*logn
     * 求第n个素数：
     * 素数定理 在2~n 素数的概率 n/lgn
     * n qrt(n)
     */

    /**
     * 求第N个素数
     *
     * @param N
     */
    public static void m1(int N) {
        //由素数定理：
        //从不大于n的自然数随机选一个，它是素数的概率大约是1/ln n
        //N是第N 个素数
        //已知在整数x内大概有 x* 1/ln (x)个素数
        //现在我们要逆推：要想求第N个素数，我们的整数范围是什么
        //n就是整数范围
        int n = 2;
        while (n / log(n) <= N) {
            n++;
        }
        //开辟数组，下标自然数，数值mark
        //筛选法 标记素数
        int arr[] = new int[n];
        int x = 2;
        while (x < n) {
            //标记过了 继续下一个
            if (arr[x] != 0) {
                x++;
                continue;
            }
            int k = 2;
            //对于每个x 我们从2倍开始，对x的k倍 都mark -1
            while (x * k < n) {
                arr[x * k] = -1;
                k++;
            }
            x++;
        }
        //筛完之后，这个很长的数组里面非素数下标对应的值都是-1
        int sum = 0;
        for (int i = 2; i < arr.length; i++) {
            //是素数 计数+1
            if (arr[i] == 0) {
                sum++;
            }
            if (sum == N) {//素数的计数
                System.out.println(i); //索引是数值
                return;
            }
        }
    }

}
