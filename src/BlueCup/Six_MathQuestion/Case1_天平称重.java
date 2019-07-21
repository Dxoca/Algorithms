package BlueCup.Six_MathQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Case1_天平称重 {
    //
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        convert(N);//转特殊三进制

    }

    private static void convert(int N) {
        //转换三进制
        final String x = Integer.toString(N, 3);
        //翻转 字符数组 到着算可能越界 所有翻转从左到右
        char[] arr = new StringBuilder(x).reverse().toString().toCharArray();//翻转
        //容器处理之后的 0 -1 1
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]=='2') {
                list.add(0, -1);//-1 插到开头
                if (i == arr.length - 1) {//到尽头
                    list.add(0, 1);//最后一个字符  插入1 因为是尽头 没进位了
                } else {
                    ++arr[i + 1];//否则下一位+1
                }
            }else if(arr[i]=='3'){
                list.add(0,0);
                //更高位进1
                if(i==arr.length-1){
                    list.add(0,1);
                }else{
                    ++arr[i+1];
                }
            }else{
                list.add(0,arr[i]-'0');//不是0、就是1
            }

        }
        StringBuilder sb = new StringBuilder();//注意是逆序 进制
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) sb.append("+").append((int) Math.pow(3, list.size() - i - 1));
            if (list.get(i) == -1) sb.append("-").append((int) Math.pow(3, list.size() - i - 1));
            //0直接pass咯
        }
        //因为结果的第一位一定是 正的 所以我能把它符号丢掉
        System.out.println(sb.substring(1));
    }
}
