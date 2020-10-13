package com.zmm.tree.demo;

//import main.Node;
//import main.TreeUtil;
//import org.junit.Test;

import com.zmm.tree.base.BaseNode;
import com.zmm.tree.base.BaseNodeInterface;
import com.zmm.tree.base.TreeCommonUtil;
import com.zmm.tree.base.TreeCommonUtil1;

import java.util.ArrayList;
import java.util.List;

/**
 * 以力扣94题中序遍历为例，展示该工具类的使用方法
 * 原题链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @author wjw
 * @date 2020/9/17 10:01
 */
public class LeetCodeUsageDemo {

    public static void main(String[] args) throws Exception {
        new LeetCodeUsageDemo().test();
    }

//    @Test
    public void test() throws Exception {
        TreeNode root = TreeCommonUtil1.deserialize("[1,null,2,3]", TreeNode.class);//====第二步，本地ide调试题目时可以直接采用力扣格式的输入样例
        TreeCommonUtil1.printNode(root);   //===========第三步，可以在递归或迭代或者其他想要观察树的过程中调用该方法，可以可视化当前树的结构
        List<Integer> result = inorderTraversal(root);
        System.out.println(result);
    }


    /**
     * 递归做法
     */
    List<Integer> re = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root != null){
            inorderTraversal(root.left);
            re.add(root.val);
            inorderTraversal(root.right);
        }
        return re;
    }

}
