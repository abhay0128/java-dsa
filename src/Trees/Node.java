package Trees;

public class Node {

	int val;
	Node left, right;

	public Node(int item) {
		this.val = item;
		this.left = right = null;
	}

	@Override
	public String toString() {
		return "" + val + "" + left + "" + right + "";
	}
	
}
