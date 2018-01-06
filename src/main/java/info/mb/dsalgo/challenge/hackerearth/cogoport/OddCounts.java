package info.mb.dsalgo.challenge.hackerearth.cogoport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/cogoport-developer-hiring-challenge/problems/1ce0ec2380c7463189b80b9891f7ffdd/
 * 
 * @author Mukul Bansal
 *
 */
public class OddCounts {

	static int oddCount;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder number = new StringBuilder(br.readLine());
		findSubstrings(number);
		System.out.println(oddCount);
	}

	private static void findSubstrings(StringBuilder number) {
		int len = number.length();
		int counter = 0;
		for (int i = len - 1; i >= 0; i--) {
			counter++;
			if (number.charAt(i) == '1')
				oddCount = oddCount + counter;
		}
	}
}
