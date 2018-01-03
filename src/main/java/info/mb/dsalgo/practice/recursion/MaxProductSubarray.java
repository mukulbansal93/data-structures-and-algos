package info.mb.dsalgo.practice.recursion;

/**
 * Problem Statement- https://www.geeksforgeeks.org/maximum-product-subarray/
 * 
 * @author Mukul Bansal
 *
 */
public class MaxProductSubarray {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 0, -2, -40 };
		System.out.println(maxProductSubarray(arr));
	}

	private static int maxProductSubarray(int[] arr) {

		int globalMax = 1;

		int maxSoFar = 1;
		int minSoFar = 1;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				maxSoFar = 1;
				minSoFar = 1;
			} else if (arr[i] > 0) {
				maxSoFar = maxSoFar * arr[i];
				minSoFar = Math.min(minSoFar, 1);
			} else {
				int temp = maxSoFar;
				maxSoFar = Math.max(minSoFar * arr[i], 1);
				minSoFar = temp * arr[i];
			}
		}

		if (maxSoFar > globalMax) {
			globalMax = maxSoFar;
		}

		return globalMax;
	}

}
