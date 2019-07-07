package BlueCup.Five_String;
/**
 利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。
 比如，字符串“aabcccccaaa”经压缩会变成“a2b1c5a3”。
 若压缩后的字符串没有变短，则返回原先的字符串。
 给定一个string iniString为待压缩的串(长度小于等于10000)，
 保证串内字符均由大小写英文字母组成，返回一个string，为所求的压缩后或未变化的串。
 测试样例
 "aabcccccaaa"
 返回："a2b1c5a3"
 */
public class _505_Zipper {
    public static void main(String[] args) {
        String str ="aabcccccsaaaaabcccc";
        String ans=zipper(str);
        System.out.println(ans);
    }

    private static String zipper(String str) {
        char tamp=str.charAt(0);//先从第一个开始比较
        StringBuilder ans=new StringBuilder();
        int count=0;
        for (int i = 0; i < str.length(); i++) {
            if(tamp==str.charAt(i)){
                count++;//计数
            }else {
                ans.append(tamp).append(count);
//                System.out.print(tamp + "" + count);
                tamp = str.charAt(i);
                i--;//把i固定到当前tamp （因为马上还要i++）
                count = 0;//恢复
            }
            if(i==str.length()-1){//特判 最后一次 直接输出 防止 循环结束执行不到
//                System.out.print(tamp + "" + count);
                ans.append(tamp).append(count);
            }
        }
        return ans.toString();
    }
}
