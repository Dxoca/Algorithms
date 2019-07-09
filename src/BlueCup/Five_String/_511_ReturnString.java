package BlueCup.Five_String;

public class _511_ReturnString {
    public static void main(String[] args) {
        String str="abcddcba";//abcddcba >ok
        boolean ans = solve(str);
        System.out.println(ans);
    }

    private static boolean solve(String str) {
//        if(str.isEmpty()) return true; 空串判断 但是 在for已包括
        for (int i = 0; i < str.length()/2; i++)
            if(str.charAt(i)!=str.charAt((str.length()-i-1)))//第一个和最后一个比较
                return false;
        return true;
    }
}
