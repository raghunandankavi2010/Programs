/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Raghunandan
 */
public class Trees {

    private Node rootNode;
    private int height;

    public Trees() {


        Node n1 = new Node();
        addNode(n1, 5);

        Node n2 = new Node();
        addNode(n2, 1);
        Node n0 = new Node();
        addNode(n0, 0);
        Node n3 = new Node();
        addNode(n3, 8);
        Node n4 = new Node();
        addNode(n4, 7);
        Node n5 = new Node();
        addNode(n5, 6);
        Node n6 = new Node();
        addNode(n6, 3);
        Node n7 = new Node();
        addNode(n7, 9);
        Node n8 = new Node();
        addNode(n8, 10);
        System.out.println("RootNode" + rootNode.getData());
        System.out.println("In Order");
        printInOrder(rootNode);
        System.out.println("Pre Order");
        printPreOrder(rootNode);
        System.out.println("Post Order");
        printPostOrder(rootNode);
        height = heightOfBinaryTree(rootNode);

        System.out.println("Print data at each level");
        printDataAtLevel(rootNode);
        System.out.println("Print data at each level in reverse order");
        reverseLevelOrder(rootNode);
        System.out.println("\n DFS");
        DFS(rootNode);

    }

    public static void main(String[] args) {
        new Trees();

    }

    private void addNode(Node n, int value) {
        if (rootNode == null) {
            Node temp = new Node();
            temp.setData(value);
            rootNode = temp;

        } else {
            addToPosition(rootNode, value);
        }

    }

    public void addToPosition(Node n, int value) {
        if (value <= n.getData()) {
            if (n.getLeftNode() != null) {
                addToPosition(n.getLeftNode(), value);
            } else {
                Node temp = new Node();
                temp.setData(value);
                n.setLeftNode(temp);
            }
        } else if (value >= n.getData()) {
            if (n.getRightNode() != null) {
                addToPosition(n.getRightNode(), value);
            } else {
                Node temp = new Node();
                temp.setData(value);
                n.setRightNode(temp);
            }
        }
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeftNode());
            System.out.println(node.getData());
            printInOrder(node.getRightNode());
        }
    }

    private void printPreOrder(Node node) {
        if (node != null) {
            System.out.println(node.getData());
            printPreOrder(node.getLeftNode());
            printPreOrder(node.getRightNode());
        }
    }

    private void printPostOrder(Node node) {
        if (node != null) {
            printPostOrder(node.getLeftNode());
            printPostOrder(node.getRightNode());
            System.out.println(node.getData());
        }
    }

    private int heightOfBinaryTree(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1
                    + Math.max(heightOfBinaryTree(node.getLeftNode()),
                    heightOfBinaryTree(node.getRightNode()));
        }
    }

    /* Breadth First Search or level order Traversal*/
    private void printDataAtLevel(Node rootNode) {

        Queue<Node> queue = new LinkedList<Node>();

        queue.add(rootNode);
        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            System.out.print("Level " + levelNodes);
            while (levelNodes > 0) {

                Node n = (Node) queue.remove();

                System.out.print(" Data at Node: " + n.getData());
                if (n.getLeftNode() != null) {
                    queue.add(n.getLeftNode());
                }
                if (n.getRightNode() != null) {
                    queue.add(n.getRightNode());
                }

                levelNodes--;
            }
            System.out.println("");
        }
        //System.out.println("Reversed");

    }

    private void reverseLevelOrder(Node node) {
        Stack<Node> S = new Stack<>();
        Queue<Node> Q = new LinkedList<>();
        Q.add(node);

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (!Q.isEmpty()) {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);

            /* Enqueue right child */
            if (node.getRightNode() != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.getRightNode());

            /* Enqueue left child */
            if (node.getLeftNode() != null)
                Q.add(node.getLeftNode());
        }

        // Now pop all items from stack one by one and print them
        while (!S.empty()) {
            node = S.peek();
            System.out.print(node.getData() + " \n");
            S.pop();
        }
    }

    private void DFS(Node root) {
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (!s.isEmpty()) {
            Node x = s.pop();
            if (x.getRightNode() != null) s.add(x.getRightNode());
            if (x.getLeftNode() != null) s.add(x.getLeftNode());
            System.out.print(" " + x.getData());
        }
    }

}
