package LinearAlgebra;

import java.util.Scanner;

public class _01_NAryArrangement {
    /**
     * @author Dxoca
     * 第二章 n 阶行列式
     * S1：n元排列 P28
     * 1.判断排列是 是奇、偶排列
     * 2.求逆序数（逆序对 的数目 ）τ
     * Such as: τ(2431)= 4 >(21 43 41 31)
     * if τ is odd number the det is - else + τ的奇偶决定行列式该项的正负
     */
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);

        while(true) {//多次测试数据

            String ans = cin.next();
            char[] series;//数列
            series = ans.toCharArray();//数字大小 等效 char 大小 所以不对char处理
            int o = 0; //Initialize Order Number
            int t = 0; //Initialize Reverse Order Number(τ)
//
            // Calculus the Order Number and the Reverse Order Number:
            // 计算顺序数个逆序数的个数
            for (int i = 0; i < series.length - 1; i++) {//共 n-1个数字比较
                for (int j = i; j < series.length - 1; j++) {//每个数字要比较的次数
                    if (series[i] < series[j + 1])//注意 是 i 和j+比较
                        o++;
                    else if (series[i] > series[j + 1]) {
                        t++;//逆序数
                        System.out.print((series[i]) + "" + (series[j + 1]) + " ");//输出逆序对
                    }
                }
            }
            System.out.println("\n逆序数：" + t);//τ
            System.out.println("顺序数：" + o);
            if (t % 2 == 0) {
                System.out.println("是偶排列");
            } else
                System.out.println("是奇排列");
            System.out.println("+++++++++++++++");
        }
    }

}
