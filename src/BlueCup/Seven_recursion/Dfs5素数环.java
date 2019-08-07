package BlueCup.Seven_recursion;

import java.util.Scanner;

public class Dfs5素数环 {
    static int n;
    static int[] rec;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        rec = new int[n];
        rec[0] = 1;
        dfs(1);//第一个元素 1
        if (count == 0)
            System.out.println("no solution!");
        else
            System.out.println(count);
    }

    private static void dfs(int cur) {
        if (cur == n && isP(rec[n - 1] + rec[0])) {//到达n个数 然后判断首+尾是否素数
            count++;
            if (count <= 5) {
                print(rec);
                System.out.println();
            }
            return;
        }

        for (int num = 2; num <= n; num++) {//放的数 从1开始 1初始化放了
            if (check(num, rec[cur - 1])) {// 当前数组重复出现  且前面的数和本位和为素数
                rec[cur] = num;//可以填
                dfs(cur + 1);//填下一个数
                rec[cur] = 0;//回溯
            }
        }
    }

    static int count = 0;

    public static void print(int[] rec) {
        System.out.print("<" + count + ">:");
        for (int i = 0; i < rec.length; i++) {
            System.out.print(rec[i] + " ");
        }
    }

    /**
     * 判断素数
     *
     * @param num
     * @return
     */
    private static boolean isP(int num) {
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }

    //判断重复
    private static boolean check(int num, int cur) {

        for (int e : rec) {
            if (num == e || !isP(num + cur))//相等 不是素数->false
                return false;
        }
        return true;
    }
}
