package LinkedList;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.Map;

// Problem was asked by Meta
public class LLProblem {
    private Node head = null;
    private Node tail = null;

    static class Node {
        String val;
        Node next;
        Node rand;

        Node(String val) {
            this.val = val;
            this.next = null;
            this.rand = null;
        }
    }

    // A     ->     B   ->              C
    //(rand:C)      (rand:null)     (rand:A)

    // A1     ->     B1   ->              C1
    //(rand:C1)      (rand:null)     (rand:A1)
    public Node copy(Node head) {

        // algo: 1. make a simple new copy of linkedlist
        // 2. store all old node corresponding values to new node in map as Map<Node, Node> while making new copy
        // 3. reassign oldTemp and newTemp to old head and new head
        // 4. iterate over all nodes from starting and keep assigning random pointer of old to new by fetching the random pointer of old from map

        if (head == null) {
            return null;
        }
        Node newHead = new Node(head.val + "1");
        Node oldTemp = head.next;
        Node newTemp = newHead;
        Map<Node, Node> nodeMap = new HashMap<>();
        nodeMap.put(head, newHead);

        while (oldTemp != null) {
            Node copyNode = new Node(oldTemp.val+"1");
            nodeMap.put(oldTemp, copyNode);
            newTemp.next = copyNode;
            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }
//        printList(newHead);

        oldTemp = head;
        newTemp = newHead;
        while (oldTemp != null) {
            newTemp.rand = nodeMap.get(oldTemp.rand);
            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }

        return newHead;
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val+"1");
        Node oldTemp = head.next;
        Node newTemp = newHead;
        map.put(head, newHead);

        // First pass: copy nodes and next pointers
        while (oldTemp != null) {
            Node copyNode = new Node(oldTemp.val+"1");
            map.put(oldTemp, copyNode);
            newTemp.next = copyNode;

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        // Second pass: assign random pointers
        oldTemp = head;
        newTemp = newHead;
        while (oldTemp != null) {
            newTemp.rand = map.get(oldTemp.rand);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }

        return newHead;
    }
    public void addNode(String val, Node random) {
        Node newNode = new Node(val);
        newNode.rand = random;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printRandomPointers(Node node) {
        while (node != null) {
            String randVal = (node.rand != null) ? String.valueOf(node.rand.val) : "null";
            System.out.println(node.val + " (random → " + randVal + ")");
            node = node.next;
        }
    }

    public void addLast(String data, Node rand) {
        Node nd = new Node(data);
        if (head == null) {
            head = nd;
            head.rand = rand;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = nd;
        currentNode.next.rand = rand;
    }

    public void printList2(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NUll");
    }

    public void printRand(Node head) {
        if (head == null) {
            System.out.println("list empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.rand.val + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NUll");
    }

    public static void main(String[] args) {
//        LLProblem ll = new LLProblem();
//        ll.addNode("A", new Node("C"));
//        ll.addNode("B", new Node("C"));
//        ll.addNode("C", new Node("A"));
        //        System.out.println(ll.head.val);
//        ll.printRandomPointers(ll.head);
//        Node nd = ll.copyRandomList(ll.head);
//        ll.printRandomPointers(nd);
//        System.out.println(nd.val);
//        ll.printList(ll.head);
//
//        System.out.println(ll.head.val);

        LLProblem ll2 = new LLProblem();

        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");

        // Connect next pointers
        A.next = B;
        B.next = C;

        // Set random pointers
        A.rand = C;
        B.rand = C;
        C.rand = A;


        System.out.println("Original List:");
        ll2.printList2(A);
        ll2.printRandomPointers(A);

        Node copied = ll2.copyRandomList(A);
        System.out.println("\nCopied List:");
        ll2.printList(copied);
        ll2.printRandomPointers(copied);

    }
}
