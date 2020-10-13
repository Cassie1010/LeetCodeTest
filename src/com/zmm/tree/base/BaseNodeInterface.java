package com.zmm.tree.base;

/**
 * 二叉树节点
 * @author wjw
 * @date 2020/7/11 0:57
 */
public interface BaseNodeInterface<T, V> {

    T getLeft();

    void setLeft(T left);

    T getRight();

    void setRight(T right);

    V getVal();

    void setVal(V val);
}