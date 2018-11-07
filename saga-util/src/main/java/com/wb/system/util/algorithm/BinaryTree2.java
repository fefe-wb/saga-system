package com.wb.system.util.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree2 {
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
        BinaryTree2 binaryTree = new BinaryTree2();
        binaryTree.createBTree();
        System.out.println("----------节点个数-----------");
        System.out.println(binaryTree.numberOfLeafs(binaryTree.root));
        System.out.println("----------递归前序遍历-----------");
//        binaryTree.preOrder(binaryTree.root);
        System.out.println("----------非递归前序遍历-----------");
        binaryTree.nonRecPreOrder(binaryTree.root);
        System.out.println("----------递归中序遍历-----------");
//        binaryTree.inOrder(binaryTree.root);
        System.out.println("----------非递归中序遍历-----------");
        binaryTree.nonRecInOrder(binaryTree.root);
//        System.out.println("----------递归后序遍历-----------");
//        binaryTree.afterOrder(binaryTree.root);
        System.out.println("----------非递归后序遍历-----------");
        binaryTree.nonRecAfterOrder(binaryTree.root);
//        System.out.println("----------树的深度-----------");
//        System.out.println(binaryTree.getMaxDepth(binaryTree.root));

        System.out.println("----------层序遍历-----------");
        binaryTree.levelOrder(binaryTree.root);

    }

    public void nonRecPreOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (node != null || !stack.isEmpty() ) {
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

    public void nonRecAfterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Stack<TreeNode> tempStack = new Stack<TreeNode>();
        Stack<TreeNode> outStack = new Stack<TreeNode>();
        while (node!= null || !tempStack.isEmpty()) {
            while (node!=null) {
                tempStack.push(node);
                outStack.push(node);
                node = node.rightChild;
            }
            if (!tempStack.isEmpty()) {
                node = tempStack.pop();
                node = node.leftChild;
            }
        }
        while (!outStack.isEmpty()) {
            node = outStack.pop();
            printNode(node);
        }
    }

    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            printNode(node);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
    }

    public void levelOrder1(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode current = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            printNode(current);
            if (current.leftChild != null) {
                queue.add(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.add(current.rightChild);
            }
        }
    }

    public int numberOfLeafs(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.leftChild == null && root.rightChild == null) {
            return 1;
        } else {
            return numberOfLeafs(root.leftChild) + numberOfLeafs(root.rightChild);
        }
    }
}
