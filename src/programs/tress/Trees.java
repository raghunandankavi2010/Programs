package programs.tress;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Raghunandan
 */
public class Trees {

    private Node rootNode;
    private int height;
    static int max_level = 0;

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
        printDataAtLevel(rootNode);
        System.out.println("Largest : "+findLargestValueInTree(rootNode));
        System.out.println("Second Largest : "+findSecondLargest(rootNode,findLargestValueInTree(rootNode),0));
        //rightView(rootNode,1);
        //leftView(rootNode,1);
        //System.out.println("Print data at each level");
        //printDataAtLevelBFS(rootNode);
        //DFS(rootNode);
     /*   System.out.println("RootNode"+rootNode.getData());
        System.out.println("In Order");
        printInOrder(rootNode);
        System.out.println("Pre Order");
        printPreOrder(rootNode);
        System.out.println("Post Order");
        printPostOrder(rootNode);
        height = heightOfBinaryTree(rootNode);

        System.out.println("Print data at each level");

        System.out.println("Print data at each level in reverse order");
        reverseLevelOrder(rootNode);
        System.out.println("\n DFS");
        DFS(rootNode);*/
        //DFS(rootNode);
        //Node mirror = mirror(rootNode);
        //print(mirror);


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

    private void addToPosition(Node n, int value) {
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

    public void printPreOrder(Node node) {
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

    private void printDataAtLevelBFS(Node rootNode) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(rootNode);
        int currentLevelCount = 1;
        int nextLevelCount = 0;

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            int data = n.getData();
            System.out.print(data + " ");
            if (n.getLeftNode() != null) {
                //System.out.print(n.getData() + " ");

                queue.add(n.getLeftNode());
                nextLevelCount++;
                // System.out.println("left node data " + n.getLeftNode().getData());// + " " + nextLevelCount);
            }
            if (n.getRightNode() != null) {
                //System.out.print(n.getData() + " ");

                queue.add(n.getRightNode());
                nextLevelCount++;
                // System.out.println("right node data " + n.getRightNode().getData());// + " " + nextLevelCount);
            }
            currentLevelCount--;
            if (currentLevelCount == 0) {
                System.out.println("");
                currentLevelCount = nextLevelCount;
                nextLevelCount = 0;
            }
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


    }

    private void reverseLevelOrder(Node node) {
        Stack<Node> S = new Stack<Node>();
        Queue<Node> Q = new LinkedList<Node>();
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

    private Node mirror(Node root) {

        if (root != null) {
            mirror(root.getLeftNode());
            mirror(root.getRightNode());
            Node temp = root.getLeftNode();
            root.setLeftNode(root.getRightNode());
            root.setRightNode(temp);


        }
        return root;

    }

    public void print(Node root) {

        if (root != null) {
            System.out.println(root.getData());
            if (root.getLeftNode() != null) {
                //System.out.println(root.getLeftNode().getData());
                print(root.getLeftNode());
            }
            if (root.getRightNode() != null) {
                ;
                print(root.getRightNode());
            }
        }
    }

    private void leftView(Node node, int level) {
        // Base Case
        if (node == null) return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.println(" " + node.getData() + " " + max_level);
            max_level = level;
        }

        // System.out.print(" " + node.getData());

        // Recur for left and right subtrees
        leftView(node.getLeftNode(), level + 1);
        leftView(node.getRightNode(), level + 1);
    }

    private void rightView(Node node, int level) {
        // Base Case
        if (node == null) return;

        // If this is the first node of its level
        if (max_level < level) {
            System.out.println(" " + node.getData() + " " + max_level);
            max_level = level;
        }

        // System.out.print(" " + node.getData());

        // Recur for left and right subtrees
        rightView(node.getRightNode(), level + 1);
        rightView(node.getLeftNode(), level + 1);
    }

    // recursively go to the right and if you reach end print the number
    private static int findLargestValueInTree(Node root) {
        while (root.getRightNode() != null) {
            root = root.getRightNode();
        }
        return root.getData();
    }

    // recursively go to the right keeping track og current node less than largest node
    // if current node is not less than largest node then print root node.
    private  int findSecondLargest(Node root, int largest, int current) {
        while (root != null) {
            if (root.getData() < largest) {
                current = root.getData();
                root = root.getRightNode();
            } else {
                root = root.getLeftNode();
            }
        }
        return current;
    }

}