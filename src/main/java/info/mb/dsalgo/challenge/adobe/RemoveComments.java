package info.mb.dsalgo.challenge.adobe;

import java.util.Scanner;

/**
 * WAP to print all code comments. All java code comments types including
 * multi-line comments need to be handled.
 * 
 * @author mukulbansal
 *
 */
public class RemoveComments {
	public static void main(String args[]) throws Exception {

		Scanner scanner = new Scanner(System.in);
		boolean multi = false;
		for (int i = 0; i < 20; i++) {
			String line = scanner.nextLine();
			line = line.trim();

			if (multi) {
				if (line.endsWith("*/")) {
					System.out.println(line);
					multi = false;
				} else {
					System.out.println(line);
				}
			} else {
				if (line.startsWith("//")) {
					System.out.println(line);
				} else if (line.startsWith("/*") && line.endsWith("*/")) {
					System.out.println(line);
				} else if (line.startsWith("/*") && !line.endsWith("*/")) {
					System.out.println(line);
					multi = true;
				} else {
					// Code line encountered.
					continue;
				}

			}
		}
		scanner.close();
	}
}