package CometOJ;
import java.util.Scanner;

/**
 * @name 骚动时节的少女们
 * @Test https://cometoj.com/contest/46/problem/A?problem_id=2021
 * @Author Dxoca
 */
public class Contest4_A{
    public static void main(String[] args){
        Scanner cin =new Scanner(System.in);
        int n=cin.nextInt();

        for(int i=0;i<n;i++){
            int max=-1;
            int tss=-1;
            int [] x=new int[5];
            for(int j=0;j<5;j++){//input 五个值
                int ans=cin.nextInt();
                x[ans-1]++;
            }
            for(int k=0;k<5;k++){//比较五个数值
                if(x[k]>max){
                    max=x[k];
                    tss=k+1;//票数 最多的min{标号}
                }
            }
            System.out.println(tss);
        }
    }
}