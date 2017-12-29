package info.mb.dsalgo.practice.dp;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class KnapsackToReturnTotalValue {

	private static int recursionHits = 0;
	private static int memoHits = 0;
	private static int[][] memo;

	public static void main(String... s) {
		int values[] = { 60, 100, 120 };
		int weights[] = { 10, 20, 30 };
		int allowedWeight = 50;
		memo = new int[weights.length + 1][allowedWeight + 1];
		int knapsackValue = knapsack(values, weights, allowedWeight, weights.length);
		System.out.println(knapsackValue);
		System.out.println("knapsackCalled-" + recursionHits);
		System.out.println("memoHits-" + memoHits);
	}

	private static int knapsack(int[] values, int[] weights, int allowedWeight, int n) {

		int retval;

		if (memo[n][allowedWeight] != 0) {
			memoHits++;
			return memo[n][allowedWeight];
		}
		
		recursionHits++;

		if (n == 0 || allowedWeight == 0) {
			return 0;
		}

		if (weights[n - 1] > allowedWeight) {
			retval = knapsack(values, weights, allowedWeight, n - 1);
		} else {
			retval = Math.max(values[n - 1] + knapsack(values, weights, allowedWeight - weights[n - 1], n - 1),
					knapsack(values, weights, allowedWeight, n - 1));
		}

		memo[n][allowedWeight] = retval;

		return retval;
	}
}
