package com.ddh.tree;

import java.util.Stack;

/**
 * 二叉树遍历
 */
public class TreeOrder {


    /**
     * 二叉树前序递归遍历
     *
     * @param treeNode 树节点
     */
    public void preOrder(TreeNode treeNode) {
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 二叉树中序递归遍历
     *
     * @param treeNode 树节点
     */


    public void inOrder(TreeNode treeNode) {
        inOrder(treeNode.left);
        System.out.println(treeNode.val);
        inOrder(treeNode.right);
    }

    /**
     * 二叉树后续递归遍历
     *
     * @param treeNode 树节点
     */
    public void postOrder(TreeNode treeNode) {
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }

    /**
     * 二叉树前序飞递归遍历
     *
     * @param node 根节点
     */
    public void preOder1(TreeNode node) {
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        //跟节点入站栈
        stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            System.out.print(p.val);
            //左子树不为空，左子树入栈
            if (p.left != null) {
                stack.push(p.left);
            }
            //右子树不为空，右子树入栈
            if (p.right != null) {
                stack.push(p.right);
            }
        }

    }


    /**
     * 二叉树中序非递归遍历
     *
     * @param node 树节点
     */
    public void inOrder1(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode tempNode = node;
        Stack<TreeNode> stack = new Stack<>();
        while (tempNode != null || !stack.isEmpty()) {
            //1.将根节点入栈
            //2.将所有左孩子入栈
            while (tempNode != null) {
                stack.push(tempNode);
                tempNode = tempNode.left;
            }
            //3.访问栈顶元素
            tempNode = stack.pop();
            System.out.print(tempNode.val + " ");
            //4.如果栈顶元素存在右孩子，则将右孩子入栈
            if (tempNode.right != null) {
                tempNode = tempNode.right;
                //否则，将临时节点置为空，表示下次访问栈顶元素
            } else {
                tempNode = null;
            }

        }

    }
}
