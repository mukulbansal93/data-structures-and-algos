package info.mb.dsalgo.challenge.hackerearth.capillary;

import java.util.Scanner;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/capillary-software-engineer-hiring-challenge/problems/8644006cd22841b79035f9406f2a6453/
 * 
 * @author Mukul Bansal
 *
 */
public class MinimumNumber {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		int noOfElements = 0;
		int noOfSegments = 0;
		int Q = 0;
		int[] A;
		int min = 0;
		for (int i = 0; i < noOfTestCases; i++) {
			// READING INPUT
			noOfElements = s.nextInt();
			noOfSegments = s.nextInt();
			Q = s.nextInt();
			A = new int[noOfElements];
			for (int j = 0; j < noOfElements; j++) {
				A[j] = s.nextInt();
			}
			// PROCESSING
			min = getMinAmongMaxSegments(A, noOfSegments, noOfElements);
			// FIND MAX IN P
			if (min < Q) {
				System.out.println(min);
			} else {
				System.out.println("NO");
			}
		}
		s.close();
	}

	private static int getMinAmongMaxSegments(int[] a, int noOfSegments, int noOfElements) {

		if (noOfSegments > noOfElements) {
			return Integer.MAX_VALUE;
		}

		if (noOfSegments == 1) {
			return findmax(a);
		} else if (noOfSegments == 2) {
			return Math.min(a[0], a[noOfElements - 1]);
		} else {
			return findmin(a);
		}

	}

	// HELPER FUNCTIONS
	private static int findmax(int A[]) {
		int max = A[0];
		for (int i = 0; i < A.length; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
	}

	private static int findmin(int A[]) {
		int min = A[0];
		for (int i = 0; i < A.length; i++) {
			if (min > A[i]) {
				min = A[i];
			}
		}
		return min;
	}

}
