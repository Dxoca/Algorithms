package LeetCode;

public class _60_第k个排列 {
    public static void main(String[] args) {
        String s = "123";
        permutation("", s.toCharArray());//从空串
    }


    final static int k = 3;//我们要求的第几个字典序的排列
    static int count = 0;

    private static void
    permutation(String prefix, char[] arr) {
        if (prefix.length() == arr.length) {//前缀长度=字符集长度 一个排列完成
            count++;
        }
        if (count == k) {
            System.out.println(prefix);
            System.exit(0);
        }
        //每次都从头扫描，只要扫该字符可用，我们就附加前缀后面，前缀变长
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            //这个字符可用：pre中出现的次数<在字符集中出现的次数
            if (count(prefix, ch) < count(arr, ch)) {
                permutation(prefix + ch, arr);
            }
        }
    }

    private static int count(String prefix, char ch) {
        int cnt = 0;
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) == ch) cnt++;
        }
        return cnt;
    }

    private static int count(char[] arr, char ch) {
        int cnt = 0;
        for (char c : arr) {
            if (c == ch) cnt++;
        }
        return cnt;
    }
}

