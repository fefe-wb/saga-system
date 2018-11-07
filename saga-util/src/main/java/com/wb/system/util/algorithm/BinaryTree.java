package com.wb.system.util.algorithm;

import java.util.Stack;

public class BinaryTree {

    private TreeNode root = null;

    public BinaryTree(){
        root=new TreeNode(1,"rootNode(A)");
    }

    /**
     * 创建一棵二叉树
     * <pre>
     *           A
     *     B          C
     *  D     E    F      G
     *  </pre>
     * @param root
     * @author WWX
     */
    public void createBinTree(TreeNode root){
        TreeNode newNodeB = new TreeNode(2,"B");
        TreeNode newNodeC = new TreeNode(3,"C");
        TreeNode newNodeD = new TreeNode(4,"D");
        TreeNode newNodeE = new TreeNode(5,"E");
        TreeNode newNodeF = new TreeNode(6,"F");
        TreeNode newNodeG = new TreeNode(7,"G");
        root.leftChild=newNodeB;
        root.rightChild=newNodeC;
        root.leftChild.leftChild=newNodeD;
        root.leftChild.rightChild=newNodeE;
        root.rightChild.leftChild=newNodeF;
        root.rightChild.rightChild=newNodeG;
    }

    /**
     * 二叉树的节点数据结构
     * @author WWX
     */
    private class TreeNode{
        private int key=0;
        private String data=null;
        private boolean isVisted=false;
        private TreeNode leftChild=null;
        private TreeNode rightChild=null;

        public TreeNode(){}

        /**
         * @param key  层序编码
         * @param data 数据域
         */
        public TreeNode(int key,String data){
            this.key=key;
            this.data=data;
            this.leftChild=null;
            this.rightChild=null;
        }
    }

    public void visted(TreeNode subTree){
        subTree.isVisted=true;
        System.out.println("key:"+subTree.key+"--name:"+subTree.data);;
    }

    public void recPreOrder(TreeNode rootNode) {
        if (rootNode != null) {
            visted(rootNode);
            recPreOrder(rootNode.leftChild);
            recPreOrder(rootNode.rightChild);
        }
    }

    //前序遍历的非递归实现
    public void nonRecPreOrder(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pNode = rootNode;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                visted(pNode);
                stack.push(pNode);
                pNode = pNode.leftChild;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.rightChild;
            }
        }
    }

    public void recInOrder(TreeNode rootNode) {
        if (rootNode != null) {
            recInOrder(rootNode.leftChild);
            visted(rootNode);
            recInOrder(rootNode.rightChild);
        }
    }

    //中序遍历的非递归实现
    public void nonRecInOrder(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = rootNode;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.leftChild;
            } else {
                node = stack.pop();
                visted(node);
                node = node.rightChild;
            }
        }
    }

    public void recPostOrder(TreeNode rootNode) {
        if (rootNode != null) {
            recPostOrder(rootNode.leftChild);
            recPostOrder(rootNode.rightChild);
            visted(rootNode);
        }
    }

    public void nonRecAfterOrder(TreeNode rootNode) {
        if (rootNode == null) {
            return;
        }
        TreeNode node = rootNode;
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
            visted(node);
        }
    }

    /**
     *           A
     *     B          C
     *  D     E    F     G
     * @param args
     */
    //测试
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinTree(bt.root);
//        System.out.println("the size of the tree is " + bt.size());
//        System.out.println("the height of the tree is " + bt.height());
//
        System.out.println("*******(前序遍历)[ABDECF]遍历*****************");
        bt.recPreOrder(bt.root);

        System.out.println("*******(中序遍历)[DBEACF]遍历*****************");
        bt.recInOrder(bt.root);

        System.out.println("*******(后序遍历)[DEBFCA]遍历*****************");
        bt.recPostOrder(bt.root);

        System.out.println("***非递归实现****(前序遍历)[ABDECF]遍历*****************");
        bt.nonRecPreOrder(bt.root);

        System.out.println("***非递归实现****(中序遍历)[DBEACF]遍历*****************");
        bt.nonRecInOrder(bt.root);

        System.out.println("***非递归实现****(后序遍历)[DEBFCA]遍历*****************");
        bt.nonRecAfterOrder(bt.root);
    }
}
