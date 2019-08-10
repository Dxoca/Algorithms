package BlueCup.Seven_recursion.Test;

public class 振兴中华 {
    public static void main(String[] args) {
        int [][] ans =new int [4][5];
        for (int i = 0; i < ans.length; i++) {//4
            ans[i][0]=1;
        }for (int j = 0; j < ans[0].length; j++) {
            ans[0][j]=1;
        }
        for (int i = 1; i <ans.length; i++) {
            for (int j = 1; j < ans[0].length; j++) {
               ans[i][j]=ans[i-1][j]+ans[i][j-1];
            }
        }
        System.out.println(ans[3][4]);
    }
}
