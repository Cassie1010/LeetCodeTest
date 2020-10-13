package com.zmm;

import com.zmm.tree.Node;
import com.zmm.tree.base.BaseNodeInterface;
import com.zmm.tree.base.TreeCommonUtil1;
import com.zmm.tree.demo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * @author: zmm
 * @time: 2020/10/10 16:30
 */
public class L103_BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) throws Exception {
        List<List<Integer>> result = new L103_BinaryTreeZigzagLevelOrderTraversal().zigzagLevelOrder(TreeCommonUtil1.deserialize("[1,2,3,null,null,4,5]", TreeNode.class));
        System.out.println(result);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        traverse(stack, result, true);
        return result;
    }

    public void traverse(Stack<TreeNode> stack, List<List<Integer>> result, boolean isLeftFirst){
        Stack<TreeNode> next = new Stack<>();
        List<Integer> data = new ArrayList<>();
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            data.add(node.val);
            if(isLeftFirst && node.left != null)
                next.push(node.left);
            if(node.right != null)
                next.push(node.right);
            if(!isLeftFirst && node.left != null)
                next.push(node.left);
        }
        result.add(data);
        if(!next.isEmpty())
            traverse(next, result, !isLeftFirst);
    }

    //BFS（广度优先遍历）：逐层遍历树
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        // kick off 开始
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while (node_queue.size() > 0) {
            TreeNode curr_node = node_queue.pollFirst();
            if (curr_node != null) {
                if (is_order_left)
                    level_list.addLast(curr_node.val);
                else
                    level_list.addFirst(curr_node.val);

                if (curr_node.left != null)
                    node_queue.addLast(curr_node.left);
                if (curr_node.right != null)
                    node_queue.addLast(curr_node.right);

            } else {
                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();
                // prepare for the next level
                if (node_queue.size() > 0)
                    node_queue.addLast(null);
                is_order_left = !is_order_left;
            }
        }
        return results;
    }

    //DFS （深度优先遍历）
    protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
        if (level >= results.size()) {
            LinkedList<Integer> newLevel = new LinkedList<Integer>();
            newLevel.add(node.val);
            results.add(newLevel);
        } else {
            if (level % 2 == 0)
                results.get(level).add(node.val);
            else
                results.get(level).add(0, node.val);
        }

        if (node.left != null) DFS(node.left, level + 1, results);
        if (node.right != null) DFS(node.right, level + 1, results);
    }

    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        DFS(root, 0, results);
        return results;
    }
}
