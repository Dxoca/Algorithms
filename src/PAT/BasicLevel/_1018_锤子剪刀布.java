package PAT.BasicLevel;

import java.util.Scanner;

public class _1018_锤子剪刀布 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] A = new int[3];//胜 平 败

        int[] winA = new int[3];//b c j
        int[] winB = new int[3];//b c j
        char[] sign={'B','C','J'};
        while (n-- > 0) {
            String a = cin.next();
            String b = cin.next();
            switch (a) {
                case "B":
                    if (b == a) {//平局
                        A[1]++;
                    } else if (b == "J") {A[2]++;winB[2]++;}//输了
                    else {
                        A[0]++;
                        winA[0]++;
                    }//赢了
                    break;
                case "J":
                    if (b == a) {//平局
                        A[1]++;
                    } else if (b == "C") {A[2]++;winB[1]++;}//输了
                    else {
                        A[0]++;
                        winA[2]++;
                    }//赢了
                    break;
                case "C":
                    if (b == a) {//平局
                        A[1]++;
                    } else if (b == "B") {A[2]++;winB[0]++;}//输了
                    else {
                        A[0]++;
                        winA[1]++;
                    }//赢了
                    break;
            }
        }
        int max=winA[0],tA=0,tB=0;
        for (int i = 1; i <winA.length ; i++) {
            if(winA[i]>max){
                max=winA[i];
                tA=i;
            }
        }
        max=winB[0];
        for (int i = 1; i <winB.length ; i++) {
            if(winB[i]>max){
                max=winB[i];
                tB=i;
            }
        }
        System.out.println(A[0] + " " + A[1] + " " + A[2]);
        System.out.println(A[2] + " " + A[1] + " " + A[1]);
        System.out.println(sign[tA]+" "+sign[tB]);
    }
}
