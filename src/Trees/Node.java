package Trees;

public class Node {

	int data;
	Node left, right;

	public Node(int item) {
		this.data = item;
		this.left = right = null;
	}

	@Override
	public String toString() {
		return "" + data + "" + left + "" + right + "";
	}
	
}
