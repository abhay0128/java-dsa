package LinkedList;

import java.util.HashSet;

public class LinkedListImpl {
    Node head;
    private int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
            size++;
        }
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data) {
        Node nd = new Node(data);
        if (head == null) {
            head = nd;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = nd;
    }

    public void deleteFirst() {
        if (head == null) {
            System.out.println("list is already empty");
            return;
        }
        size--;
        head = head.next;
    }

    public void deleteLast() {
        if (head == null) {
            System.out.println("list is already empty");
            return;
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        Node secondLastNode = head;
        Node lastNode = head.next;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
    }

    public void deleteNthNodeFromEnd(Node head, int n, int size) {
        if (head.next == null) {
            return;
        }
        Node prev = head;
        if(n==size) {
            this.head = head.next;
            return;
        }
        int indextosearch = size - n;			// nth node from last in LinkedList will be at size-n index or (size-n+1)th node
        int i = 1;
        while (i < indextosearch) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public int getSize() {
        return size;
    }

    public void makeCycle(String data) {
        Node nd = new Node(data);
        if (head == null) {
            head = nd;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = nd;
        nd.next = head.next; // make cycle from last node to second node from starting
        //	nd.next = head; // make cycle from last node to head node

    }

    public void printList(LinkedListImpl ll) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("NUll");
    }

    public void reverse() {
        if(head==null || head.next==null) {
            return;
        }
        Node prev = head;
        Node curr = head.next;
        while(curr!=null) {
            Node nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        head.next = null;
        head = prev;
    }

    public static Node recursiveReverse(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        Node newHead = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private Node findMiddle(Node head2) {		// return end of 1st half
        Node slow = head2;
        Node fast = head2;
        while(fast.next!=null && fast.next.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(Node head) {
        if(head==null || head.next==null) {
            return true;
        }
        Node middle = findMiddle(head);
        Node secondHalfStart = reverse(middle.next);
        Node firstHalfStart = head;
        while(secondHalfStart!=null) {
            if(firstHalfStart.data != secondHalfStart.data) {
                System.out.println("list is not palindrome");
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        System.out.println("list is palindrome");
        return true;
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr!=null) {
            Node next = curr.next;
            curr.next =prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static boolean hasCycle(Node head) {
        if(head == null)
            return false;

        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) {
                System.out.println("cycle detected");
                return true;
            }
        }
        System.out.println("cycle not detected");
        return false;
    }

    public void removeCycle(Node head) {
        if(head==null || head.next==null){
            return;
        }
        Node slow = head;
        Node fast = head;
        boolean hasCycle=false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        if(hasCycle){
            Node curr = head;
            HashSet<Node> vis = new HashSet<>();
            while(true){
                if(vis.contains(curr.next)) {
                    curr.next=null;
                    break;
                }
                vis.add(curr);
                curr=curr.next;
            }
        }

    }

    public static void main(String[] args) {
        LinkedListImpl ll = new LinkedListImpl();
        ll.addFirst("invincible");
        ll.addFirst("am");
        ll.addFirst("I");
        ll.addLast("unstopbl");
//		ll.printList(ll);
//		ll.reverse();
//		ll.printList(ll);
//		System.out.println("size of linked list: " + ll.getSize());

        LinkedListImpl ll2 = new LinkedListImpl();
        ll2.addLast("l");
        ll2.addLast("t");
        ll2.addLast("p");
        ll2.addLast("z");
        ll2.addLast("o");

        //ll2.isPalindrome(ll2.head);
        ll2.makeCycle("k");
//		ll2.printList(ll2);
        ll2.hasCycle(ll2.head);
        //ll2.printList(ll);
        ll2.removeCycle(ll2.head);
        ll2.printList(ll2);
    }

}
