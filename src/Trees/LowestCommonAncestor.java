package Trees;

import java.util.*;

public class LowestCommonAncestor {

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        // If either p or q matches the root, return the root
        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        // Recur for left and right subtrees
        Node leftLCA = lowestCommonAncestor(root.left, p, q);
        Node rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both leftLCA and rightLCA are not null, then one key is present in one subtree
        // and another key is present in another subtree. So this node is the LCA.
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, check if left subtree or right subtree is LCA
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    public static void main(String[] args) {
//        Node root = new Node(3);
//        root.left = new Node(5);
//        root.right = new Node(1);
//        root.left.left = new Node(6);
//        root.left.right = new Node(2);
//        root.right.left = new Node(0);
//        root.right.right = new Node(8);
//
//        LowestCommonAncestor solution = new LowestCommonAncestor();
//        Node p = root.left; // 5
//        Node q = root.right; // 1
//        Node lca = solution.lowestCommonAncestor(root, p, q);
//        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + lca.val);
//

        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        System.out.println(map);
    }
}
