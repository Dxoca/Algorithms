package BlueCup;

public class _329_ContainsAll {
    //判断数组的包含问题
    //串b中是否包含串a的全部字符
    //判断字符串a中的字符是否全部出现在串b中
    public static void main(String[] args) {
        System.out.println(cheack("123","ffsfds1234"));
    }
    public static boolean cheack(String s1,String s2){
        for (int i = 0; i < s1.length(); i++) {
            char a=s1.charAt(i);
            if(s2.indexOf(a)==-1){
                return false;
            }
        }
        return true;
    }
}
