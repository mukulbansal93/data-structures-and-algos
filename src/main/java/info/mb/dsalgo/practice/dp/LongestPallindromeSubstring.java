package info.mb.dsalgo.practice.dp;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * @author Mukul Bansal
 *
 */
public class LongestPallindromeSubstring {

	public static void main(String[] args) {
		String string = "xsmukumx";
		System.out.print("Length of longest pallindrome- ");
		System.out.println(longestPallindromeLength(string));
	}

	/**
	 * The characters need to be contiguous.
	 * 
	 * @param s
	 * @return
	 */
	private static int longestPallindromeLength(String s) {

		int l = s.length();
		int max = 0;
		for (int i = 0; i < l; i++) {
			if (s.charAt(i) == s.charAt(l - 1)) {
				max = (i == l - 1) ? max + 1 : max + 2;
				l--;
			} else {
				int a = longestPallindromeLength(s.substring(0, s.length() - 1));
				int b = longestPallindromeLength(s.substring(1, s.length()));
				max = Math.max(a, b);
				break;
			}
		}

		return max;
	}

}
