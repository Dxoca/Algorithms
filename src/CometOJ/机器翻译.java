package CometOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 机器翻译 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        Scanner cin =new Scanner(System.in);
        int m=cin.nextInt();
        int n= cin.nextInt();
        int res=0;
        boolean[] st=new boolean[1001];//缓存
        for (int i = 0; i < n; i++) {
            int x=cin.nextInt();
            if (!st[x]){//存在
                if(q.size()==m){
                    int t=q.peek();//返回第一个
                    st[t]=false;
                    q.poll();//删除第一个
                }
                q.offer(x);
                st[x]=true;
                res++;
            }

        }
        System.out.println(res);
    }
}
