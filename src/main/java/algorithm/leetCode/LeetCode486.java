package algorithm.leetCode;

/**
 * @Author jyq
 * @Date 2022/4/26 15:28
 */
public class LeetCode486 {

    /**
     * 给你一个整数数组 nums 。玩家 1 和玩家 2 基于这个数组设计了一个游戏。
     *
     * 玩家 1 和玩家 2 轮流进行自己的回合，玩家 1 先手。开始时，两个玩家的初始分值都是 0 。每一回合，玩家从数组的任意一端取一个数字（即，nums[0] 或 nums[nums.length - 1]），取到的数字将会从数组中移除（数组长度减 1 ）。玩家选中的数字将会加到他的得分上。当数组中没有剩余数字可取时，游戏结束。
     *
     * 如果玩家 1 能成为赢家，返回 true 。如果两个玩家得分相等，同样认为玩家 1 是游戏的赢家，也返回 true 。你可以假设每个玩家的玩法都会使他的分数最大化。
     *
     *  
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/predict-the-winner
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */

   static int i,j = 0 ;

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,6,7,8};
        predictTheWinner(nums);
       /* (2*3)  + 1;
        2 3 * 1 +*/

    }

    public static boolean predictTheWinner(int[] nums) {
        int[][] ints = new int[nums.length][nums.length];
        dfs(ints,0,nums.length-1,nums);
        //动态规划
        int i = dfs(ints,nums.length - 1,0,nums);
        return false;
    }


    private static int dfs( int[][] ints,int right,int left,int[] nums){
        if(right == left){
            return nums[left];
        }
        if(left == 0 && right == nums.length ){
            ints[0][0] = left;
            ints[0][1] = right;
        }
        i =  dfs(ints,left++,right,nums) + ints[i--][0];
        i =  dfs(ints,left,right--,nums) + ints[i--][1];
        return 0;
    }

    /**
     *
     * @param a
     * @param b
     * @param left
     * @param right
     * @param flag
     * @param player
     * @param nums
     * @return
     */
    public static boolean choose(int a,int b,int left,int right,boolean flag,boolean player,int[] nums){
        //数据
        if(right == left){
            return a > b;
        }
        if (flag){

        }else{

        }
     return  false;
    }
}
