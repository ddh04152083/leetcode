package com.ddh.tree;

/**
 * 二叉树节点
 *
 * @param <T> 数据类型
 */
public class TreeNode<T> {
    public T val;

    public TreeNode left, right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

}
