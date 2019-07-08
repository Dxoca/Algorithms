package BlueCup.Five_String;

public class _509_RemoveKZeros {
    //移除字符串中连续出现的k个0
    //可以扫描字符数组的解法，但是用正则表达式更为快捷键
    public static void main(String[] args) {
        String inStr = "A00000B00"; //A_00B00
        int k = 3;
        String ans = remove(inStr, k);
        System.out.println(ans);
        //++++
        String ans2 = remove2(inStr, k);
        System.out.println(ans2);
    }

    /**
     * 字符数组处理
     */
    private static String remove2(String inStr, int k) {
        StringBuilder ans=new StringBuilder();
        int s=0;
        for (int i = 0,z=0; i < inStr.length(); i++) {
            ans.append(inStr.charAt(i));
            if (inStr.charAt(i)=='0'){
                ++z;
                if(z==k){//k个目标达到 从这里到之前k全部替换
                    s=i;//是 要删除的索引 从i往前 k个 (即z>0)
                    while(z-->0) {
                        ans.deleteCharAt(s--);//remove2 中 删除 1中 替换为加 都是ok的。
                    }
                }
            }else
                z=0;//不连续
        }
        return  ans.toString();
    }

    /**
     * 正则表达式替 换
     */
    private static String remove(String inStr, int k) {
        String regepx = "0{" + k + "}";//正则表达式 > k个0
        return inStr.replaceAll(regepx, "+");

    }
}
