package info.mb.dsalgo.practice.dp;

import java.util.ArrayList;
import java.util.List;

public class KnapsackToReturnListOfValues {

	public static void main(String... s) {
		int values[] = { 60, 100, 120 };
		int weights[] = { 10, 20, 30 };
		int allowedWeight = 50;
		List<Integer> knapsackValue = knapsack(values, weights, allowedWeight, weights.length);
		System.out.println(knapsackValue.toString());
	}

	private static List<Integer> knapsack(int[] values, int[] weights, int allowedWeight, int n) {

		List<Integer> retval = new ArrayList<Integer>();

		if (n == 0 || allowedWeight == 0) {
			return retval;
		}

		if (weights[n - 1] > allowedWeight) {
			retval = knapsack(values, weights, allowedWeight, n - 1);
		} else {
			List<Integer> retval1 = knapsack(values, weights, allowedWeight - weights[n - 1], n - 1);
			retval1.add(values[n-1]);
			List<Integer> retval2 = knapsack(values, weights, allowedWeight, n - 1);
			if (sumOfList(retval1) > sumOfList(retval2)) {
				retval = retval1;
			} else {
				retval = retval2;
			}
		}

		return retval;
	}

	private static int sumOfList(List<Integer> list) {
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum = sum + list.get(0);
		}
		return sum;
	}
}
