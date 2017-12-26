package info.mb.dsalgo.practice.dp;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 * 
 * @author Mukul Bansal
 *
 */
public class CoinExchange {

	private static int recursionHits = 0;
	private static int memoHits = 0;
	private static int[][] memo;

	public static void main(String... s) {
		int N = 4;
		int S[] = { 1, 2, 3 };
		memo = new int[S.length + 1][N + 1];
		System.out.println(coinExchange(N, S, S.length));
		System.out.println("recusrionHits-" + recursionHits);
		System.out.println("memoHits-" + memoHits);
	}

	private static int coinExchange(int N, int[] S, int n) {

		// If N is 0 then there is 1 solution (do not include any coin)
		if (N == 0)
			return 1;

		// If N is less than 0 then no solution exists
		if (N < 0)
			return 0;

		// If there are no coins and N is greater than 0, then no solution exist
		if (n <= 0 && N >= 1)
			return 0;

		if (memo[n][N] != 0) {
			memoHits++;
			return memo[n][N];
		}

		recursionHits++;

		int retval = coinExchange(N - S[n - 1], S, n) + coinExchange(N, S, n - 1);
		memo[n][N] = retval;
		return retval;
	}
}
