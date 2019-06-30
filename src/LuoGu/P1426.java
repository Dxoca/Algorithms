package LuoGu;

import java.util.Scanner;

public class P1426 {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int s=cin.nextInt(),x=cin.nextInt();//距离A x左右范围
        double A=7.0;
        int count=0;
        boolean live=true;
        while("QAQ"!=("qaq")){
            if(A>s+x)//直接,,安全了
                break;
            else if(A<=s+x&&A>=s-x){//当前秒结束
                count++;
                if(count>=2){
                    live=false;//第二秒还在 就死
                    break;
                }
            }else if(count==1){
                break;
            }
            A+=A*0.98; //从第二秒开始A=A+A0.89=A=
//            System.out.println(i+":"+A);
        }
        if(live){
            System.out.println("n");
        }else
            System.out.println("y");

    }
}
