package algorithm.leetCode;


/**
 * @Author jyq
 * @Date 2020/7/2 10:07
 */
public class LeetCode3 {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     * @param timeSeries
     * @param duration
     * @return
     */

    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return  0;
        }
        //中毒时间
        int toatal = 0;
        int n = timeSeries.length-1;
        for(int i=0;i<n;i++){
            if(timeSeries[i+1] > duration + timeSeries[i]){
                toatal += duration;
            }else {
                toatal += timeSeries[i+1] - timeSeries[i];
            }
        }
        return  toatal + duration;
    }


        public static void main(String[] args) {
            String s = "";
            String result = "";
            for(int i = 0 ;i < s.length();i++){
              String str1 =  getStringMax(s,i);
              if(str1.length() > result.length()){
                    result = str1;
              }
            }
            System.out.println(result.length());
            //return result.length();
        }


    public static String  getStringMax(String str, int j){
        String  str1 = "";
        for(;j < str.length();j++){
            boolean flag = str1.contains(str.substring(j,j+1));
            if(flag){
                break;
            }
            str1 += str.substring(j,j+1);

        }
        return str1;
  }

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            return 0;
        }
    }



}
