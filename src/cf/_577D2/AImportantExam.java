package cf._577D2;


import java.util.Scanner;

import static java.lang.Math.max;

public class AImportantExam {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int m = cin.nextInt();
        int ans=0;
         int[][] e = new int[m][n];
        for (int i = 0; i < n; i++) {
           String  s = cin.next();
            for (int j = 0; j < m; j++) {
                e[j][s.charAt(j) - 'A']++;
            }
        }
//        System.out.println();
//        for (int i = 0; i <m ; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(e[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = 0; i < m; i++) {
            int a=cin.nextInt();
            int theMax=max(e[i][0],max(e[i][1],max(e[i][2],max(e[i][3],e[i][4]))));
//            System.out.println((char)('A'+i)+":"+theMax+"*"+a);
            ans+=theMax*a;

        }
        System.out.println(ans);

    }
}
