package info.mb.dsalgo.datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Problem statement- https://www.geeksforgeeks.org/bottom-view-binary-tree/
 * @author Mukul Bansal
 *
 */
public class BinaryTree {

	public Node root;

	public class Node {
		int data;
		Node leftChild;
		Node rightChild;
		// For printing bottom view only
		int horizontalDistance;

		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	public void insert(int data) {

		Node parentHead = null;
		Node head = root;

		while (head != null) {
			parentHead = head;
			if (head.data < data) {
				head = head.rightChild;
			} else {
				head = head.leftChild;
			}
		}

		if (parentHead.data < data) {
			parentHead.rightChild = new Node(data);
			parentHead.rightChild.horizontalDistance = parentHead.horizontalDistance + 1;
		} else {
			parentHead.leftChild = new Node(data);
			parentHead.leftChild.horizontalDistance = parentHead.horizontalDistance - 1;
		}
	}

	/**
	 * Doing an DFS- inorder traversal of tree. It actually prints the values in
	 * sorted order. Neat, Huh!
	 */
	public void display(Node node) {

		if (node.leftChild != null || node.rightChild != null) {
			if (node.leftChild != null) {
				display(node.leftChild);
			}
			System.out.println(node.data);
			if (node.rightChild != null) {
				display(node.rightChild);
			}
		} else {
			System.out.println(node.data);
		}
	}

	private void printBottomView() {
		Map<Integer, Integer> levelValueMap = new TreeMap<Integer, Integer>();

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		// Doing a breadth-first traversal and populating the levelValueMap with
		// horizontalDistancce and nodeValue pairs.
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			levelValueMap.put(node.horizontalDistance, node.data);

			if (node.leftChild != null) {
				queue.add(node.leftChild);
			}
			if (node.rightChild != null) {
				queue.add(node.rightChild);
			}
		}

		Iterator<Entry<Integer, Integer>> iterator = levelValueMap.entrySet().iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next().getValue() + " ");
		}
		System.out.println();

	}

	public static void main(String[] args) {

		// Creating a binary tree with root node 20.
		BinaryTree tree = new BinaryTree();
		tree.root = tree.new Node(20);
		tree.root.horizontalDistance = 0;

		tree.insert(8);
		tree.insert(22);
		tree.insert(5);
		tree.insert(3);
		tree.insert(25);
		tree.insert(10);
		tree.insert(14);

		System.out.println("Values of tree in sorted Order are- ");
		tree.display(tree.root);

		System.out.println("Bottom view of the tree- ");
		tree.printBottomView();

	}

}
