package info.mb.dsalgo.practice.general;

import java.util.Scanner;

/**
 * Problem Statement-
 * https://www.hackerearth.com/problem/algorithm/trailing-zeros/
 * 
 * @author Mukul Bansal
 *
 */
public class TrailingZeroes {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		System.out.println(trailingZeroesinFactorial(i));
		s.close();
	}

	private static long trailingZeroesinFactorial(int i) {
		long noOfZeroes = 0;

		if (i == 0) {
			return 0;
		}

		long l = 1;
		while (i > l * 5) {
			noOfZeroes = noOfZeroes + (i / (l * 5));
			l = l * 5;
		}

		return noOfZeroes;
	}

}
