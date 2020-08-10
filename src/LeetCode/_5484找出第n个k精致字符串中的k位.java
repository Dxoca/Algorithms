package LeetCode;

public class _5484找出第n个k精致字符串中的k位 {
}

class Solutions {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");//s1
        StringBuilder t;
        for (int i = 2; i <= n; i++) {//s2开始
            t = sb;//暂存
            t = invert(t).reverse();//翻转
            sb.append("1" + t);
        }
        return sb.charAt(k-1);
    }

    private StringBuilder invert(StringBuilder sb) {
        char[] s = sb.toString().toCharArray();
        for (int i = 0; i < sb.length(); i++) {
            if (s[i] == '1') s[i] = '0';
            else s[i] = '1';
        }
        return new StringBuilder(new String(s));
    }
}