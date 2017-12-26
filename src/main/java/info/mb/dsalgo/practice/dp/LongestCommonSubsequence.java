package info.mb.dsalgo.practice.dp;

import java.util.Scanner;

public class LongestCommonSubsequence {

	private static int memo[][];
	private static int memoHits = 0;
	private static int recursionHits = 0;

	public static void main(String... s) {

		Scanner sc = new Scanner(System.in);

		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		memo = new int[str1.length()][str2.length()];

		longestCommonSubseq(str1, str2);

		System.out.println(memo[str1.length() - 1][str2.length() - 1]);
		System.out.println("memoHits- " + memoHits);
		System.out.println("recursionHits- " + recursionHits);

		sc.close();

	}

	private static int longestCommonSubseq(String str1, String str2) {

		int retval;

		if (str1.length() < 1 || str2.length() < 1)
			return 0;

		if (memo[str1.length() - 1][str2.length() - 1] != 0) {
			memoHits++;
			return memo[str1.length() - 1][str2.length() - 1];
		}

		recursionHits++;

		if (str1.substring(0, 1).equalsIgnoreCase(str2.substring(0, 1)))
			retval = 1 + longestCommonSubseq(str1.substring(1), str2.substring(1));
		else
			retval = Math.max(longestCommonSubseq(str1.substring(1), str2),
					longestCommonSubseq(str1, str2.substring(1)));

		memo[str1.length() - 1][str2.length() - 1] = retval;

		return retval;
	}
}