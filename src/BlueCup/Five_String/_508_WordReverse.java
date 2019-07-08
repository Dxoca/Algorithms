package BlueCup.Five_String;

public class _508_WordReverse {
    public static void main(String[] args) {

        String str = "I'm fine thanks. and you?";//test 1
        String ans = reverse(str);
        System.out.println(ans);

        str = "here you are";//test 2
        ans = reverse(str);
        System.out.println(ans);

    }

    /**
     *
     * @param str
     * @return 翻转后的 单词 不是 翻转字母
     * here you are >> are you here
     */
    private static String reverse(String str) {
        String[] words = str.split("\\s");
        StringBuilder ans = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            if (i != 0) {//最后一个单词后面没有空格
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
