package info.mb.dsalgo.practice.general;

import java.util.Deque;
import java.util.LinkedList;

import info.mb.dsalgo.datastructure.BinaryTree;
import info.mb.dsalgo.datastructure.BinaryTree.Node;

/**
 * Problem Statement- Given a tree asked to print the maximum number of bends in
 * the tree.
 * 
 * @author Mukul Bansal
 *
 */
public class BendyTree {

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
		tree.insert(7);
		tree.insert(13);

		System.out.println("Values of tree in sorted Order are- ");
		tree.display(tree.root);

		System.out.print("Maximum bends in the tree- ");
		System.out.println(maximumBends(tree.root, "noDir", 0) - 1 + "\n");
		System.out.println("Maximum bendy path in the tree- ");
		Deque<Node> deque = maximumBendPath(tree.root, "noDir", 0);
		while (!deque.isEmpty()) {
			System.out.println(deque.removeLast().data);
		}
	}

	private static int maximumBends(Node node, String dir, int level) {
		if (node.leftChild == null && node.rightChild == null) {
			return 0;
		}

		int bends1 = 0;
		int bends2 = 0;

		if (dir.equalsIgnoreCase("left")) {
			if (node.leftChild != null)
				bends1 = maximumBends(node.leftChild, "left", level + 1);
			if (node.rightChild != null)
				bends2 = 1 + maximumBends(node.rightChild, "right", level + 1);
		} else if (dir.equalsIgnoreCase("right")) {
			if (node.leftChild != null)
				bends1 = 1 + maximumBends(node.leftChild, "left", level + 1);
			if (node.rightChild != null)
				bends2 = maximumBends(node.rightChild, "right", level + 1);
		} else if (dir.equals("noDir")) {
			if (node.leftChild != null)
				bends1 = 1 + maximumBends(node.leftChild, "left", level + 1);
			if (node.rightChild != null)
				bends2 = 1 + maximumBends(node.rightChild, "right", level + 1);
		}

		return Math.max(bends1, bends2);
	}

	private static Deque<Node> maximumBendPath(Node node, String dir, int level) {
		if (node.leftChild == null && node.rightChild == null) {
			Deque<Node> deque = new LinkedList<Node>();
			deque.add(node);
			return deque;
		}

		Deque<Node> deque1 = new LinkedList<Node>();
		Deque<Node> deque2 = new LinkedList<Node>();

		if (dir.equalsIgnoreCase("left")) {
			if (node.leftChild != null) {
				deque1 = maximumBendPath(node.leftChild, "left", level + 1);
				deque1.add(node);
			}
			if (node.rightChild != null) {
				deque2 = maximumBendPath(node.rightChild, "right", level + 1);
				deque2.add(node);
			}
		} else if (dir.equalsIgnoreCase("right")) {
			if (node.leftChild != null) {
				deque1 = maximumBendPath(node.leftChild, "left", level + 1);
				deque1.add(node);
			}
			if (node.rightChild != null) {
				deque2 = maximumBendPath(node.rightChild, "right", level + 1);
				deque2.add(node);
			}
		} else if (dir.equals("noDir")) {
			if (node.leftChild != null) {
				deque1 = maximumBendPath(node.leftChild, "left", level + 1);
				deque1.add(node);
			}
			if (node.rightChild != null) {
				deque2 = maximumBendPath(node.rightChild, "right", level + 1);
				deque2.add(node);
			}
		}

		if (deque1.size() >= deque2.size()) {
			return deque1;
		}
		return deque2;
	}

}
