package programs.lists;

/**
 * Created by raghu on 5/7/17.
 */
public class LinkedList {

    private Node head;
    private int list_size;
    private static Node first;
    private static boolean x = true;

    public static void main(String[] args) {

        Node node_returned;
        LinkedList linkedList = new LinkedList();

        linkedList.add(1);
        linkedList.add(0);
        linkedList.add(0);
        linkedList.add(1);
        //linkedList.add(15);
        //linkedList.add(20);
        //linkedList.add(25);
        // linkedList.printSize(linkedList.getHead());
        System.out.println("...................");
        // linkedList.printMiddleElementWithOnePass(linkedList.getHead());
        if (palindrome(linkedList.getHead())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
/*

        first = linkedList.getHead();
        if (isPalindrome(linkedList.getHead())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
*/

        //linkedList.print(linkedList.getHead());
        // System.out.println("/******Last but one*********/");
        //linkedList.getLastButOneData(linkedList.getHead());
        //linkedList.getNItemFromEnd(linkedList.getHead(),4);

//        System.out.println("/******Swap Adjacent Item*********/");
//        node_returned = linkedList.swapAdjacentItems(linkedList.getHead());
//        linkedList.setHead(node_returned);
//        linkedList.print(node_returned);
//
//        System.out.println("/******Insert & Printing*********/");
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(90),0);
//        linkedList.setHead(node_returned);
//
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(100),0);
//        linkedList.setHead(node_returned);
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(44),2);
//        linkedList.setHead(node_returned);
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(22),3);
//        linkedList.setHead(node_returned);
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(16),1);
//        linkedList.setHead(node_returned);
//
//        System.out.println("/******Insert at Invalid Position & Printing*********/");
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(16),30);
//        linkedList.setHead(node_returned);
//        linkedList.print(node_returned);
//
//        System.out.println("List Size After Insert "+linkedList.getList_size());
//
//        System.out.println("/******Deleting 10 & Printing*********/");
//        node_returned = linkedList.delete(linkedList.getHead(), 10);
//        linkedList.setHead(node_returned);
//        linkedList.print(linkedList.getHead());
//
//        Node reversed = linkedList.reverse(linkedList.getHead());
//        System.out.println("/*********Reversed & Printing************/");
//        linkedList.print(reversed);

    }

    public void setList_size(int list_size) {
        this.list_size = list_size;
    }

    public int getList_size() {
        return list_size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    private Node reverse(Node head) {
        if (head == null) {

            return null;
        } else if (head.getNext() == null) {
            System.out.println("Ony one item is List ");
            return head;
        } else {
            Node current = head;
            Node next;
            Node prev = null;
            while (current.getNext() != null) {
                next = current.getNext();
                // reversing the link
                current.setNext(prev);
                // moving currentNode and previous Node by 1 node
                prev = current;
                current = next;
            }

            current.setNext(prev);
            prev = current;


            return prev;
        }

    }

    private void print(Node head) {

        Node current = head;

        if (current == null) {
            System.out.println("List is Empty");

        } else {

            while (current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }

            System.out.println(current.getData());
        }
    }

    private Node delete(Node head, int data) {

        if (head != null) {
            Node prev = null;
            Node next;
            Node current = head;

            while (current.getNext() != null && current.getData() != data) {
                next = current.getNext();
                // moving currentNode and previous Node by 1 node
                prev = current;
                current = next;
            }


            if (prev != null && current.getData() == data) {
                prev.setNext(current.getNext());
            } else if (current.getData() == data) {
                // case where data to be deleted is at the start for the node
                current = current.getNext();
                head = current;

            } else {
                System.out.println("Data item not in List ");
            }

            return head;
        } else {
            return null;
        }

    }

    private void add(int data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
            head.setNext(null);
            setHead(head);
            setList_size(getList_size() + 1);
        } else {

            Node temp = new Node(data);
            Node current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
            temp.setNext(null);
            setList_size(getList_size() + 1);
        }

    }

    private Node insertAtPosition(Node head, Node node, int pos) {

        if (head != null && head.getNext() != null && pos != getList_size() && pos != 0) {
            int count = 0;
            Node current = head;
            Node prev = null;
            Node next;

            while (current.getNext() != null && count != pos) {
                next = current.getNext();
                prev = current;
                current = next;
                count++;
            }

            if (prev != null && count == pos) {
                prev.setNext(node);
                node.setNext(current);
                setList_size(getList_size() + 1);
                System.out.println("Insert " + node.getData() + " at " + pos);
            } else {
                System.out.println("Position " + pos + " is Invalid!");
            }
        } else if (head != null && pos == 0) {

            node.setNext(head);
            head = node;
            setList_size(getList_size() + 1);
            System.out.println(" Inserting " + node.getData() + " at the beginning " + pos);
        } else if (head != null && pos == getList_size()) {

            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            System.out.println(" Inserting " + node.getData() + " at the end " + pos);
            setList_size(getList_size() + 1);

        } else if (head == null && pos == 0) {
            head = node;
            setList_size(getList_size() + 1);
            System.out.println(" List Empty. Inserting at beginning " + node.getData());
        } else {
            System.out.println("List is Empty. Cannot insert at position" + pos);
        }
        return head;

    }

    private void getLastButOneData(Node head) {
        if (head != null) {
            Node current = head;
            Node prev = null;
            Node next = null;
            while (current.getNext() != null) {
                next = current.getNext();
                prev = current;
                current = next;
            }
            if (prev != null) {
                System.out.println("Last But one item " + prev.getData());
            } else {
                System.out.println("Only one item. Last But one item " + head.getData());
            }
        } else {
            System.out.println("List is empty");
        }
    }

    private Node swapAdjacentItems(Node head) {
        if (head != null) {

            Node current = head;
            Node prev;
            Node next;
            while (current.getNext() != null) {
                next = current.getNext();
                prev = current;
                int datanext = next.getData();
                int dataprev = prev.getData();

                //12 5 10 15 20 25
                prev.setData(datanext);
                next.setData(dataprev);
                current = next;
                if (current.getNext() != null) {
                    current = current.getNext();
                }
            }
            return head;
        } else {
            return null;
        }
    }

    /**
     * 12,5,10,15,20,25
     */


    private void getNItemFromEnd(Node head, int pos) {
        if (head != null) {
            System.out.println(head.getData());
            Node current = head;
            Node prev = null;
            Node next = null;
            int count = 0;
            while (current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
                count++;

                if (count == pos) {
                    prev = head;
                }
                if (prev != null) {
                    prev = prev.getNext();
                }
            }
            if (prev != null) {
                System.out.println("Last But " + pos + " item is " + prev.getData());
            } else {
                System.out.println("Only one item. Last But one item " + head.getData());
            }
        } else {
            System.out.println("List is empty");
        }
    }

    private void printMiddleElementWithOnePass(Node head) {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.getNext() != null) {
                fast_ptr = fast_ptr.getNext().getNext();
                slow_ptr = slow_ptr.getNext();
            }
            System.out.println("The middle element is [" +
                    slow_ptr.getData() + "] \n");
        }
    }

    private void printSize(Node head) {

        Node current = head;

        if (current == null) {
            System.out.println("List is Empty");

        } else {
            int length = 0;
            while (current != null) {
                length++;
                current = current.getNext();
            }

            System.out.println("Length :" + length);
        }
    }

    private static boolean palindrome(Node head) {
        if (head == null)
            return false;
        Node middle = null;
        Node fastPtr = head;
        Node slowPtr = head;
        while (fastPtr != null && fastPtr.getNext() != null) {

            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();

        }
         // if length is odd
         // move sloe ptr by 1
        if (fastPtr != null) {
            middle = slowPtr;
            middle.setNext(null);
            slowPtr = slowPtr.getNext();
        }
        // if even middle is slowptr
        Node secondHalfHead = slowPtr;
        Node secondHalf = reverseLinkedList(secondHalfHead);
        return compareLists(head, secondHalf);
    }

    private static boolean compareLists(Node head, Node secondHalf) {
        boolean check = false;
        while (head != null && secondHalf != null) {
            if (head.getData() == secondHalf.getData()) {
                head = head.getNext();
                secondHalf = secondHalf.getNext();
                check = true;
            } else {
               return false;
            }

        }
        return check;
    }

    private static Node reverseLinkedList(Node currentNode) {
        Node previousNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;

        }
        return previousNode;
    }


    //first = head, last = head, initially
    private static boolean isPalindrome(Node last) {
        //whenever last will reach at the end of the linkedlist, we will return true.
        if (last == null)
            return true;
        // in each recursive call, we won't modify first, but modify last.
        x = isPalindrome(last.getNext());
        //remember, when an element of stack return false, we will return false to each bottom most element.
        if (!x) return false;

        //if x is true, we will check the next entry.
        boolean y = false;
        if (first.getData() == last.getData()) {
            y = true;
        }

        //advancing first before returning from the current element of the stack.
        first = first.getNext();
        return y;
    }


}


