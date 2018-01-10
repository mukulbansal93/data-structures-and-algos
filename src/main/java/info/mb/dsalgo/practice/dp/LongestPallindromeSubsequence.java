package info.mb.dsalgo.practice.dp;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/
 * 
 * @author Mukul Bansal
 *
 */
public class LongestPallindromeSubsequence {

	public static void main(String[] args) {
		String s = "mukulm";
		System.out.print("Length of longest pallindrome- ");
		System.out.println(longestPallindromeLength(s));
	}

	/**
	 * The characters need not be contiguous.
	 * 
	 * @param s
	 * @return
	 */
	private static int longestPallindromeLength(String s) {

		if (s.length() == 1) {
			return 1;
		}

		if (s.charAt(0) == s.charAt(s.length() - 1)) {
			return 2 + longestPallindromeLength(s.substring(1, s.length() - 1));
		} else {
			int a = longestPallindromeLength(s.substring(0, s.length() - 1));
			int b = longestPallindromeLength(s.substring(1, s.length()));
			return Math.max(a, b);
		}
	}

}
