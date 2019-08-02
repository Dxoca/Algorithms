package CC150;

import java.util.ArrayList;
import java.util.Arrays;

public class _905_字符串全排列 {
    public static void main(String[] args) {
        String A = "ABC";
        System.out.println(solve(A));
        System.out.println(getPermutation(A));
    }

    private static ArrayList<String> solve(String A) {
        ArrayList<String> res = new ArrayList<>();
        int len = A.length();
        res.add(A.charAt(0) + "");//初始化,包含第一个字符

        for (int i = 1; i < len; i++) {//第二个字符插入到前面生成集合的每个元素里
            ArrayList<String> res_new = new ArrayList<>();
            String c = A.charAt(i) + "";//新字符
            //插入到每个字符，形成一个新串
            for (String str : res) {//访问上一趟集合中的每个字符串
                res_new.add(c +""+ str);//前加
                res_new.add(str +""+ c);//后加
                for (int j = 1; j < str.length(); j++) {//中间加
                    res_new.add(str.substring(0, j) + c + str.substring(j));
                }
            }
            res = res_new;//更新
        }
        return res;
    }


    static ArrayList<String> res=new ArrayList<>();//全局变量存储
    public static ArrayList<String> getPermutation(String A){
        char[] arr=A.toCharArray();
        Arrays.sort(arr);
        getPermutationCore(arr,0);
        return res;
    }

    private static void getPermutationCore(char[] arr, int k) {
        if(k==arr.length){//拍好了一中情况
            res.add(new String(arr));
        }
        //从k位置开始的每个字符都尝试放在新排列的k的这个个位置
        for (int i = k; i <arr.length ; i++) {
            swap(arr,k,i);//把后面的每个字符都换到k位
            getPermutationCore(arr,k+1);
            swap(arr,k,i);//回溯
        }
    }

    private static void swap(char[] arr, int k, int i) {
        char tmp=arr[i];
        arr[i]=arr[k];
        arr[k]=tmp;
    }

}
