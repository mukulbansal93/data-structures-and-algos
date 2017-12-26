package info.mb.dsalgo.challenge.hackerearth.thoughtworks;

import java.util.Scanner;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/thoughtworks-women-hiring-challenge-1/algorithm/bob-and-gcd-d6d86b3b/
 * 
 * @author Mukul Bansal
 *
 */
class BobAndGcd {

	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		long t = s.nextLong();
		int[] arr = new int[1000000];
		// System.out.println("t-" + t);

		for (long counter = 0; counter < t; counter++) {

			int k = s.nextInt();
			// System.out.println("k-" + k);
			int n = s.nextInt();
			// System.out.println("n-" + n);

			for (int i = 0; i < n; i++) {
				arr[i] = s.nextInt();
			}

			int elementClosestToKIndex = 0;
			long closestToK = Math.abs(arr[0] - k);
			long kBy2 = k / 2;
			// System.out.println("kBy2-" + kBy2);
			long numOfSteps = 0;

			for (int i = 0; i < n; i++) {

				if (Math.abs(arr[i] - k) < closestToK) {
					closestToK = Math.abs(arr[i] - k);
					elementClosestToKIndex = i;
				} else {
					// DO Nothing
				}
			}

			// System.out.println("closest element-" + arr[elementClosestToKIndex]);

			if (arr[elementClosestToKIndex] == k) {
				// DO Nothing
			} else {
				numOfSteps = numOfSteps + (Math.abs(arr[elementClosestToKIndex] - k));
				arr[elementClosestToKIndex] = k;
			}

			// System.out.println("numOfSteps-" + numOfSteps);

			for (int i = 0; i < n; i++) {
				long rem = arr[i] % k;
				// System.out.println("rem-" + rem);
				if (rem != 0) {
					if (rem > kBy2) {
						// numOfSteps = numOfSteps + kBy2;
						numOfSteps = numOfSteps + (k - rem);
					} else {
						numOfSteps = numOfSteps + rem;
					}
				} else {
					// DO Nothing
				}
			}

			System.out.println(numOfSteps);
		}

		s.close();

	}
}