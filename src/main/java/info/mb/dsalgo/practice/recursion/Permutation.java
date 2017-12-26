package info.mb.dsalgo.practice.recursion;

import info.mb.dsalgo.util.Utility;

/**
 * This class contains various methods to find all different permutations of a
 * string.
 * 
 * @author Mukul Bansal
 *
 */
public class Permutation {

	public static void main(String... s) {
		String str = "abcde";

		System.out.println("Permutation Recursion Method 1- ");
		permutation1("", str);

		System.out.println("Permutation Recursion Method 2- ");
		permutation2(str, 0, str.length() - 1);

		System.out.println("Permutation Recursion Method 3(Lexicographic Order)- ");
		System.out.println(str);
		permutationInLexicographicOrder(str);
	}

	private static void permutation1(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation1(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}

	private static void permutation2(String str, int startIndex, int lastIndex) {
		if (startIndex == lastIndex)
			System.out.println(str);
		else {
			for (int i = startIndex; i <= lastIndex; i++) {
				str = Utility.swap(str, startIndex, i);
				permutation2(str, startIndex + 1, lastIndex);
			}
		}
	}

	private static void permutationInLexicographicOrder(String str) {
		char[] chars = str.toCharArray();

		// STEP 1: Find the largest x such that chars[x]<chars[x+1].
		// (If there is no such x, chars is the last permutation.)
		// Link for the algorithm-
		// https://www.quora.com/How-would-you-explain-an-algorithm-that-generates-permutations-using-lexicographic-ordering
		int largestI = -1;
		for (int i = 0; i < chars.length - 1; i++) {
			if (chars[i] < chars[i + 1]) {
				largestI = i;
			}
		}

		if (largestI == -1) {
			return;
		}

		// STEP 2: Find the largest y such that chars[x]<chars[y].
		int largestJ = -1;
		for (int j = 0; j < chars.length; j++) {
			if (chars[largestI] < chars[j]) {
				largestJ = j;
			}
		}

		// STEP 3: Swap chars[x] and chars[y].
		str = Utility.swap(str, largestI, largestJ);
		chars = str.toCharArray();

		// STEP 4: Reverse chars[x+1 .. n].
		chars = Utility.reverse(chars, largestI + 1, chars.length);

		System.out.println(new String(chars));

		permutationInLexicographicOrder(new String(chars));
	}

}
