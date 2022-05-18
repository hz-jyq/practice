package algorithm.leetCode;


import java.util.Arrays;

/**
 * @Author jyq
 * @Date 2020/7/2 10:07
 */
public class LeetCode4 {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     *
     * @param
     * @param
     * @return
     */

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int num = nums1.length + nums2.length;
            int[] num3 = new int[num];
            for (int i = 0; i < num; i++) {
                if (i < nums1.length) {
                    num3[i] = nums1[i];
                } else {
                   int n =  Math.abs(num - i - nums2.length);
                   num3[i] = nums2[n];
                }

            }


            return 0d;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,};
        int[] nums2 = new int[]{3,4};
        int num = nums1.length + nums2.length;
        int[] num3 = new int[num];
        for (int i = 0; i < num; i++) {
            if (i < nums1.length) {
                num3[i] = nums1[i];
            } else {
                int n =  Math.abs(num - i - nums2.length);
                num3[i] = nums2[n];
            }

        }
        System.out.println(num3);
        double result;
        Arrays.sort(num3);
        if(num % 2 == 0){
          double max =  num3[(num /2)];
          double min =  num3[(num /2)];
          result = (max + min) /2;
        }else{
            int ceil =   (int)Math.ceil(num/ 2);
             result =  (num3[ceil]);
        }
        System.out.println(result);
    }

}
