package BlueCup.Six_MathQuestion;

import java.util.HashMap;
import java.util.Map;
//注意点 不要丢了 <= num 和 i从2开始。
public class _612_素数测试 {
    /**
     * 判断是否是素数模板
     *
     * @param num
     * @return
     */
    public static boolean inPrime(long num) {
        for (int i = 2; i * i <= num; i++)
            if (num % i == 0) return false;
        return true;
    }

    /**
     * 任何整数质因数分解是唯一的
     *
     * @param num
     * @return
     */
    public static Map<Integer, Integer> pirmeFactor(int num) {
        Map<Integer, Integer> map = new HashMap<>();//质因数，出现次数
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                Integer v = map.get(i);
                if (v == null)
                    map.put(i, 1);
                else
                    map.put(i, v + 1);
                num /= i;
            }
        }
        return map;
    }

    public static void main(String[] args) {
        boolean res=inPrime(7L);
        System.out.println(res);
        System.out.println(pirmeFactor(100));
        //遍历map
        Map<Integer,Integer> map=pirmeFactor(100);//质因数 出现的次数
        StringBuilder sb=new StringBuilder();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int k=entry.getKey();
            int v=entry.getValue();
            for (int i = 0; i < v; i++) {
                sb.append("*"+k);
            }
        }
        System.out.println(sb.substring(1));//从第一个字符开始

    }
}
