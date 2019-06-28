package info.mb.dsalgo.practice.general;

import info.mb.dsalgo.datastructure.BinaryTree;
import info.mb.dsalgo.datastructure.BinaryTree.Node;

/**
 * Problem Statement- Given a Binary Tree, convert it into Doubly Linked List.
 * The left pointer of the binary tree node should act as a previous node for
 * created DLL and right pointer should act as next node.
 * 
 * This solution uses constant space and time complexity is O(numberOfItems).
 * 
 * @author Mukul Bansal
 *
 */
public class BinaryTreeToDoublyLinkedList {

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

		System.out.println("Values of tree in sorted Order are- ");
		tree.display(tree.root);

		tree.root = convertToDLL(tree.root);

		// Traversing the DLL from root to reach the start
		while (tree.root.leftChild != null) {
			tree.root = tree.root.leftChild;
		}

		// Printing the DLL
		System.out.println("\nDLL- ");
		printDLL(tree.root);
	}

	private static Node convertToDLL(Node node) {

		if (node.leftChild == null && node.rightChild == null) {
			return node;
		}

		Node tmpNode;

		if (node.leftChild != null) {
			tmpNode = convertToDLL(node.leftChild);
			while (tmpNode.rightChild != null) {
				tmpNode = tmpNode.rightChild;
			}
			tmpNode.rightChild = node;
			node.leftChild = tmpNode;

		}

		if (node.rightChild != null) {
			tmpNode = convertToDLL(node.rightChild);
			while (tmpNode.leftChild != null) {
				tmpNode = tmpNode.leftChild;
			}
			tmpNode.leftChild = node;
			node.rightChild = tmpNode;
		}

		return node;
	}

	private static void printDLL(Node root) {
		while (root.rightChild != null) {
			System.out.print(root.data);
			root = root.rightChild;
			System.out.print(" <==> ");
		}
		System.out.print(root.data + "\n");
	}

}
