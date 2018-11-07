package com.wb.system.util.algorithm;

public class LinkListReverse {

    public static Node reverse(Node current) {
        //initialization
        Node previousNode = null;
        Node nextNode = null;

        while (current != null) {
            //save the next node
            nextNode = current.next;
            //update the value of "next"
            current.next = previousNode;
            //shift the pointers
            previousNode = current;
            current = nextNode;
        }
        return previousNode;
    }

    public static Node reverse1(Node current) {
        Node preNode = null;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        return preNode;
    }

    public static Node reverse3(Node current) {
        Node preNode = null;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        return preNode;
    }

    public static Node reverse2(Node current) {
        Node preNode = null;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = preNode;
            preNode = current;
            current = nextNode;
        }
        return preNode;
    }



    static class Node {
        private int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "data=" + data;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Node cNode = node1;
        while (cNode != null) {
            System.out.println(cNode);
            cNode = cNode.next;
        }

        System.out.println("-----------------");

        cNode = reverse1(node1);
        while (cNode != null) {
            System.out.println(cNode);
            cNode = cNode.next;
        }
    }
}
