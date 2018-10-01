package info.mb.dsalgo.challenge.hackerearth.bakerhughes;

/**
 * You are given an array A of N integers. Now you can remove at most one index
 * from the array. Your goal is to maximize the length of the subarray that
 * contains all the numbers prime. Print the largest length subarray that you
 * can achieve by removing at most one element from the array A.
 * <p>
 * Sample Input- 7 2 8 5 7 9 5 7
 * <p>
 * Sample Output- 4
 * <p>
 * Explanation- If we remove the number 9 which is at index 5 then the remaining
 * array contains a subarray whose length is 4 which is maximum.
 * 
 * @author mukulbansal
 *
 */
public class LongestPrimeSubArray {

	private static int[] inputArr = { 2, 8, 5, 7, 9, 5, 7 };

	private static int maxLenPrimeArr = 0;

	public static void main(String... s) {
		int maxLenPrimeArrtillNow = 0;
		int maxLenPrimeAfterRemovedOne = 0;
		boolean removedOne = false;

		for (int number : inputArr) {
			boolean isPrime = isPrime(number);

			if (isPrime) {
				if (removedOne) {
					maxLenPrimeArrtillNow++;
					maxLenPrimeAfterRemovedOne++;
				} else {
					maxLenPrimeArrtillNow++;
				}
			}

			if (!isPrime && maxLenPrimeArrtillNow > 0) {
				if (!removedOne) {
					removedOne = true;
				} else {
					updateMaxPrimeLen(maxLenPrimeArrtillNow);
					maxLenPrimeArrtillNow = maxLenPrimeAfterRemovedOne;
				}
			}
		}

		updateMaxPrimeLen(maxLenPrimeArrtillNow);

		System.out.println(maxLenPrimeArr);
	}

	private static void updateMaxPrimeLen(int maxLenPrimeArrtillNow) {
		if (maxLenPrimeArr < maxLenPrimeArrtillNow) {
			maxLenPrimeArr = maxLenPrimeArrtillNow;
		}
	}

	private static boolean isPrime(int number) {
		if (number <= 1) {
			return false;
		}
		for (int counter = 2; counter <= Math.sqrt(number); counter++) {
			if (number % counter == 0) {
				return false;
			}
		}
		return true;
	}
}
