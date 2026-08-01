package Trees;

import java.util.PriorityQueue;
import java.util.*;

public class TopView {

    public static void topView(Node root) {
        if (root == null) return;

        // Map from horizontal distance -> node value
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<Node, Integer> curr = queue.poll();
            Node node = curr.getKey();
            int hd = curr.getValue();

            // Only add if HD not already seen (first = topmost)
            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null)  queue.add(new Pair<>(node.left, hd-1));
            if (node.right != null) queue.add(new Pair<>(node.right, hd+1));
        }

        // Print left to right
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    static class Pair<Node, Integer> {
        private Node key;
        private Integer value;

        public Pair(Node key, Integer value) {
            this.key = key;
            this.value = value;
        }

        public Node getKey() {
            return key;
        }

        public Integer getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);

        System.out.println("Top view of the binary tree:");
        topView(root); // Expected output: 2 1 3 5 6
    }

}
