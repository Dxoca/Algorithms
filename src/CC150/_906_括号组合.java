package CC150;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 请设计一种算法,打印n对括号的全部有效组合(即左右括号正确配对).
 * 输入:3
 * 输出:()()(),(()()),()(()),(())(),((()))
 */
public class _906_括号组合 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        Set<String> parentihesis = parenthesis(n);
        System.out.println(parentihesis);
        parentihesis =parenthesis1(3);
        System.out.println( parentihesis );

    }

    /**
     * 逐步生成之递归解法
     */
    public static Set<String> parenthesis(int n) {//圆括号
        Set<String> s_n = new HashSet<>();//去重
        if (n == 1) {
            s_n.add("()");
            return s_n;
        }
        Set<String> s_n_1 = parenthesis(n - 1);
        for (String eOfN_1 : s_n_1) {
            s_n.add("()" + eOfN_1);
            s_n.add(eOfN_1 + "()");
            s_n.add("(" + eOfN_1 + ")");
        }
        return s_n;
    }

    /**
     * 迭代
     * 重点是推出 1>2>3...n-1>n的关系
     */
    public static Set<String> parenthesis1(int n) {
        Set<String> s_n = new HashSet<>();//保存上次迭代的状态
        s_n.add("()");
        if (n == 1)//特判1
            return s_n;

        for (int i = 2; i <= n; i++) {//等于不要丢了
            Set<String> s_new = new HashSet<>();
            for (String eOFn_new : s_n) {//遍历上次生成的
                s_new.add(eOFn_new+"()");
                s_new.add("("+eOFn_new+")");
                s_new.add("()"+eOFn_new);
            }
            s_n=s_new;//把新的生成替换过去 【旧的清除】
        }
        return s_n;
    }
}

