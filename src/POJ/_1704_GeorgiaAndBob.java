package POJ;

import java.util.Arrays;
import java.util.Scanner;
//https://vjudge.net/problem/POJ-1704
public class _1704_GeorgiaAndBob {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int k=cin.nextInt();
        for (int i = 0; i < k; i++) {//几次数据测试
            int ans=0;
            int n = cin.nextInt();
            int[] num = new int[n];
            for (int j = 0; j < n; j++) {//n个 输入
                num[j] = cin.nextInt();
            }
            Arrays.sort(num);//坑点  要排序
            if (n % 2 == 0) {//偶数 12 34 6 9
                for (int j = 1; j < n; j+=2) {
                    ans^=(num[j]-num[j-1]-1);
                }
            }else{
                for (int j = 0; j <n ; j+=2) {//2 4 5
                    ans^=(j==0)?(num[j]-1):(num[j]-num[j-1]-1);
                }
            }
            if(ans==0){//先手输了
                System.out.println("Bob will win");
            }else
                System.out.println("Georgia will win");
        }
    }
}
