package info.mb.dsalgo.practice.recursion;

import java.util.Arrays;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
 * 
 * @author Mukul Bansal
 *
 */
public class MobileNumberKeypad {

	private static int count = 0;
	private static int memoHits = 0;
	private static int recursionHits = 0;

	private static int[][] memo;

	//@formatter:off
	private static int [][]keypad=new int[][] {
		{0,8},
		{1,2,4},
		{2,1,3,5},
		{3,2,6},
		{4,1,5,7},
		{5,2,4,6,8},
		{6,3,5,9},
		{7,4,8},
		{8,7,5,9,0},
		{9,8,6}
	};
	//@formatter:on

	public static void main(String... s) {
		int maxN = 5;
		int[] arr = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] output = new int[maxN];
		memo = new int[10][maxN];
		printCombinationsUsingRecursion(arr, output, 0, maxN);
		System.out.println("Total count- " + count);
		System.out.println("Total count- " + countCombinationsUsingDP(arr, 0, maxN));
		System.out.println("memoHits- " + memoHits);
		System.out.println("recursionHits- " + recursionHits);
	}

	public static void printCombinationsUsingRecursion(int[] arr, int[] output, int n, int maxN) {

		if (n == maxN) {
			count++;
			System.out.println(Arrays.toString(output));
			return;
		}

		for (int i : arr) {
			output[n] = i;
			printCombinationsUsingRecursion(keypad[i], output, n + 1, maxN);
		}
	}

	/**
	 * @param arr
	 * @param n
	 * @param maxN
	 * @return
	 */
	public static int countCombinationsUsingDP(int[] arr, int n, int maxN) {
		int count = 0;
		if (n == maxN - 1) {
			count = count + 1;
		} else {
			for (int i : arr) {
				if (memo[i][n] != 0) {
					memoHits++;
				} else {
					recursionHits++;
					memo[i][n] = countCombinationsUsingDP(keypad[i], n + 1, maxN);
				}
				count = count + memo[i][n];
			}
		}
		return count;
	}
}
