package PAT.BasicLevel;

import java.util.Scanner;

public class _1012数字分类 {
    public static void main(String[] args) {
        int A1,A2,A3,A5;
        double A4;
        A1=A2=A3=A5=0;
        A4=0;
        int A4count=0;
        Scanner cin =new Scanner(System.in);
        int n=cin.nextInt();
        boolean add=true;
        boolean yesn=true;
        for(int i=0;i<n;i++){
            int x=cin.nextInt();
            if(x%5==0&&x%2==0){
                A1+=x;
            }else
            if(x%5==1){
                if(yesn) yesn=false;
                if(add) A2+=x;
                else A2-=x;
                add=!add;
            }else
            if(x%5==2){
                A3++;
            }else
            if(x%5==3){
                A4+=x;
                A4count++;
            }else
            if(x%5==4){
                if(x>A5) A5=x;
            }
        }

        if(A1==0){
            System.out.print("N ");
        }else
            System.out.print(A1+" ");
        if(yesn){
            System.out.print("N ");
        }else
            System.out.print(A2+" ");
        if(A3==0){
            System.out.print("N ");
        }else
            System.out.print(A3+" ");
        if(A4count==0){
            System.out.print("N ");
        }else {
            A4 /= A4count;
            System.out.printf("%.1f ", A4);
        }
        if(A5==0){
            System.out.print("N");
        }else
            System.out.print(A5);
        //若其中某一类数字不存在，则在相应位置输出“N”。

    }
}
