package Stack;

public class Stack {

    Node head;

    public boolean isStackEmpty() {
        return head == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (isStackEmpty()) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public int peek() {
        if (isStackEmpty()) {
            return -1;
        }
        return head.data;
    }

    public int pop() {
        if (isStackEmpty()) {
            return -1;
        }
        int top = head.data;
        head = head.next;
        return top;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(4);
        stack.push(6);
        stack.push(7);
        stack.push(3);

        while (!stack.isStackEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}