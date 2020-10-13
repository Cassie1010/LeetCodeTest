package com.zmm.tree.base;

import com.zmm.tree.Node;

/**
 * 二叉树节点
 * @author wjw
 * @date 2020/7/11 0:57
 */
public class BaseNode<T> {
    public BaseNode<T> left, right;
    public T val;

    public BaseNode() {
    }

    public BaseNode(T val) {
        this.val = val;
    }

    public T getLeft() {
        return (T) this.left;
    }

    public void setLeft(BaseNode<T> left) {
        this.left = left;
    }

    public T getRight() {
        return (T) right;
    }

    public void setRight(BaseNode<T> right) {
        this.right = right;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }
}