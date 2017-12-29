package info.mb.dsalgo.practice.recursion;

import info.mb.dsalgo.util.Constants;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class AllPossibleSubsets {

	public static void main(String... s) {
		int[] arr = { 1, 2, 3};
		int[] subset = new int[arr.length];
		subsets(arr, subset, 0);
	}

	private static void subsets(int[] arr, int subset[], int n) {
		if (n == arr.length) {
			printSubset(subset);
		} else {
			subset[n] = 0;
			subsets(arr, subset, n + 1);
			subset[n] = arr[n];
			subsets(arr, subset, n + 1);
		}
	}

	private static void printSubset(int arr[]) {
		for (int i : arr) {
			if (i != 0) {
				System.out.print(i);
				System.out.print(Constants.SPACE);
			}
		}
		System.out.println("");
	}
}
