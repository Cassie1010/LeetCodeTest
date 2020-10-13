package com.zmm.tree;

import java.util.*;

/**
 * 力扣树题目的辅助工具类
 * @author wjw
 * @date 2020/7/10 23:09
 */
public class TreeUtil<T> {

    /**
     * 贴合力扣输入样例格式的序列化
     * 将二叉树层次遍历序列化为字符串
     * 要注意和普通的bfs模板不同的地方：
     * 1.去掉if(cur.left != null)，要把null也加进来，并append("null,")
     * 2.第一步改造后会在queue的末尾产生多余null值，要去除则需改变while结束条件：记录有效节点数而不是!queue.isEmpty()
     * @param root 根节点
     * @return 序列化字符串
     */
    public static String serialize(Node root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int validNum = 1;   //记录有效节点数
        while (validNum != 0){
            Node cur = queue.poll();
            if (cur != null){
                validNum--;
                sb.append(cur.val);
                queue.offer(cur.left);  //null也加进来
                if (cur.left != null) validNum++;   //null不计入有效节点
                queue.offer(cur.right);  //null也加进来
                if (cur.right != null) validNum++;   //null不计入有效节点
            }else {
                sb.append("null");
            }
            if (validNum != 0) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * 贴合力扣输入样例格式的反序列化
     * 反序列化，用层次遍历字符串序列重构二叉树
     * 遍历一遍，因为字符串是记录了null的，因此肯定是一左一右，树这边，需要用队列记录根节点才知道挂到哪一棵树上
     * @param data
     * @return
     */
    public static Node deserialize(String data) {
        if ("[]".equals(data)) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        Node root = new Node(Integer.parseInt(nodes[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (i < nodes.length){
            Node cur = queue.poll();
            i++;
            if (i < nodes.length && !"null".equals(nodes[i])){
                cur.left = new Node(Integer.parseInt(nodes[i]));
                queue.offer(cur.left);
            }
            i++;
            if (i < nodes.length && !"null".equals(nodes[i])){
                cur.right = new Node(Integer.parseInt(nodes[i]));
                queue.offer(cur.right);
            }
        }
        return root;
    }

    /**
     * 可视化树
     * @param root
     * @param <T>
     */
    public static <T> void printNode(Node<T> root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreeUtil.isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (Node<T> node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }
                if (node.left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(i + i - 1);

                if (node.right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(endgeLines + endgeLines - i);
            }
            System.out.println();
        }
        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static <T> int maxLevel(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }
        return true;
    }

}
