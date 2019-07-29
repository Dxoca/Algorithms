package POJ;

import java.util.Scanner;

public class _1006_Biorhythms {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int p,e,i,d;
        final int year=365;
        while(-4!=(p=cin.nextInt())+(e=cin.nextInt())+(i=cin.nextInt())+(d=cin.nextInt())
        ){//23 28 33
            for (int j = 0; j <= 212520; j++) {
                if(j%23==j%28&&j%23==j%33){
                    System.out.println(j);
                    break;
                }
            }
        }
    }
}
