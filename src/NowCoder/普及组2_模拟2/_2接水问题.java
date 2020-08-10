package NowCoder.普及组2_模拟2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class _2接水问题 {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();//队头最小元素
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();//人数
        int m = cin.nextInt();//水龙头数
        int[] q = new int[n];//人
        int time = 0;

        for (int i = 0; i < m; i++) //初始化 优先队列
            heap.add(0);
        for (int i = 0; i < n; i++) {//每个接水的数据输入
            q[i] = cin.nextInt();
        }

        //模拟接水的过程
        for (int i = 0; i < n; i++) {//一次对每个人接水
            int t = heap.peek();//取出最小
            heap.poll();//删除
            heap.add(t + q[i]);//更新
        }
        while (!heap.isEmpty()) {//取出最后一个值 最大值
            time=heap.poll();
        }

        System.out.println(time);
    }
}
