package Queue;

public class QueueImpl<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    int size = 0;

    //add element to rear
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (front == null) {
            front = rear = newNode;
        }
        if (rear != null) {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // remove element from front
    public T dequeue() {
        if (front == null) throw new IllegalStateException("Queue is Empty");
        T element = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        size--;
        return element;
    }

    // remove element from rear
    public T dequeueRear() {
        if (rear == null) throw new IllegalStateException("Queue is Empty");
        if (front == rear) {
            T value = rear.data;
            front = rear = null;
            size--;
            return value;
        }
        Node<T> curr = front;
        while (curr.next != rear) {
            curr = curr.next;
        }
        T element = rear.data;
        rear = curr;
        rear.next = null;
        size--;
        return element;
    }

    public void display() {
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        QueueImpl<Integer> queue = new QueueImpl<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display(); // 1 -> 2 -> 3 -> null

        System.out.println("Removed from rear: " + queue.dequeueRear()); // 3
        queue.display(); // 1 -> 2 -> null
    }
}
