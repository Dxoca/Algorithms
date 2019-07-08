package BlueCup.Five_String;

//旋转词 Rotate 旋转循环
public class _507_TrunWord {
    public static void main(String[] args) {
        String a = "ghijkabc";
        String b = "abcdefghijk";
        //>> b+b 》a
        boolean ans = isRotate(a, b);
        System.out.println(ans);
        boolean anss = isRotates(a, b);
        System.out.println(anss);

    }

    private static boolean isRotates(String a, String b) {
        StringBuilder sb = new StringBuilder(b).append(b);
        for (int i = 0, k = 0; i < sb.length(); i++) {//i是父串 k是子串
            if (a.charAt(k) == sb.charAt(i)) {
                k++;
                if (k == a.length() - 1)//a的所有字符都在sb里面
                    return true;
            } else {
                k = 0;
            }
        }
        return false;
    }

    private static boolean isRotate(String a, String b) {//a 是否是b的旋转词
        //b+b
        StringBuilder sb = new StringBuilder(b).append(b);
        //包含
        return sb.toString().contains(a);
    }
}
