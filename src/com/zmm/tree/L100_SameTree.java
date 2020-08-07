package com.zmm.tree;

import java.util.Stack;

/**
 * 100. 相同的树
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 * @author: zmm
 * @time: 2020/8/7 10:21
 */
public class L100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[]{p, q});
        while (!stack.isEmpty()){
            TreeNode[] nodes = stack.pop();
            if(nodes[0] == null && nodes[1] == null){
                continue;
            }else if(nodes[0] != null && nodes[1] != null && nodes[0].val == nodes[1].val) {
                stack.push(new TreeNode[]{nodes[0].left, nodes[1].left});
                stack.push(new TreeNode[]{nodes[0].right, nodes[1].right});
            }else
                return false;
        }
        return true;
    }

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
}
