package CometOJ;

import java.util.Scanner;

public class C0129神器的幻方 {
    public static void main(String[] args) {
        final int N=40;
        Scanner cin =new Scanner(System.in);
        int n=cin.nextInt();
        // 0 1 2 3 4
        int[][] a =new int[N][N];
        int x=1;
        int y=n/2+1;
        for (int i = 1; i <= n*n; i++) {
            a[x][y]=i;
            //x是行 y是列
            if(x==1&&y==n) x++; //右上角
            else if(x==1&&y!=n) {x=n;y++;}
            else if(y==n){x--;y=1;}
            else if(a[x-1][y+1]!=0)x++;
            else {x--;y++;}

            }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=n; j++) {
                System.out.print(a[i][j]);
                if(j!=n) System.out.print(" ");
            }
            System.out.println();
        }

    }
}
