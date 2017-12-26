package info.mb.dsalgo.practice.general;

import java.util.Scanner;

import info.mb.dsalgo.util.Constants;

/**
 * Problem Statement-
 * https://www.hackerearth.com/problem/algorithm/little-shino-and-common-factors-99/
 * 
 * @author Mukul Bansal
 *
 */
public class LittleShinoAndCommonFactors {

	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
		String twoLongs = scanner.nextLine();
		String[] strings = twoLongs.trim().split(Constants.SPACE);
		long a = Long.parseLong(strings[0]);
		long b = Long.parseLong(strings[1]);
		System.out.println(noOfFactors(gcd(a, b)));
		scanner.close();
	}

	private static long noOfFactors(long gcd) {
		long noOfFactors = 0;

		for (int i = 1; i <= Math.sqrt(gcd); i++) {
			if (gcd % i == 0) {
				if (gcd / i == i) {
					noOfFactors++;
				} else {
					noOfFactors = noOfFactors + 2;
				}
			}
		}

		return noOfFactors;
	}

	private static long gcd(long a, long b) {
		// Everything divides 0
		if (a == 0 && b == 0)
			return 0;

		if (a == 0)
			return b;

		if (b == 0)
			return a;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}

}
