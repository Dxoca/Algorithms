package BlueCup.Five_String;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 密码脱落
 *
 *
 * X星球的考古学家发现了一批古代留下来的密码。
 * 这些密码是由A、B、C、D 四种植物的种子串成的序列。
 * 仔细分析发现，这些密码串当初应该是前后对称的（也就是我们说的镜像串）。
 * 由于年代久远，其中许多种子脱落了，因而可能会失去镜像的特征。
 * 你的任务是：
 * 给定一个现在看到的密码串，计算一下从当初的状态，它要至少脱落多少个种子，才可能会变成现在的样子。
 *
 * 输入一行，表示现在看到的密码串（长度不大于1000）
 * 要求输出一个正整数，表示至少脱落了多少个种子。
 *
 * 例如，输入：
 * ABCBA
 * 则程序应该输出：
 * 0
 *
 *
 * 再例如，输入：
 * ABDCDCBABC
 * 则程序应该输出：
 * 3
 *
 */
public class 密码脱落 {
    public static void main(String[] args) {
        String str="ABCBA";
        int ans =solve(str);
        System.out.println(ans);
    }

    /**
     * 想要 把 相同的 字母抵消 然后 计算 身剩 单独的字母 并且判断 原传的奇偶性来 输出个数
     * @param str
     * @return
     *
     * LCS DP
     */
    private static int solve(String str) {
        Map<Character,Integer> map =new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == null){}
        }
        return -1;
    }
}
