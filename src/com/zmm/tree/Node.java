package com.zmm.tree;

import com.zmm.tree.base.BaseNodeInterface;

/**
 * 二叉树节点
 * @author wjw
 * @date 2020/7/11 0:57
 */
public class Node<T> implements BaseNodeInterface<Node, T> {
    public Node<T> left, right;
    public T val;
    public Node(){}
    public Node(T val) {
        this.val = val;
    }

    @Override
    public Node getLeft() {
        return left;
    }

    @Override
    public void setLeft(Node left) {
        this.left = left;
    }

    @Override
    public Node getRight() {
        return right;
    }

    @Override
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public T getVal() {
        return val;
    }

    @Override
    public void setVal(T val) {
        this.val = val;
    }
}