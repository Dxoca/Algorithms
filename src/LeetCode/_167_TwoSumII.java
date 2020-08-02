package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class _167_TwoSumII {
    //图 解法 O(n)
    public int[] twoSum1(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int dif = target - numbers[i];//差值
            if (map.get(dif) != null) {//存在这个数字
                ans[0] = map.get(dif) + 1;
                ans[1] = i + 1;
            }
            map.put(numbers[i], i);//数值和i
        }
        return ans;
    }
    // 双指针
    public int[] twoSum(int[] numbers, int target) {
        int j = 0, k = numbers.length - 1;
        while (j < k) {
            if (numbers[j] + numbers[k] > target) {//当前数字比目标大
                k--;
            } else if (numbers[j] + numbers[k] < target) {//比当前数字小
                j++;
            } else return new int[]{j, k};
        }
        return null;
    }
}
