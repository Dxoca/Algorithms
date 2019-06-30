package LuoGu;

import java.util.Scanner;

public class P1618 {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int a=cin.nextInt(),b=cin.nextInt(),c=cin.nextInt();
//        int t=gcd(gcd(a,b),gcd(b,c));
//        int t=maxg(a,b,c);
//
//        a/=t;
//        b/=t;
//        c/=t;
        boolean have=true;
        for(int i=1;i<=123*c;i++){//从1 开始
            String ans =i*a+" "+i*b+" "+i*c;//max.length=3+1+3+1+3=9+2=11
            if(check(ans)){
                System.out.println(ans);
                have=false;
            }
        }
        if(have){
            System.out.println("No!!!");
        }
    }

    private static int maxg(int a, int b, int c) {
        int i=c;
        for(;(a%i!=0)|(b%i!=0)|(c%i!=0);i--){}//同时被三个数整除
        return i;
    }

    public static int gcd(int a,int b)     //为了让输入的A B C互质
    {
        return a%b==0?gcd(b,a%b):b;
    }
    private static boolean check(String ans) {//123 456 789 =11
        if(ans.length()>11) return false;//超过九位数
        int [] count=new int [10];//1~9 >0~9
        int add=0,ams=1;
        for (int i=0;i<ans.length();i++){//注意 索引 0~10 字符串完全遍历一遍>11
            if(ans.charAt(i)!=' ') {//排除空格
                add += ans.charAt(i) - '0';
                ams *= ans.charAt(i) - '0';
            }
//            if(ans.charAt(i)=='0') return false;
//            if(ans.charAt(i)!=' '){//排除空格
//                count[ans.charAt(i)-'0']++;
//                if(count[ans.charAt(i)-'0']>1)//先计数后判断 是否超过一个
//                    return false;
//            }
        }
        if(add==45&&ams==362880){
            return true;

        }
        return false;
        //true;
    }
}
//1 2 4
//No!!!
//123 456 789
//41:2
//123 456 789