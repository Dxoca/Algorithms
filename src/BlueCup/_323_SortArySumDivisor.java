package BlueCup;
/**
 * @author Dxoca
 * 题7 排序数组中找和和因子
 * 给定已排序数组arr和 k ，不重复打印arr中所有相加和为k的不降序二元组
 * intput：arr = -8 -4 -3 0 2 4 5 8 9 10 K=10
 * output (0,10)(2,8)
 * 最优思路：
 * 首先是有序是  重点  所以类似快排双指针扫描 d
 */
public class _323_SortArySumDivisor {
    public static void main(String[] args) {
        //Initialize(初始化):
        int[] arr ={-8,-4,-3,0,2,4,5,8,9,10};
        int k=10;
        //Solve:
        int left=0,right=arr.length-1;
        while(true){
            if(left>=right){//重合
                break;
            }
            int ans=arr[left]+arr[right];
            if(ans==k) {//符合
                System.out.println(arr[left]+","+arr[right]);
                left++;
                right--;
            }else if(ans<k) {//远左边小 右边大 如果为负数
                left++;//增大ans
            }else
                right--;//见笑ans
        }

    }
}
