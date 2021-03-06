package info.mb.dsalgo.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String... s) {

		Scanner sc = new Scanner(System.in);

		int noOfElements = sc.nextInt();
		int[] arr = new int[noOfElements];

		for (int i = 0; i < noOfElements; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println("Using DP (Tabulation)-");
		System.out.println(longestIncSubseqUsingTabulation(arr));

		System.out.println("Using Recursion-");
		System.out.println(longestIncSubseqUsingRecusrion(arr, 0));

		sc.close();

	}

	private static int longestIncSubseqUsingTabulation(int[] arr) {

		int lis[] = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}

		System.out.println(Arrays.toString(lis));

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					int newLis = lis[j] + 1;
					if (newLis > lis[i]) {
						lis[i] = newLis;
					}
				}
			}
			System.out.println(Arrays.toString(lis));
		}

		int lisMax = lis[0];
		for (int i = 1; i < lis.length; i++) {
			if (lis[i] > lisMax) {
				lisMax = lis[i];
			}
		}

		return lisMax;
	}

	private static int longestIncSubseqUsingRecusrion(int[] arr, int n) {

		if (n == arr.length - 1) {
			return 1;
		}

		if (arr[n] < arr[n + 1]) {
			return 1 + longestIncSubseqUsingRecusrion(arr, n + 1);
		} else {
			return longestIncSubseqUsingRecusrion(arr, n + 1);
		}

	}
}
