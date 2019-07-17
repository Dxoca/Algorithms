package PAT;
import java.util.Scanner;

public class PAT_Basic_1001 {
    public static void main(String[] args){
        Scanner cin =new Scanner(System.in);
        int n=cin.nextInt();
        for(long i=0;i<n;i++){//long 不用int,
            long a=cin.nextLong(),b=cin.nextLong(),c=cin.nextLong();
            boolean ans=false;
            if(a>c-b){//思维转换 让数据变小 保险 不会超过最大value
                ans=true;
            }
            System.out.println("Case #"+(i+1)+": "+ans);
        }
    }
}
