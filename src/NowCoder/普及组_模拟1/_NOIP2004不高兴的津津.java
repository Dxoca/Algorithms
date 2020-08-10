package NowCoder.普及组_模拟1;

import java.util.Scanner;
//https://www.nowcoder.com/study/live/249/3/2
public class _NOIP2004不高兴的津津 {
    public static void main(String args[]) {
        int day;
        int badDayTime = -1;
        int badDay = 0;

        Scanner cin = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            day = cin.nextInt() + cin.nextInt();
            if (day > 8 && day > badDayTime) {// 大于八天 和 相等不会被更新（靠前的最大值）
                badDayTime = day;//记录时长
                badDay = i + 1;//记录天
            }
        }
        System.out.println(badDay);//无就是 0 有就是 i+1
    }
}
