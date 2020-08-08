package algorithm;

import java.util.Arrays;

/**
 * @Author jyq
 * @Date 2020/7/2 10:07
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 给定有序数组: [-10,-3,0,5,9,11,15,17]
 *  [1,3,10,50.90]
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -10   5
 *      \   /
 *      -3  9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */

public class leetCode108 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return getTreeNode(nums,0,nums.length-1);
    }

    private static TreeNode  getTreeNode(int[] nums, int left, int right){
        int length = nums.length;
        TreeNode treeNode;
        if(length == 0){
            return null;
        }
        if((length / 2) % 2 != 0){
            treeNode = new TreeNode(nums[length/2] + 1);
        }else{
            treeNode = new TreeNode(nums[length/2]);
        }
        treeNode.left = getTreeNode( Arrays.copyOfRange(nums,0,length/2),0,length/2);
        treeNode.right = getTreeNode(Arrays.copyOfRange(nums,length/2,length-1),length/2,length);
        return  treeNode;
    }

    public static void main(String[] args) {
        int[] ints  = new  int[]{-10,-3,0,5,9,11,15,17};
        sortedArrayToBST(ints);
    }




}
