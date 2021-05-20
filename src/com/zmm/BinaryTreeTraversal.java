package com.zmm;

import com.alibaba.fastjson.JSON;
import com.zmm.tree.Node;
import com.zmm.tree.TreeUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树遍历
 * @author: zmm
 * @time: 2021/5/19 10:16
 */
public class BinaryTreeTraversal {
    public static void main(String[] args) {
        Node tree = new Node("A");
        //左根
        Node leftNode = new Node("B");
        tree.setLeft(leftNode);
        Node l1 = new Node("D");
        leftNode.left = l1;
        l1.right = new Node("H");
        Node r1 = new Node("E");
        leftNode.right = r1;
        r1.right = new Node("I");
        //右
        Node rightNode = new Node("C");
        tree.right = rightNode;
        Node l2 = new Node("F");
        rightNode.left = l2;
        rightNode.right = new Node("G");
        l2.left = new Node("J");
        l2.right = new Node(("K"));
        TreeUtil.printNode(tree);
//        System.out.println(JSON.toJSONString(preorderTraversal(tree)));
//        System.out.println(JSON.toJSONString(inorderTraversal(tree)));
        System.out.println(JSON.toJSONString(postorderTraversal(tree)));
    }

    /**
     * 先序遍历：中左右
     * @param node
     * @return
     */
    private static List<Object> preorderTraversal(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        List<Object> result = new ArrayList<>();
        while (!stack.isEmpty()){
            Node n = stack.pop();
            if(n == null){
                continue;
            }
            result.add(n.val);
            stack.push(n.right);
            stack.push(n.left);
        }
        return result;
    }

    /**
     * 中序：左中右
     * @param node
     * @return
     */
    private static List<Object> inorderTraversal(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        List<Object> result = new ArrayList<>();
        while (!stack.isEmpty()){
            Node n = stack.peek();
            if(n == null){
                stack.pop();
                continue;
            }
            if(n.getLeft() == null){
                result.add(n.val);
                stack.pop();
                stack.push(n.right);
            }else{
                stack.push(n.left);
                n.left = null;
            }
        }
        return result;
    }

    /**
     * 后序遍历：左右中
     * @param node
     * @return
     */
    private static List<Object> postorderTraversal(Node node){
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        List<Object> result = new ArrayList<>();
        while (!stack.isEmpty()){
            Node n = stack.peek();
            if(n == null){
                stack.pop();
                continue;
            }
            if(n.left != null || n.right != null) {
                stack.push(n.right);
                stack.push(n.left);
                n.left = null;
                n.right = null;
            }else {
                stack.pop();
                result.add(n.val);
            }
        }
        return result;
    }
}
