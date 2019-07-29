package CometOJ.match;

import java.util.Arrays;
import java.util.Scanner;

public class Contest7_B {
    static int count=0;
    static StringBuffer S=new StringBuffer("");
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        char[] s=cin.nextLine().replace(" ","").toCharArray();
        String ans="12341234";
        while(ans.lastIndexOf(Sapp(s))==-1){
            for (int i = 0,j=-1,k=-1; i < s.length; i++) {
                if(ans.charAt(i)!=s[i]){
                    if(j==-1)
                        j=i;
                    if(k==-1)
                        k=i;
                }
                    swap(s,j,k);

                }
            }
//        }
        System.out.println(count);
        /*
            1234
            1324
            4321
         */
    }

    private static String Sapp(char[] s) {
        for (int i = 0; i < s.length; i++) {
            S.append(s[i]);
        }
        return S.toString();
    }

    private static void swap(char[] s, int i, int j) {
        char tamp=s[i];
        s[i]=s[j];
        s[j]=tamp;
        count++;

    }
}
