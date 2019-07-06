package BlueCup;

import java.util.Scanner;

/**
 * 矩阵的运算
 * M 行  N 列
 *
 */
public class _409_MatrixCalculation {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int M=cin.nextInt();
        int N=cin.nextInt();
        int[][] A=new int[M][N];
        int[][] B=new int[M][N];
        //输入
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j]=cin.nextInt();
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                B[i][j]=cin.nextInt();
            }
        }
        //A+2X=B
        //X=(B-A)/2
        int[][] x=getX(A,B);
        System.out.println();


    }

    private static int[][] getX(int[][] A, int[][] B) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                A[i][j]=(A[i][j]+B[i][j])/2;
            }
        }
        return A;
    }

}
