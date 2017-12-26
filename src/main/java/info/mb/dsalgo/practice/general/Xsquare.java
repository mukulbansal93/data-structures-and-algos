package info.mb.dsalgo.practice.general;

import java.util.Scanner;

import info.mb.dsalgo.util.Constants;

/**
 * Problem Statement-
 * https://www.hackerearth.com/practice/algorithms/dynamic-programming/introduction-to-dynamic-programming-1/practice-problems/algorithm/xsquare-and-two-arrays/
 * 
 * @author Mukul Bansal
 *
 */
public class Xsquare {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String arraySize = s.nextLine();
		int A_SIZE = Integer.parseInt(arraySize.split(Constants.SPACE)[0]);
		int B_SIZE = Integer.parseInt(arraySize.split(Constants.SPACE)[1]);
		int[] A = new int[A_SIZE];
		int[] B = new int[B_SIZE];
		String[] array = s.nextLine().split(Constants.SPACE);
		for (int i = 0; i < A_SIZE; i++) {
			A[i] = Integer.parseInt(array[i]);
		}
		array = s.nextLine().split(Constants.SPACE);
		for (int i = 0; i < B_SIZE; i++) {
			B[i] = Integer.parseInt(array[i]);
		}
		String query = s.nextLine();
		while (query != null) {
			System.out.println(eval(A, B, query));
			if (s.hasNextLine()) {
				query = s.nextLine();
			} else {
				break;
			}
		}
		s.close();
	}

	private static long eval(int[] A, int[] B, String query) {
		long retval = 0L;
		String[] queryParams = query.split(Constants.SPACE);
		int I = Integer.parseInt(queryParams[1]);
		int J = Integer.parseInt(queryParams[2]);
		if (queryParams[0].equals("1")) {
			for (int i = I; i <= J; i = i + 2) {
				retval = retval + A[i - 1];
			}
			for (int i = I + 1; i <= J; i = i + 2) {
				retval = retval + B[i - 1];
			}
		} else if ((queryParams[0].equals("2"))) {
			for (int i = I; i <= J; i = i + 2) {
				retval = retval + B[i - 1];
			}
			for (int i = I + 1; i <= J; i = i + 2) {
				retval = retval + A[i - 1];
			}
		}
		return retval;
	}

}
