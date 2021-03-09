package com.zmm.tree;

//import org.junit.Test;

/**
 * @author wjw
 * @date 2020/9/17 9:50
 */
public class PrintTreeDemo {

    public static void main(String[] args) {
        new PrintTreeDemo().test();
    }

    //    @Test
    public void test() {
        Node<String> root = new Node<>("A");
        root.left = new Node<>("B");
        root.right = new Node<>("C");
        root.left.left = new Node<>("D");
        root.left.right = new Node<>("E");
        root.left.right.left = new Node<>("F");
        TreeUtil.printNode(root);
    }
}
