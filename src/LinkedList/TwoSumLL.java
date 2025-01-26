package LinkedList;

public class TwoSumLL {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode revL1 = reverse(l1);
        ListNode revL2 = reverse(l2);
        int n1 = constructNumber(revL1);
        int n2 = constructNumber(revL2);
        int sum = n1 + n2;
        System.out.println("sum: "+sum);
        ListNode sumNode = constructList(sum);
        printList(sumNode);
        return sumNode;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        System.out.println("reverse head: "+prev.val);
        return prev;
    }

    private static int constructNumber(ListNode head) {
        if (head == null) {
            return -1;
        }
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n = n * 10 + curr.val;
            curr = curr.next;
        }
        System.out.println("number: "+n);
        return n;
    }

    private static ListNode constructList(int n) {
        if (n == 0) {
            System.out.println("sum is 0");
            return new ListNode(0);
        }
        int temp = 0;
        ListNode head = new ListNode();
        ListNode curr = head;
        int count=0;
        while (n > 0) {
            temp = n % 10;
            if(count==0) {
                curr = new ListNode(temp);
                head=curr;
                count++;
            }
            else {
                curr.next = new ListNode(temp);
                curr=curr.next;
            }
            n = n / 10;
        }
        System.out.println("final answer: "+head.val);
        return head;
    }

    public static void printList(ListNode head){
        if(head==null){
            return;
        }
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.val+"->");
            curr= curr.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        printList(l1);
        printList(l2);
        addTwoNumbers(l1,l2);
    }
}
