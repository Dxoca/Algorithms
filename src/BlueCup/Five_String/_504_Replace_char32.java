package BlueCup.Five_String;


/**
 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，
 并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 测试样例：
 "Mr John Smith”,13
 返回："Mr%20John%20Smith"
 ”Hello  World”,12
 返回：”Hello%20%20World”
 */
public class _504_Replace_char32 {
    public static void main(String[] args) {
        String str="Mr John Smith";
//        System.out.println(replaceSpace(str));//Api解法
       
        replaceSpace(str.toCharArray(),str.length());
    }

    private static void replaceSpace(char[] str, int length) {
        int count=length;//空格个数
        for (int i = 0; i < length; i++) {
            if(str[i]==' ')count+=2;
        }
        char[] x=new char[count];
        for (int i = 0,k=0; i < x.length; i++,k++) {
            if(str[k]==' '){
                x[i]='%';
                x[i+1]='2';
                x[i+2]='0';
                i+=3;//后移三次
                k++;//当前空格已经被替换
            }
            x[i]=str[k];
        }
        System.out.println(new String(x,0,count));
    }

    //API
    private static String replaceSpace(String str) {
        return str.replaceAll("\\s","%20");
    }

}
