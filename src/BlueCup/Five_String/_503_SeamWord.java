package BlueCup.Five_String;

import java.util.Scanner;

/**
变形词:两个串有相同的字符及数量组成 abc abc ,abc cba,aabcd bcada;
给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * 这里规定大小写为不同字符，且考虑字符串中的空格。
给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。
保证两串的长度都小于等于5000。
测试样例：
"Here you are","Are you here"
返回：false
**/
public class _503_SeamWord {
    public static void main(String[] args) {
        Scanner cin =new Scanner(System.in);
        String a=cin.nextLine();
        String b=cin.nextLine();
        //巧解法 加起来 乘起来
        int A1=0,B1=0,A2=1,B2=1;
        for (int i = 0; i < a.length(); i++) {
            A1+=a.charAt(i);
            A2*=a.charAt(i);
        }
        for (int i = 0; i < b.length(); i++) {
            B1+=b.charAt(i);
            B2*=b.charAt(i);
        }
        if(A1==B1&&A2==B2){
            System.out.println("Yes");
        }else
            System.out.println("No");
    }

}
