package LuoGu;

import java.util.Scanner;

public class P1426 {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        double s=cin.nextInt(),x=cin.nextInt();//距离A x左右范围
        double l=0,v=7;
        int count=0;
        boolean live=true;//
        while (true){
            if(l>s+x){//超过检测器最右边
                break;
            }else if(l>=s-x){
                count++;
                if(count==2){
                    live=false;
                    break;
                }
            }
            l+=v;
            v*=0.98;
        }
        if(live){
            System.out.println("n");//没有危险
        }else
            System.out.println("y");

    }
}
