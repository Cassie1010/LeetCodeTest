package com.zmm.tree.demo;

//import org.junit.Test;

import com.zmm.tree.Node;
import com.zmm.tree.TreeUtil;
import com.zmm.tree.base.TreeCommonUtil;
import com.zmm.tree.base.TreeCommonUtil1;

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
        TreeCommonUtil1.printNode(root);
        TreeUtil.printNode(root);
    }
}
