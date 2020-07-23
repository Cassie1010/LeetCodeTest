package com.zmm;

//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
// 示例:
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
//
// Related Topics 树 深度优先搜索
public class L108_ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        TreeNode node = new L108_ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(node);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode topNode = null;
        if(nums != null && nums.length > 0){
            int length = nums.length;
            topNode = sortedArrayToBST(nums, 0, length - 1);
        }
        return topNode;
    }
    public TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        TreeNode topNode = null;
        if(startIndex > endIndex){
            return topNode;
        }
        int topIndex = (startIndex + endIndex)/2 + ((startIndex + endIndex)%2 == 0 ? 0 : 1);
        topNode = new TreeNode(nums[topIndex]);
        topNode.left = sortedArrayToBST(nums, startIndex, topIndex - 1);
        topNode.right = sortedArrayToBST(nums, topIndex + 1, endIndex);
        return topNode;
    }
    public TreeNode sortedArrayToBST1(int[] nums) {
        TreeNode topNode = null;
        if(nums != null && nums.length > 0){
            int length = nums.length;
            if(length == 1){
                topNode = new TreeNode(nums[0]);
                return topNode;
            }
            int topIndex = length/2;
            topNode = new TreeNode(nums[topIndex]);
            if(topIndex > 0){
                int[] leftNums = new int[topIndex];
                System.arraycopy(nums, 0, leftNums, 0, topIndex);
                topNode.left = sortedArrayToBST(leftNums);
            }
            if(topIndex < length - 1){
                int[] rightNums = new int[length - topIndex - 1];
                System.arraycopy(nums, topIndex + 1, rightNums, 0, length - topIndex - 1);
                topNode.right = sortedArrayToBST(rightNums);
            }
        }
        return topNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
}
