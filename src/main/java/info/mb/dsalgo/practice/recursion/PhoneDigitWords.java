package info.mb.dsalgo.practice.recursion;

import java.util.Arrays;

public class PhoneDigitWords {

	//@formatter:off
	private static char[][] phoneMap = new char[][] {
		{},
		{},
		{'a','b','c'},
		{'d','e','f'},
		{'g','h','i'},
		{'j','k','l'},
		{'m','n','o'},
		{'p','q','r','s'},
		{'t','u','v'},
		{'w','x','y','z'}
	};
	//@formatter:on

	public static void main(String... s) {
		int[] keys = new int[] { 2, 3, 4 }; 
		char[] output = new char[keys.length];
		printAllCombinations(keys, 0, keys.length, output);
	}

	private static void printAllCombinations(int[] keys, int counter, int wordLength, char[] output) {

		for (int i = 0; i < phoneMap[keys[counter]].length; i++) {
			output[counter] = phoneMap[keys[counter]][i];
			if (counter == wordLength - 1) {
				System.out.println(Arrays.toString(output));
			}
			if (counter != wordLength - 1) {
				printAllCombinations(keys, counter + 1, wordLength, output);
			}
		}

	}

}