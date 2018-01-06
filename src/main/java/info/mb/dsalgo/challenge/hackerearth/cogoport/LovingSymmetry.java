package info.mb.dsalgo.challenge.hackerearth.cogoport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/cogoport-developer-hiring-challenge/problems/82f109cd0c204171ba29e7f2b9a7575b/
 * 
 * @author Mukul Bansal
 *
 */
public class LovingSymmetry {

	final static String ONE = "1";
	final static String ZERO = "0";

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String s[] = br.readLine().split(" ");
			System.out.println(isSymmetryPossible(s[0], s[1]));
		}
	}

	private static StringBuilder isSymmetryPossible(String N, String K) {

		int n = Integer.parseInt(N);
		int k = Integer.parseInt(K);

		if (k == 1 || n == 2)
			return new StringBuilder("impossible");
		if (k == 2 && n % 2 == 0)
			return new StringBuilder("impossible");

		StringBuilder s = new StringBuilder(100000);

		if (n <= k) {
			s.append(ONE);
			for (int i = 0; i < n - 2; i++) {
				s.append(ZERO);
			}
			s.append(ONE);
		} else {
			StringBuilder tmp = new StringBuilder(100000);
			if (n % k == 0) {
				tmp.append(ONE);
				for (int i = 0; i < k - 2; i++) {
					tmp.append(ZERO);
				}
				tmp.append(ONE);
				for (int i = 0; i < n / k; i++) {
					s.append(tmp);
				}
			} else {
				int rem = n % k;
				for (int i = 0; i < k - 1; i++) {
					if (k - i == rem) {
						tmp.append(ONE);
					} else {
						tmp.append(ZERO);
					}
				}
				tmp.append(ONE);
				for (int i = 0; i < n / k; i++) {
					s.append(tmp);
				}
				StringBuilder bkpS = s;
				s = new StringBuilder(s.substring(k - rem, k));
				s.append(bkpS);
			}
		}

		return s;
	}

}
