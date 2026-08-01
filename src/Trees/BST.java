package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
		}
	}

	public static Node insert(Node root, int val) {
		if (root == null) {
			root = new Node(val);
			return root;
		}
		if (root.data > val) {
			// left subtree
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right, val);
		}
		return root;
	}

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void preorder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(Node root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}

	public static void levelOrder(Node root) {
		if (root == null) {
			return;
		}
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		while (!q.isEmpty()) {
			Node curr = q.remove();
			if (curr == null) {
				System.out.println();
				// queue empty
				if (q.isEmpty()) {
					break;
				} else {
					q.add(null);
				}
			} else {
				System.out.print(curr.data + " ");
				if (curr.left != null) {
					q.add(curr.left);
				}
				if (curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}

	public static int sumAtLevelK(Node root, int k) {
		if(root==null) return 0;
		int levelCount = 1;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		int sum = 0;
		while(!q.isEmpty()) {
			Node cur = q.remove();
			if(cur == null) {
				if(q.isEmpty()) {
					break;
				} else {
					q.add(null);
					levelCount++;
				}
			} else {
				if(levelCount==k) {
					sum = sum+cur.data;
					System.out.println("sum of nodes at level k: "+sum);
				}
				if (cur.left != null) {
					q.add(cur.left);
				}
				if (cur.right != null) {
					q.add(cur.right);
				}
			}
		}
		return sum;
	}

	public static boolean search(Node root, int key) {
		if (root == null)
			return false;
		if (root.data > key) { // left subtree
			return search(root.left, key);
		} else if (root.data == key) {
			return true;
		} else
			return search(root.right, key);
	}

	public static Node delete(Node root, int key) {
		// cases: 1. no child(leaf node), 2. one child, 
		// 3.two child-> replace the value with inorder successor(left most node in right subtree)
		if(root.data > key) {
			root.left = delete(root.left, key);
		} else if(root.data < key) {
			root.right = delete(root.right, key);
		} else {  // root.data == key
			if(root.left==null && root.right==null) {			// case 1
				return null;
			}
			if(root.left==null) {							// case 2
				return root.right;
			} else if(root.right==null) {
				return root.left;
			}
			// case 3
			Node inorderSucc = getInorderSuuccessor(root.right);
			root.data = inorderSucc.data;
			root.right = delete(root.right, inorderSucc.data);
		}
		return root;
	}
	
	public static Node getInorderSuuccessor(Node root) {
		while(root.left!=null) {
			root = root.left;
		}
		return root;
	}
	
	public static int leafCount(Node root) {
		if(root == null) {
			return 0;
		}
 		int leftNodes = leafCount(root.left);
		int rightNodes = leafCount(root.right);
		return leftNodes+rightNodes+1;
	}
	
	public static int sumOfNodes(Node root) {
		if(root==null) return 0;
		int leftSum = sumOfNodes(root.left);
		int rightSum = sumOfNodes(root.right);
		return leftSum+rightSum+root.data;
	}
	
	public static int height(Node root) {
		if(root==null) return 0;
		int leftHt = height(root.left);
		int rightHt = height(root.right);
		int ht = Math.max(leftHt, rightHt)+1;
		return ht;
	}
	
	public static int diameter(Node root) {			// O(n^2)
		if(root==null) return 0;
		int leftDiam = diameter(root.left);
		int rightDiam = diameter(root.right);
		int diam = height(root.left)+height(root.right)+1;
		
		return Math.max(diam, Math.max(leftDiam, rightDiam));
	}
	
	static class TreeInfo{
		int ht;
		int diam;
		TreeInfo(int h, int d){
			this.ht = h;
			this.diam = d;
		}
	}
	
	public static TreeInfo diam(Node root) {		// O(n)
		if(root==null) {
			return new TreeInfo(0,0);
		}
		TreeInfo left = diam(root.left);
		TreeInfo right = diam(root.right);
		
		int ht = Math.max(left.ht, right.ht)+1;
		
		int dia1 = left.diam;
		int dia2 = right.diam;
		int dia3 = left.ht+right.ht+1;
				
		int dia = Math.max(Math.max(dia1, dia2), dia3);
		TreeInfo mytinfo = new TreeInfo(ht, dia);
		return mytinfo;
		
	}
	
	public static boolean isSubTree(Node root, Node subRoot) {
		if(subRoot==null) return true;
		if(root==null) return false;
		if(root.data == subRoot.data) {
			if(isIdentical(root, subRoot)) {
				return true;
			}
		}
		return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
	}
	
	private static boolean isIdentical(Node root, Node subRoot) {
		if(root==null && subRoot==null) {
			return true;
		}
		if(root==null || subRoot==null) {
			return false;
		}
		if(root.data==subRoot.data) {
			return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
		}
		return false;
	}

	public static void printInRange(Node root, int x, int y) {
		if(root == null) return;
		if(root.data>=x && root.data<= y) {
			printInRange(root.left, x, y);
			System.out.print(root.data+" ");
			printInRange(root.right, x, y);
		} else if(root.data>=y) {
			printInRange(root.left, x, y);
		} else {
			printInRange(root.right, x, y);
		}
	}
	
	public static void rootToLeafPath(Node root, ArrayList<Integer> path) {
		if(root == null) return;
		path.add(root.data);
		// leaf nodes
		if(root.left==null && root.right==null) {
			printPath(path);
		} else {
			rootToLeafPath(root.left, path);
			rootToLeafPath(root.right, path);
		}
		path.remove(path.size()-1);
	}
	
	private static void printPath(ArrayList<Integer> path) {
		for(int i:path) {
			System.out.print(i+"->");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
		Node root = null;
		for (int i = 0; i < values.length; i++) {
			root = insert(root, values[i]);
		}
		// inorder(root);
//		preorder(root);
//		postorder(root);
//		levelOrder(root);
//		if (search(root, 4)) {
//			System.out.println("found");
//		} else
//			System.out.println("not found");
		
//		System.out.println("nodes count: "+leafCount(root));
//		System.out.println("sum of nodes: "+sumOfNodes(root));
//		System.out.println("height of a tree: "+height(root));
//		System.out.println("diameter: "+diameter(root));
//		System.out.println("optimized diameter: "+diam(root).diam);
		System.out.println("sum at k level: "+ sumAtLevelK(root, 3));
		
//		delete(root, 8);
//		levelOrder(root);
		
//		printInRange(root, 3,8);
//		rootToLeafPath(root,new ArrayList<>());
	}

}
