package CometOJ;
import java.util.Scanner;

/**
 * @name 迫真字符串
 * @Test https://cometoj.com/contest/46/problem/A?problem_id=2021
 * @Author Dxoca
 */
public class Contest5_A {
    public static void main(String[] args){
        Scanner cin =new Scanner(System.in);
        int[] b=new int [10];
        int ans=0;
        char[] a=cin.nextLine().toCharArray();

        for (int i = 0; i < a.length; i++) {
            b[a[i]-'0']++;
        }
        boolean flag=true;
        while (flag) {
            if (b[1] >= 3 && b[4] >= 2 && b[5] >= 1) {//重新排序后114514出现的最大次数
                b[1] -= 3;
                b[4] -= 2;
                b[5] -= 1;
                ans++;
            } else
                flag = !flag;
        }
        System.out.println(ans);
    }
}
