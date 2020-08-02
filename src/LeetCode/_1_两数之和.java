package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class _1_两数之和 {
    public static void main(String args[]) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
//        System.out.println(Arrays.toString(new _1_两数之和().twoSum1(nums, target)));
        System.out.println(new _1_两数之和().myAtoi("    3.14159"));
    }

    //暴力O(n^2)
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) { // j = i + 1 的目的是减少重复计算和避免两个元素下标相同
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }

            }
        }
        return ans;
    }

    //O(n) HashMap
    public int[] twoSum1(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int dif = target - nums[i];//差值
            if (map.get(dif) != null) {//如果差值存在
                ans[0] = map.get(dif);//差值的value（索引） get
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);//数字做key i坐value

        }
        return ans;

    }

    public int myAtoi(String str) {
        //判断第一个 非空字符
        long res = 0;
        int sin = 1;
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            char t = str.charAt(i);

            if (t >= '0' && t <= '9') {
                if(flag)
                    flag=false;
                res = res * 10 + t - '0';
                if(i+1<str.length()&&(str.charAt(i+1)<'0'|| str.charAt(i+1)>'9'))
                    break;
            }else if (t != ' ' && flag) {//是第一个非空字符
                if (t == '-') {//是负号
                    sin = -1;
                } else
                    sin = 0;

                flag = false;
            }
        }
        res *= sin;
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else return (int) res;

    }

}
