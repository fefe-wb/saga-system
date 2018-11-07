package com.wb.system.util.algorithm;

import java.util.Stack;

public class BinaryTree1 {

    private TreeNode root;

    /**
     *       A
     *    B    C
     *  D  E  F  G
     */
    public void createBTree() {
        root = new TreeNode("root A");
        root.leftChild = new TreeNode("B");
        root.rightChild = new TreeNode("C");
        root.leftChild.leftChild = new TreeNode("D");
        root.leftChild.rightChild = new TreeNode("E");
        root.rightChild.leftChild = new TreeNode("F");
        root.rightChild.rightChild = new TreeNode("G");
    }

    private class TreeNode {
        private String data;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(String data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }
    }

    public void printNode(TreeNode node) {
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        BinaryTree1 binaryTree = new BinaryTree1();
        binaryTree.createBTree();
        System.out.println("----------递归前序遍历-----------");
        binaryTree.preOrder(binaryTree.root);
        System.out.println("----------非递归前序遍历-----------");
        binaryTree.nonRecPreOrder(binaryTree.root);
        System.out.println("----------递归中序遍历-----------");
        binaryTree.inOrder(binaryTree.root);
        System.out.println("----------非递归中序遍历-----------");
        binaryTree.nonRecInOrder(binaryTree.root);
        System.out.println("----------递归后序遍历-----------");
        binaryTree.afterOrder(binaryTree.root);
        System.out.println("----------非递归后序遍历-----------");
        binaryTree.nonRecAfterOrder(binaryTree.root);
        System.out.println("----------树的深度-----------");
        System.out.println(binaryTree.getMaxDepth(binaryTree.root));
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        printNode(root);
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void nonRecPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                printNode(node);
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.leftChild);
        printNode(root);
        inOrder(root.rightChild);
    }

    public void nonRecInOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                printNode(node);
                node = node.rightChild;
            }
        }
    }

    public void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(root.leftChild);
        afterOrder(root.rightChild);
        printNode(root);
    }

    public void nonRecAfterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> tempStack = new Stack<TreeNode>();
        Stack<TreeNode> outPutStack = new Stack<TreeNode>();
        while (node != null || !tempStack.isEmpty()) {
            while (node != null) {
                tempStack.push(node);
                outPutStack.push(node);
                node = node.rightChild;
            }
            if (!tempStack.isEmpty()) {
                node = tempStack.pop();
                node = node.leftChild;
            }
        }
        while (!outPutStack.isEmpty()) {
            node = outPutStack.pop();
            printNode(node);
        }
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left = getMaxDepth(root.leftChild);
            int right = getMaxDepth(root.rightChild);
            return 1 + Math.max(left, right);
        }
    }
}
