package BlueCup.Five_String;

import java.util.HashMap;
import java.util.Map;

//判断两个字符串的 字符集 是否相同
public class _506_HasSameCharSet {
    public static void main(String[] args) {
        boolean ans = check("abscdesff", "abcdees");//后面的字符是不是前面的子集
        System.out.println(ans);
    }

    private static boolean check(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (map.get(c) == null)
                map.put(c, 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (map.get(c) == null)
                return false;
        }
        return true;
    }
}
