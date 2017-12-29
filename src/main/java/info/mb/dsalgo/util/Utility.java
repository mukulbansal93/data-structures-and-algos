package info.mb.dsalgo.util;

/**
 * 
 * @author Mukul Bansal
 *
 */
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

	public static int getCharPositionInAlphabets(char c) {
		int charASCII = (int) c;
		int temp_integer_upper = 64; // for upper case
		int temp_integer_lower = 96; // for lower case
		if (charASCII <= 90 & charASCII >= 65)
			return charASCII - temp_integer_upper;
		else if (charASCII <= 122 & charASCII >= 97) {
			return charASCII - temp_integer_lower;
		} else {
			return -1;
		}
	}

	public static char getCharFromPositionInAlphabets(int position) {
		int temp_integer_lower = 96; // for lower case
		return (char) (position + temp_integer_lower);
	}
	
}
