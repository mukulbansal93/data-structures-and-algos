package info.mb.dsalgo.practice.general;

import java.util.Scanner;

import info.mb.dsalgo.util.Constants;

/**
 * Problem Statement-
 * https://www.hackerearth.com/problem/algorithm/chandu-and-his-game/
 * 
 * @author Mukul Bansal
 *
 */
public class MoveStonesToCorner {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] line = s.nextLine().split(Constants.SPACE);
		int n = Integer.parseInt(line[0]);
		int k = Integer.parseInt(line[1]);
		String[] I = s.nextLine().split(Constants.SPACE);
		String[] J = s.nextLine().split(Constants.SPACE);
		System.out.println(movesRequired(n, k, I, J));
		s.close();
	}

	private static int movesRequired(int n, int k, String[] I, String[] J) {
		int movesRequired = 0;
		for (int i = 0; i < k; i++) {
			int x = n - Integer.parseInt(I[i]);
			int y = n - Integer.parseInt(J[i]);

			if (Integer.parseInt(I[i]) == 1 && Integer.parseInt(J[i]) == 1) {
				continue;
			}
			if (Integer.parseInt(I[i]) == 1 && Integer.parseInt(J[i]) == n) {
				continue;
			}
			if (Integer.parseInt(I[i]) == n && Integer.parseInt(J[i]) == n) {
				continue;
			}
			if (Integer.parseInt(I[i]) == n && Integer.parseInt(J[i]) == 1) {
				continue;
			}

			if (x > n / 2) {
				movesRequired = movesRequired + Integer.parseInt(I[i]);
			} else {
				movesRequired = movesRequired + x;
			}

			if (y > n / 2) {
				movesRequired = movesRequired + Integer.parseInt(J[i]);
			} else {
				movesRequired = movesRequired + y;
			}

		}
		return movesRequired;
	}

}
