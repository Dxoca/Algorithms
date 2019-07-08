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
     * @param str
     * @return 翻转后的 单词 不是 翻转字母
     * here you are >> are you here
     */
    private static String reverse(String str) {
//        String[] words = str.split("\\s");
        String[] words_hand = strsplit(str + " ", ' ');
        StringBuilder ans = new StringBuilder();
        for (int i = words_hand.length - 1; i >= 0; i--) {
            ans.append(words_hand[i]);
            if (i != 0) {//最后一个单词后面没有空格
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    private static String[] strsplit(String str, char s) {
        //str 最后加一个空格 判断
        int k = 0;//单词个数
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == s)
                k++;
        }
        String[] ans = new String[k];
        k = 0;//从0开始放
        StringBuilder tamp = new StringBuilder("");//暂存每个单词
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                tamp.append(str.charAt(i));
            } else {
                ans[k++] = tamp.toString();//存到数组
                tamp.delete(0, tamp.length() - 1);//空格 就删除
            }
        }

        return ans;
    }

}
