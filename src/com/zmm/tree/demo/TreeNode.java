package com.zmm.tree.demo;

import com.zmm.tree.base.BaseNodeInterface;

/**
 * @author: zmm
 * @time: 2020/10/10 16:35
 */
public class TreeNode implements BaseNodeInterface<TreeNode, Integer> {
        public int val;
        public TreeNode left;
        public TreeNode right;
    public TreeNode(){
            super();
            }
    public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
            }

    @Override
    public Integer getVal() {
            return val;
            }

    @Override
    public void setVal(Integer val) {
            this.val = val;
            }

    @Override
    public TreeNode getLeft() {
            return left;
            }

    @Override
    public void setLeft(TreeNode left) {
            this.left = left;
            }

    @Override
    public TreeNode getRight() {
            return right;
            }

    @Override
    public void setRight(TreeNode right) {
            this.right = right;
            }
}
