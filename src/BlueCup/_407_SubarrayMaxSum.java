package BlueCup;

public class _407_SubarrayMaxSum {
    //返回 子数组最大累加和//负数丢弃 正数保留。
    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 5, -2, 6, -1};
        int ans = check(arr);
        System.out.println(ans);
    }
     static int check(int[] arr) {
        //负数丢弃 正数保留。
        int ans = 0;
        int sum = arr[0], max = sum;
        int left = 0, right = 0;
        for (int i = 1; i < arr.length; i++) {//从第二个数字开始 第一个数字给max了
            if (sum >= 0) {
                sum += arr[i];//和大于0
            } else {//否则小雨 0  前面都抛弃不要了
                sum = arr[i];
                left = i;//丢弃 前部分的时候 更新left
            }
            if (sum > max) {
                max = sum;
                right = i;//更新max的时候 更新 right
            }
        }
        System.out.println(left+","+right);//索引
        return max;
    }

}
