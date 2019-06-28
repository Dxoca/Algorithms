package BlueCup;

import java.util.Scanner;
//员工年龄排序
public class _327_WorkersAge {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int[] count = new int[100];
        int x, n = cin.nextInt();

       for (int i=0;i<n;i++){
            x = cin.nextInt();
            count[x]++;
        }//计数排序
        for (int i = 0; i < 100; i++) {//遍历所有的桶
            while (count[i]-- > 0) {//一个数 输出一次
                System.out.print(i + " ");
            }

        }
    }
}
/**
 10
 12
 34
 56
 7
 78
 56
 34
 23
 45
 67
 */