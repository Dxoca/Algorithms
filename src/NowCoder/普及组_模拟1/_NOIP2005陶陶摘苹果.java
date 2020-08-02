package NowCoder.普及组_模拟1;

import java.util.Scanner;
//https://www.nowcoder.com/study/live/249/3/4
public class _NOIP2005陶陶摘苹果 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int[] apples = new int[10];//树
        int tall, count = 0;//身高
        for (int i = 0; i < 10; i++) {
            apples[i] = cin.nextInt();
        }
        tall = cin.nextInt() + 30;
        for (int i = 0; i < 10; i++) {
            if (apples[i] <= tall) count++;//在可摘范围内
        }
        System.out.println(count);
    }
}
