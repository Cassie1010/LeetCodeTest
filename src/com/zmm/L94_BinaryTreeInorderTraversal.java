package com.zmm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author: zmm
 * @time: 2020/7/24 10:28
 * 中序遍历，左中右
 */
public class L94_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //递归
//        traverse(root, result);
        //迭代-使用栈
//        TreeNode curr = root;
//        useStack(result, curr);
        //迭代-使用莫里斯遍历
//        useMoris(result, curr);
        //颜色标记法
        Stack<SignNode> stack = new Stack<>();
        stack.push(new SignNode(root, 0));
        SignNode signNode = null;
        while (!stack.isEmpty()){
            signNode = stack.pop();
            if(signNode.node != null){
                if(signNode.color == 0){
                    //中序遍历：左中右
                    stack.push(new SignNode(signNode.node.right, 0));
                    signNode.color = 1;
                    stack.push(signNode);
                    stack.push(new SignNode(signNode.node.left, 0));
                }else{
                    result.add(signNode.node.val);
                }
            }
        }
        return result;
    }

    class SignNode{
        TreeNode node;
        int color;//0:白色未访问过，1：灰色访问过

        public SignNode(TreeNode node, int color) {
            this.node = node;
            this.color = color;
        }
    }

    /**
     * 使用莫里斯遍历-迭代
     * @param result
     * @param curr
     */
    private void useMoris(List<Integer> result, TreeNode curr) {
        TreeNode pre = null;
        while (curr != null){
            if(curr.left == null){
                result.add(curr.val);
                curr = curr.right;
            }else{
                pre = curr.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = curr;
                curr = curr.left;
                pre.right.left = null;
            }
        }
    }

    /**
     * 使用栈遍历-迭代
     * @param result
     * @param curr
     */
    private void useStack(List<Integer> result, TreeNode curr) {
        Stack<TreeNode> stack = new Stack<>();
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
    }

    //递归
    public void traverse(TreeNode curr, List<Integer> result){
        if(curr != null){
            traverse(curr.left, result);
            result.add(curr.val);
            traverse(curr.right, result);
        }
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
