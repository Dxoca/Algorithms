package BlueCup.Seven_recursion;

import java.util.Scanner;

public class Dfs3水洼的数目 {
    static int n,m;
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
         n=cin.nextInt();
         m=cin.nextInt();
        char [][] a=new char[n][];
        int cnt=0;
        for (int i = 0; i < n; i++) {
            a[i]=cin.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j]=='W') {
                    dfs(a, i, j);//清除一个水洼
                    cnt++;//计数
                }
                
            }
        }
        System.out.println(cnt);

    }

    private static void dfs(char[][] a, int i, int j) {
        a[i][j]='.';
        for (int k = -1; k <2 ; k++) {//-1 0 1  9种状态
            for (int l = -1; l <2 ; l++) {

                if(k==0&&l==0){ //不动的状态去除
                    continue;
                }
                if(i+k>=0&&i+k<=n-1&&j+l>=0&&j+l<=m-1){//边界检测 行 列 八个平行状态
                    if(a[i+k][j+l]=='W'){
                        dfs(a,i+k,j+l);
                    }
                }
            }
        }
    }
}
