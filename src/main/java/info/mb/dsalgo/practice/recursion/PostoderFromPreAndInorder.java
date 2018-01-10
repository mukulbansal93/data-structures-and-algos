package info.mb.dsalgo.practice.recursion;

import java.util.Arrays;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/print-postorder-from-given-inorder-and-preorder-traversals/
 * 
 * @author Mukul Bansal
 *
 */
public class PostoderFromPreAndInorder {
	public static void main(String... s) {
		int in[] = { 4, 2, 5, 1, 3, 6 };
		int pre[] = { 1, 2, 4, 5, 3, 6 };
		System.out.println("Postorder Traversal is- ");
		printPostOrder(in, pre);
	}

	private static void printPostOrder(int[] in, int[] pre) {

		if (pre.length < 1)
			return;

		int index = search(in, pre[0]);

		// RECURSIING LEFT SUB-TREE
		printPostOrder(Arrays.copyOfRange(in, 0, index), Arrays.copyOfRange(pre, 1, 1 + index));
		// RECURSIING RIGHT SUB-TREE
		printPostOrder(Arrays.copyOfRange(in, index + 1, in.length), Arrays.copyOfRange(pre, 1 + index, pre.length));
		// PRINTING ROOT
		System.out.print(pre[0] + " ");
	}

	private static int search(int[] in, int pre) {
		int index = -1;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre) {
				index = i;
			}
		}
		return index;
	}
}
