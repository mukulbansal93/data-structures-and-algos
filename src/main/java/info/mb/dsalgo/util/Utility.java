package info.mb.dsalgo.util;

public class Utility {

	/**
	 * Swaps the i th and j th element of the string.
	 * 
	 * @param str
	 * @param i
	 * @param j
	 * @return
	 */
	public static String swap(String str, int i, int j) {
		char temp;
		char[] charArray = str.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	/**
	 * Reverses an array from i to j position. i inclusive, j exclusive
	 * 
	 * @param chars
	 * @param i
	 * @param j
	 * @return
	 */
	public static char[] reverse(char[] chars, int i, int j) {
		int swaps = (j - i) / 2;
		for (int x = 0; x < swaps; x++) {
			if (i != j) {
				char temp = chars[i];
				chars[i] = chars[j - 1];
				chars[j - 1] = temp;
				i++;
				j--;
			}
		}
		return chars;
	}
}
