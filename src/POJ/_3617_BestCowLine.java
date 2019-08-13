package POJ;

import java.util.Scanner;

public class _3617_BestCowLine {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(cin.next());
        }
        f(s, n);
    }

    private static void f(StringBuilder s, int n) {
        String s1 = s.toString();
        String s2 = new StringBuilder(s).reverse().toString();

        int cnt = 0;
        StringBuilder rec = new StringBuilder("");
        while (rec.length() < n) {
            if (s1.compareTo(s2) <=0) {
                rec.append(s1.charAt(0));
                s1=s1.substring(1);
            } else {
                rec.append(s2.charAt(0));
                s2=s2.substring(1);
            }
            if(rec.length()%80==0){
                System.out.println(rec.substring(cnt*80,++cnt*80));
            }
        }
        if(rec.length()>cnt*80){
            System.out.println(rec.substring(cnt*80));
        }
    }
}
