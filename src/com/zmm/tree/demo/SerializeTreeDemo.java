package com.zmm.tree.demo;

/*
import main.Node;
import main.TreeUtil;
import org.junit.Test;
*/

import com.zmm.tree.Node;
import com.zmm.tree.TreeUtil;
import com.zmm.tree.base.TreeCommonUtil;
import com.zmm.tree.base.TreeCommonUtil1;

/**
 * @author wjw
 * @date 2020/9/17 10:24
 */
public class SerializeTreeDemo {

    public static void main(String[] args) throws Exception {
        new SerializeTreeDemo().test();
    }

//    @Test
    public void test() throws Exception {
        Node<Integer> root = new Node<>(1);
        root.left = new Node<>(2);
        root.right = new Node<>(3);
        root.right.left = new Node<>(4);
        root.right.right = new Node<>(5);
        String res = TreeCommonUtil1.serialize(root);  //序列化为字符串测试
        System.out.println(res);
        String res1 = TreeUtil.serialize(root);  //序列化为字符串测试
        System.out.println(res1);
        Node tree = TreeCommonUtil1.deserialize("[1,2,3,null,null,4,5]", Node.class);  //反序列化为树测试
        TreeCommonUtil1.printNode(tree);   //打印看反序列化后的树的结构
        Node tree1 = TreeUtil.deserialize("[1,2,3,null,null,4,5]");  //反序列化为树测试
        TreeUtil.printNode(tree1);   //打印看反序列化后的树的结构
    }
}
