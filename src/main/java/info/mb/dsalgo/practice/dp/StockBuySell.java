package info.mb.dsalgo.practice.dp;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
 * 
 * @author Mukul Bansal
 *
 */
public class StockBuySell {

	public static void main(String[] args) {

		int[] stockPrice = { 10, 22, 5, 75, 65, 80 };
		int k = 5;

		System.out.print("Maximum Profit by buying or selling a stock at most once- ");
		System.out.println(maxProfitInOneTransaction(stockPrice));

		System.out.print("Maximum Profit by buying or selling a stock at most twice- ");
		System.out.println(maxProfitInKTransactions(stockPrice, 2));

		System.out.print("Maximum Profit by buying or selling a stock any number of times- ");
		System.out.println(maxProfitInAnyTransactions(stockPrice));

		System.out.print(String.format("Maximum Profit by buying or selling a stock at most %d times- ", k));
		System.out.println(maxProfitInKTransactions(stockPrice, k));

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static int maxProfitInAnyTransactions(int[] stockPrice) {

		int maxProfit = 0;
		boolean bought = false;
		int buyingPrice = Integer.MAX_VALUE;

		for (int i = 0; i < stockPrice.length; i++) {
			if (bought) {
				if (stockPrice[i] > buyingPrice && stockPrice[i] > stockPrice[i - 1]) {
					// DO Nothing. HOLD STOCKS
				} else {
					// SELL STOCKS
					maxProfit += stockPrice[i - 1] - buyingPrice;
					bought = false;
					buyingPrice = stockPrice[i];
				}
			} else {
				// DO Nothing. SEE IF THE PRICE DIPS MORE
				if (stockPrice[i] < buyingPrice) {
					buyingPrice = stockPrice[i];
				} else {
					// BUY STOCKS
					bought = true;
				}
			}
		}

		if (bought) {
			maxProfit += stockPrice[stockPrice.length - 1] - buyingPrice;
		}

		return maxProfit;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static int maxProfitInKTransactions(int[] stockPrice, int k) {
		return maxProfitInKTransactionsHelper(stockPrice, k, 0, Integer.MAX_VALUE, 0, false);
	}

	private static int maxProfitInKTransactionsHelper(int[] stockPrice, int maxTransactions, int currentStockPriceIndex,
			int buyingPrice, int currentTransaction, boolean bought) {

		if (currentTransaction >= maxTransactions || currentStockPriceIndex == stockPrice.length) {
			return 0;
		}

		if (bought) {
			int sold = stockPrice[currentStockPriceIndex] - buyingPrice + maxProfitInKTransactionsHelper(stockPrice,
					maxTransactions, currentStockPriceIndex + 1, Integer.MAX_VALUE, currentTransaction + 1, false);
			int hold = maxProfitInKTransactionsHelper(stockPrice, maxTransactions, currentStockPriceIndex + 1,
					buyingPrice, currentTransaction, true);
			return Math.max(sold, hold);
		} else {
			int buy = maxProfitInKTransactionsHelper(stockPrice, maxTransactions, currentStockPriceIndex + 1,
					stockPrice[currentStockPriceIndex], currentTransaction, true);
			int hold = maxProfitInKTransactionsHelper(stockPrice, maxTransactions, currentStockPriceIndex + 1,
					Integer.MAX_VALUE, currentTransaction, false);
			return Math.max(buy, hold);
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static int maxProfitInOneTransaction(int[] stockPrice) {
		int smallestSoFar = stockPrice[0];
		int maxProfit = 0;
		for (int i = 0; i < stockPrice.length; i++) {
			int diff = stockPrice[i] - smallestSoFar;
			if (diff > 0) {
				maxProfit = (maxProfit > diff) ? maxProfit : diff;
			} else {
				smallestSoFar = stockPrice[i];
			}
		}
		return maxProfit;
	}

}
