package LeetCode;

public class _5483整理字符串 {
}

class Solution {

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        checkStr(sb);
        return sb.toString();
    }

    private void checkStr(StringBuilder sb) {
        if (sb.length() <= 1) return;
        for (int i = 0; i < sb.length() - 1; ) {
            if (Math.abs(sb.charAt(i) - sb.charAt(i + 1)) == ' ') {
                sb.delete(i, i + 2);//删除
                if (i > 0) ;
                i--;
            } else
                i++;
        }
    }
}