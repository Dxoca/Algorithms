package CometOJ;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int n=cin.nextInt();
        long k=cin.nextLong();
        long count=0;
        long max=-1;
        long min=Long.MAX_VALUE;
        long[][] ans=new long[n][2];
        for (int i = 0; i < n; i++) {
            ans[i][0]=cin.nextInt();
            ans[i][1]=cin.nextInt();
            if(ans[i][0]>max){
                max=ans[i][0];
            }
            if(ans[i][0]<min)
                min=ans[i][0];

            if(ans[i][1]>max){
                max=ans[i][1];

            }
            if(ans[i][1]<min)
                min=ans[i][1];
        }
        long maxcount=-1;
        for (long i = min; i <=max ; i++) {
            if(count>maxcount) {
                maxcount = count;
                count=0;
            }
            for (int j = 0; j < n; j++) {
                if(ans[j][0]>=i&&ans[j][1]>=i){
                    if(ans[j][0]<=i+k&&ans[j][1]<=i+k) {
                        count++;
                    }
                }

            }
        }
        System.out.println(maxcount);

    }
}
