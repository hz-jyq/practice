package algorithm;

/**
 * @Author jyq
 * @Date 2022/3/1 14:36
 */
public class sort {

   // static int max = 0;//0 ,9

    public static void main(String[] args) {
        int[] ints = new int[]{4, 2, 3, 6, 5, 1567, 71, 2,78, 1, 55, 2, 22, 23,4};
        //第一次排序
        sort(ints, 0, ints.length - 1);
        System.out.println("111");
       /* int left = i1;
        int right = ints.length-1;
        while (left != right){
            left = sort(ints[0], ints, 0, left-1, true);
            right = sort(ints[left+1], ints, left+1, right, true);
        }
        System.out.println(11);*/
    }

    private static void sort(int[] ints, int left, int right) {
       // int i = -1;
        //内部
        int i,j;
        if (left > right) {
            return;
        }
        i = left;
        j = right;
        boolean flag = true;
        int number = ints[i];
        while (i < j){
            //对比右边
            if (flag) {
                if (number > ints[j]) {
                    ints[i] = ints[j];
                    ints[j] = number;
                    flag = false;
                    ++i;
                } else {
                    flag = true;
                    --j;
                }
                continue;
            }
            if (number < ints[i]) {
                ints[j] = ints[i];
                ints[i] = number;
                --j;
                flag = true;
            } else {
                flag = false;
                ++i;
            }
        }
        sort(ints, left,i-1);
        sort(ints, i+1,right);
     //   System.out.println("111");

    }

}
