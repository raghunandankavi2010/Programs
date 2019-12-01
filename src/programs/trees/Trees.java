package programs.trees;

import java.util.*;

/**
 * @author Raghunandan
 */
public class Trees {

    private Node rootNode;
    private static int max_level = 0;
    
    private Trees() {

        Node n1 = new Node();

        addNode(n1, 1);
        Node n2 = new Node();
        addNode(n2, 2);
        Node n3 = new Node();
        addNode(n3, 3);
        bottomView(rootNode);
        /*Node n2 = new Node();
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
        addNode(n8, 10);*/
       // System.out.println("maximum path sum"+maxPathSum(rootNode));
/*

        System.out.println(lowestCommonAncestor(rootNode, rootNode.getLeftNode().getLeftNode(), rootNode.getLeftNode().getRightNode()).getData());
        System.out.println();
        int firstElement = 6;
        int secondElement = 10;
        List<Integer> path1 = findPath(rootNode,firstElement,new ArrayList<>());

        List<Integer> path2 = findPath(rootNode,secondElement,new ArrayList<>());

        if(path1.size()>0 && path2.size()>0){
            for(int number:path1){
                System.out.println(number);
            }
            System.out.println();
            for(int number:path2){
                System.out.println(number);
            }
            System.out.println();
            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                if (!path1.get(i).equals(path2.get(i))){
                    break;
                }
            }
            System.out.println(String.format("Lowest Common Ancestor of %d and %d is %d", firstElement, secondElement, path1.get(i - 1)));
        }else{
            System.out.println("Element not found");
        }
*/


     /*   if(path2!=null)
            for(int i=0;i<path2.size()-1;i++){
                System.out.println(path2.get(i));
            }*/
     /*   if(path1!=null || path2!=null){
            int i;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                System.out.println(path1.get(i) + " " + path2.get(i));
                if (!path1.get(i).equals(path2.get(i))){
                    System.out.println("Lowest Common Ancestor of 0 and 3 is "+path1.get(i));
                    break;
                }

            }
        }*/

        // printDataAtLevel(rootNode);
        //System.out.println("Largest : " + findLargestValueInTree(rootNode));
        //System.out.println("Second Largest : " + findSecondLargest(rootNode, findLargestValueInTree(rootNode)));
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
       /* int sumLeft = DFSSUM(rootNode.getLeftNode(),0);
        int sumRight = DFSSUM(rootNode.getRightNode(),0);
        System.out.println("Sum of Left tree and right tree "+(sumLeft+sumRight));*/
        //Node mirror = mirror(rootNode);
        //print(mirror);
        //System.out.println("Start node "+rootNode.getRightNode().getRightNode().getData());
        //System.out.println("All nodes at distance 1 from start node is: ");
        //getKthDistanceNodes(rootNode,rootNode.getRightNode().getRightNode(),1);


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
            // popping because its already visited
            Node x = s.pop();
            // first add right node
            // then left because we pop from the top of stack
            if (x.getRightNode() != null) s.add(x.getRightNode());
            if (x.getLeftNode() != null) s.add(x.getLeftNode());
            System.out.print(" " + x.getData());
        }
    }

    private int DFSSUM(Node root,int sum) {
        Stack<Node> s = new Stack<Node>();
        s.add(root);
        while (!s.isEmpty()) {
            // popping because its already visited
            Node x = s.pop();
            // first add right node
            // then left because we pop from the top of stack
            if (x.getRightNode() != null) s.add(x.getRightNode());
            if (x.getLeftNode() != null) s.add(x.getLeftNode());
            sum += x.getData();
        }
        return sum;
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

    // recursively go to the right keeping track of current node less than largest node
    // if current node is not less than largest printleft node
    // else print root node.
    private int findSecondLargest(Node root, int largest) {
        int current = 0;
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
    // 1. add all parent nodes to hashmap for each node
    // 2. add start node to set
    // 3. Use queue and do a BFS traversal.
    // 4. for each node check if left, right and parent in queue and set
    // 5. if not add then to the queue and set
    // 7. increment current level and decrement level traversed.
    // 8. if current level is same as k (given level) then print all nodes in queue.
    private static void getKthDistanceNodes(Node root,Node start,int k){
        Map<Node,Node> parentNodeMap = new HashMap<Node,Node>();
        populateMap(parentNodeMap,root,null);

        HashSet<Node> seen = new HashSet<>();
        seen.add(start);

        Queue<Node> queue = new LinkedList<>();

        queue.add(start);
        int currentLevel = 0;
        while(!queue.isEmpty()){

            int level = queue.size();

            if(currentLevel == k){
                printQueueContents(queue);
            }

            while(level>0){
                Node node = queue.remove();
                if(node.getLeftNode()!=null && !seen.contains(node.getLeftNode())){
                    queue.add(node.getLeftNode());
                    seen.add(node.getLeftNode());
                }

                if(node.getRightNode()!=null && !seen.contains(node.getRightNode())){
                    queue.add(node.getRightNode());
                    seen.add(node.getRightNode());
                }

                Node parent = parentNodeMap.get(node);
                if(parent!=null && !seen.contains(parent)){
                    seen.add(parent);
                    queue.add(parent);
                }

                level--;
                currentLevel++;
            }
        }
    }

    private static void printQueueContents(Queue<Node> queue) {
        for (Node node: queue) {
            System.out.print(node.getData()+" ");
        }
    }

    private static void populateMap(Map<Node, Node> parentNodeMap, Node root, Node parent) {
        if(root==null){
            return;
        }
        parentNodeMap.put(root,parent);
        populateMap(parentNodeMap,root.getLeftNode(),root);
        populateMap(parentNodeMap,root.getRightNode(),root);
    }


    private static List<Integer> findPath(Node head,int n,List<Integer> path){
        if(head!=null)
            path.add(head.getData());
        while(head!=null &&head.getData()!=n){
            if(n<head.getData()){
                head = head.getLeftNode();
            }else{
                head = head.getRightNode();
            }
            if(head!=null)
            path.add(head.getData());
        }
        if(!path.contains(n)){
            path.clear();
        }
        return path;
    }

    private static Node lowestCommonAncestor(Node root, Node p, Node q) {

         if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        Node left = lowestCommonAncestor(root.getLeftNode(),p,q);

        Node right = lowestCommonAncestor(root.getRightNode(),p,q);

        if(left!=null && right!=null){
            return root;
        }
        if(right !=null){
            return right;
        }
        return left;

    }

    // maximum sum path of a tree
    private static int res = Integer.MIN_VALUE;
    private static int maxPathSumHelper(Node root){
        // if root is null sum is o
        if(root ==null){
            return 0;
        }else if(root.getLeftNode() == null && root.getRightNode() == null) { // if both left and right of root is null set root as result
            if(root.getData() > res) res = root.getData();
            return root.getData();
        }else{
            // recursively travel left and right
            int leftsum= maxPathSumHelper(root.getLeftNode());
            int rightsum = maxPathSumHelper(root.getRightNode());
            // all possible sums and at each recursion
            int sum1 = root.getData();
            int sum2 = leftsum+root.getData();
            int sum3 = rightsum+root.getData();
            int sum4 = leftsum+root.getData()+rightsum;
            int temp = Math.max(Math.max(sum1,sum2),sum3);
            int tempres = Math.max(temp,sum4);
            // set the result to maximum of the above sums
            if(tempres>res){
                res = tempres;
            }
            return temp;
        }
    }

    private static int maxPathSum(Node root) {
        maxPathSumHelper(root);
        return res;
    }

    // print bottomview
    // traverse by level
    // left horizontal distance is root-1
    // right horizontal distance is root+1
    // print the value in map. use TreeMap to track nodes in order
    private static void bottomView(Node head) {
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        int hd = 0;
        head.setHd(hd);
        queue.add(head);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            map.put(hd, temp.getData());
                if (temp.getLeftNode() != null) {
                    temp.getLeftNode().setHd(hd-1);
                    queue.add(temp.getLeftNode());
                }
                if (temp.getRightNode() != null) {
                    temp.getRightNode().setHd(hd-1);
                    queue.add(temp.getRightNode());
                }
            }


        for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            System.out.println(value+" ");
        }

    }

}