package PAT.BasicLevel;

import java.util.Scanner;

import static java.lang.Math.min;

public class _1014_福尔摩斯约会 {
    public static void main(String[] args) {
        String a1, a2;
        String b1, b2;
        Scanner cin = new Scanner(System.in);
        a1 = cin.next();
        a2 = cin.next();
        b1 = cin.next();
        b2 = cin.next();
        int week = 0;
        String[] weeks={"MON","TUE","WED","THU","FRI","SAT","SUM"};
        String hour = "";
        String minut = "";
        int aLen = min(a1.length(), a2.length());
        int count = 0;
        for (int i = 0; i < aLen; i++) {
            if (count == 0) {
                if (a1.charAt(i) >= 'A' && a1.charAt(i) == a2.charAt(i)) {//大写
                    week = a1.charAt(i) - 'A' ;//0~6 数组索引
                    count++;
                    continue;//很关键
                }
            }
            if (count == 1) {//相同的字符 钟头
                if (a1.charAt(i) == a2.charAt(i)) {
                    if (a1.charAt(i) >= '0' && a1.charAt(i) < '9') {
                        hour = "0" + a1.charAt(i);
                        count++;
                    } else if (a1.charAt(i) >= 'A' && a1.charAt(i) <= 'N') {
                        hour = String.valueOf(a1.charAt(i) - 'A' + 10);
                        count++;
                    }
                }
            }
        }

        //b starting
        int bLen = min(b1.length(), b2.length());
        for (int i = 0; i < bLen; i++) {
            if ((b1.charAt(i) >= 'a' && b1.charAt(i) <= 'z' || b1.charAt(i) >= 'A' && b1.charAt(i) <= 'Z') && b1.charAt(i) == b2.charAt(i)) {
                if (i <= 9) {
                    minut = "0" + i;
                } else
                    minut = "" + i;
            }
        }
        System.out.print(weeks[week]+" "+hour+":"+minut);
    }

}
