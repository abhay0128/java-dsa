package LinkedList;

// Problem was asked by Meta
public class LLProblem {
    static Node head;

    static class Node{
        String val;
        Node next;
        Node rand;

        Node(String val){
            this.val = val;
            this.next = null;
            this.rand = null;
        }
    }

    // A     ->     B   ->              C
    //(rand:C)      (rand:null)     (rand:A)

    // A1     ->     B1   ->              C1
    //(rand:C1)      (rand:null)     (rand:A1)
    public Node copy(Node head){
        if(head==null){
            return head;
        }
        Node chead = head;
        Node curr2=chead;
        curr2.val=chead.val+"`";
        Node curr = head;
        while(curr.next!=null){
            Node cnext = curr.next;
            Node crand = curr.rand;
            curr2.next.val = cnext.val+"`";
            curr2.rand.val = crand.val+"`";
            curr2 = curr2.next;
            curr=curr.next;
        }
        return chead;
    }

    public void addLast(String data, Node rand) {
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
        currentNode.rand = rand;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("list is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val+ "->");
            currentNode = currentNode.next;
        }
        System.out.println("NUll");
    }

    public static void main(String[] args) {
        LLProblem ll = new LLProblem();
        ll.addLast("A", new Node("C"));
        ll.addLast("B", new Node("C"));
        ll.addLast("C", new Node("A"));
        System.out.println(ll.head.val);
        Node nd = ll.copy(ll.head);
        ll.printList(nd);
        ll.printList(ll.head);
        System.out.println(ll.head.val);
    }
}
