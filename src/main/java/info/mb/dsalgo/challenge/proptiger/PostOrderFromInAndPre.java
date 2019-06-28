package info.mb.dsalgo.challenge.proptiger;

import java.util.Arrays;

/**
 * 
 * @author mukulbansal
 *
 */
public class PostOrderFromInAndPre {

	public static void main(String... s) {
		int input1 = 6;
		int[] input2 = { 4, 2, 5, 1, 3, 6 };
		int[] input3 = { 1, 2, 4, 5, 3, 6 };
		int[] solution = new PostOrderFromInAndPre().findPostOrder(input1, input2, input3);
		System.out.println(Arrays.toString(solution));
	}

	public int[] findPostOrder(int input1, int[] input2, int[] input3) {
		if (input1 == 0) {
			return new int[0];
		}

		if (input1 == 1) {
			return input2;
		}

		int root = input3[0];

		int indexOfRootInInorder = indexOf(root, input2);
		int[] leftSubTree = findPostOrder(indexOfRootInInorder, Arrays.copyOf(input2, indexOfRootInInorder),
				Arrays.copyOfRange(input3, 1, 1 + indexOfRootInInorder));

		int[] rightSubTree = findPostOrder(input1 - indexOfRootInInorder - 1,
				Arrays.copyOfRange(input2, indexOfRootInInorder + 1, input2.length),
				Arrays.copyOfRange(input3, indexOfRootInInorder + 1, input2.length));

		return join(root, leftSubTree, rightSubTree);

	}

	private int[] join(int root, int[] leftSubTree, int[] rightSubTree) {
		int arrayLength = 1 + leftSubTree.length + rightSubTree.length;
		int[] postOrder = new int[arrayLength];
		postOrder[arrayLength - 1] = root;
		int counter = 0;
		if (leftSubTree.length > 0) {
			for (int i = 0; i < leftSubTree.length; i++) {
				postOrder[counter] = leftSubTree[i];
				counter++;
			}
		}
		if (rightSubTree.length > 0) {
			for (int i = 0; i < rightSubTree.length; i++) {
				postOrder[counter] = rightSubTree[i];
				counter++;
			}
		}
		return postOrder;
	}

	private int indexOf(int root, int[] inOrder) {
		int index = -1;
		for (int i = 0; i < inOrder.length; i++) {
			if (inOrder[i] == root) {
				index = i;
			}
		}
		return index;
	}

}
