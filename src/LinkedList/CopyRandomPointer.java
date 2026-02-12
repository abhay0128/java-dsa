package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomPointer {

    public static class Node {
        String val;
        Node next;
        Node random;

        public Node(String val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandom(Node head) {
        if(head == null){
            return null;
        }

        Node newHead = new Node(head.val+"*");
        Node oldTemp = head.next;
        Node newTemp = newHead;
        Map<Node, Node> map = new HashMap<Node, Node>();
        // First pass: copy nodes and next pointers
        while(oldTemp != null) {
            Node copyNode = new Node(oldTemp.val + "*");
            map.put(oldTemp, copyNode);
            newTemp.next = copyNode;
            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }
        // Second pass: assign random pointers
        oldTemp = head;
        newTemp = newHead;
        while(oldTemp != null) {
            newTemp.random = map.get(oldTemp.random);
            newTemp = newTemp.next;
            oldTemp = oldTemp.next;
        }

        return newHead;

    }

    public static void main(String[] args) {
        // Create a linked list with random pointers for testing
        Node node1 = new Node("A");
        Node node2 = new Node("B");
        Node node3 = new Node("C");
        node1.next = node2;
        node2.next = node3;
        node1.random = node3; // A's random points to C
        node2.random = node1; // B's random points to A
        node3.random = node2; // C's random points to B
        Node copiedListHead = copyRandom(node1);
        // Print the copied list to verify
        Node temp = copiedListHead;
        while (temp != null) {
            String randomVal = (temp.random != null) ? temp.random.val : "null";
            System.out.println("Node val: " + temp.val + ", Random points to: " + randomVal);
            temp = temp.next;
        }

    }
}
