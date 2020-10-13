package com.zmm.tree.base;

import com.zmm.tree.Node;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 力扣树题目的辅助工具类
 * @author wjw
 * @date 2020/7/10 23:09
 */
public class TreeCommonUtil {

    /**
     * 贴合力扣输入样例格式的序列化
     * 将二叉树层次遍历序列化为字符串
     * 要注意和普通的bfs模板不同的地方：
     * 1.去掉if(cur.left != null)，要把null也加进来，并append("null,")
     * 2.第一步改造后会在queue的末尾产生多余null值，要去除则需改变while结束条件：记录有效节点数而不是!queue.isEmpty()
     * @param root 根节点
     * @return 序列化字符串
     */
    public static <T extends BaseNode> String serialize(T root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        Queue<T> queue = new LinkedList<>();
        queue.offer(root);
        int validNum = 1;   //记录有效节点数
        while (validNum != 0){
            T cur = queue.poll();
            if (cur != null){
                validNum--;
                sb.append(cur.val);
                queue.offer((T) cur.left);  //null也加进来
                if (cur.left != null) validNum++;   //null不计入有效节点
                queue.offer((T) cur.right);  //null也加进来
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
    public static <T extends BaseNode> T deserialize(String data, Class<T> tClass) throws Exception {
        if ("[]".equals(data)) return null;
        String[] nodes = data.substring(1, data.length() - 1).split(",");
//        T root = new T(Integer.parseInt(nodes[0]));
//        T root = tClass.newInstance();
//        Constructor<T> constructor = tClass.getConstructor(tClass);
        Constructor con = tClass.getConstructor();
        con.setAccessible(true);
        T root = (T)con.newInstance();
        root.val = Integer.parseInt(nodes[0]);
        Queue<BaseNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 0;
        while (i < nodes.length){
            BaseNode cur = queue.poll();
            i++;
            if (i < nodes.length && !"null".equals(nodes[i])){
//                cur.left = new Node(Integer.parseInt(nodes[i]));
                cur.left = (BaseNode) con.newInstance();
                cur.left.val = Integer.parseInt(nodes[i]);
                queue.offer(cur.left);
            }
            i++;
            if (i < nodes.length && !"null".equals(nodes[i])){
                cur.right = (BaseNode)con.newInstance();
                cur.right.val = Integer.parseInt(nodes[i]);
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
    public static <T extends BaseNode> void printNode(T root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends BaseNode> void printNodeInternal(List<T> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || TreeCommonUtil.isAllElementsNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<T> newNodes = new ArrayList<>();
        for (T node : nodes) {
            if (node != null) {

                System.out.print(((T)node).val);
                newNodes.add((T) node.left);
                newNodes.add((T)node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endgeLines; i++) {
            for (T node : nodes) {
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

    private static <T extends BaseNode> int maxLevel(T node) {
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
