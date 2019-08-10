package CometOJ._8_;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        int n=cin.nextInt();
        String min=cin.next();
        String t;
        for (int i = 0; i < n-1; i++) {
            t=cin.next();
           if(min.compareTo(t)>0){
               min=t;
           }
        }
        System.out.println(min);
    }
}
