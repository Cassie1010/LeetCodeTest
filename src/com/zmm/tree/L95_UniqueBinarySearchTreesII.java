package com.zmm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 *
 *
 *
 * 示例：
 *
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 *
 * 提示：
 *
 * 0 <= n <= 8
 *
 * @author: zmm
 * @time: 2020/7/27 9:41
 */
public class L95_UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(1).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(2).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(3).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(4).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(5).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(6).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(7).size());
        System.out.println(new L95_UniqueBinarySearchTreesII().generateTrees(8).size());
    }

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> nodes = new ArrayList<>();
        for(int i = 1; i <= n; i ++){
            int val = i;
            if (nodes.isEmpty()) {
                nodes.add(new TreeNode(val));
            }else{
                List<TreeNode> tempNodes = new ArrayList<>();
                nodes.forEach(node->{
                    //为顶点
                    tempNodes.add(new TreeNode(val, node, null));
                    int rightIndex = 0;
                    TreeNode nodeTop = new TreeNode(node.val, node.left, node.right);
                    TreeNode nodeTemp = nodeTop;
                    while (nodeTemp.right != null){
                        TreeNode top = new TreeNode(node.val, node.left, node.right);
                        TreeNode right = top;
                        for(int a = 0; a <= rightIndex; a++){
                            right.right = new TreeNode(right.right.val, right.right.left, right.right.right);
                            if(a == rightIndex ){
                                right.right = new TreeNode(val, right.right, null);
                                break;
                            }
                            right = right.right;
                        }
                        tempNodes.add(top);
                        rightIndex++;
                        nodeTemp.right = new TreeNode(nodeTemp.right.val, nodeTemp.right.left, nodeTemp.right.right);
                        nodeTemp = nodeTemp.right;
                    }
                    nodeTemp.right = new TreeNode(val);
                    tempNodes.add(nodeTop);
                });
                nodes = tempNodes;
            }
        }
        return nodes;
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
