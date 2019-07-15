package HihoCoder;

import java.util.Scanner;
//https://hihocoder.com/problemset/problem/1485?sid=1507688
/**
 * hiho字符串 尺取法
 * @author Dxoca
 * @time 2019年7月15日 22:52:14
 * 蓝桥 5.19 String
 */
public class _1485_hihoString {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int ans=Solve(cin.nextLine());
        System.out.println(ans);
    }
    static int min=Integer.MAX_VALUE;
    private static int Solve(String s) {
        int ans;
        for (int i = 0; i < s.length(); i++) {
            if(check(s,i)) {
                 ans = checkShort(s, i);
                if (ans != -1) {//符合
                    if (ans < min) min = ans;
                }
            }
        }
        if (min==Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }

    private static int checkShort(String s, int i) {
        int j=i;//1,2,3,4,5,
        int H=0,I=0,O=0;//h两个
        while (H<=2&&I<=1&&O<=1&&j<s.length()){
            if(s.charAt(j)=='h') H++;
            if(s.charAt(j)=='i') I++;
            if(s.charAt(j)=='o') O++;

            if(H==2&&I==1&&O==1){
                return j-i+1;//hahaio
            }
            j++;
        }
        return -1;

    }

    private static boolean check(String s,int i) {
        if(s.charAt(i)=='h'|s.charAt(i)=='i'|s.charAt(i)=='o'){
            return true;
        }
        return false;
    }
}
