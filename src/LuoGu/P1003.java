package LuoGu;

import java.util.Scanner;

//铺地毯
public class P1003 {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt();
        int[][] carpet=new int[n][4];
        for (int i = 0; i < n; i++) {
            int a=cin.nextInt(),b=cin.nextInt(),g=cin.nextInt(),k=cin.nextInt();
            //ABCD
            carpet[i][0]=a;
            carpet[i][1]=b;
            carpet[i][2]=g;
            carpet[i][3]=k;
        }
        int x=cin.nextInt();
        int y=cin.nextInt();
        int ans=-1;
        for (int i = carpet.length-1; i>=0; i--) {
            if(carpet[i][0]<=x&&carpet[i][0]+carpet[i][2]>=x){
                if(carpet[i][1]<=y&&carpet[i][1]+carpet[i][3]>=y){
                    ans=i+1;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
