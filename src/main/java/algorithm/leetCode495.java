package algorithm;


/**
 * @Author jyq
 * @Date 2020/7/2 10:07
 */
public class leetCode495 {

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
            int[] ints = new int[]{};
            int number = findPoisonedDuration(ints,10000);
            System.out.println(number);
        }




}
