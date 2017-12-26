package info.mb.dsalgo.challenge.hackerearth.ubona;

import java.util.Scanner;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/ubona-developer-hiring-challenge/algorithm/accomodation-a5c006f3/
 * 
 * @author Mukul Bansal
 *
 */
public class Accomodation {
	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);
		int noOfFloors = s.nextInt();
		int noOfPeople = s.nextInt();

		int[] floorCapacity = new int[noOfFloors];

		for (int i = 0; i < noOfFloors; i++) {
			floorCapacity[i] = s.nextInt();
		}

		System.out.println(count(floorCapacity, noOfFloors, noOfPeople));

		s.close();
	}

	public static int count(int floorCapacity[], int noOfFloors, int noOfPeople) {

		if (noOfPeople == 0)
			return 1;

		if (noOfPeople < 0)
			return 0;

		if (noOfFloors <= 0 && noOfPeople >= 1)
			return 0;

		return count(floorCapacity, noOfFloors - 1, noOfPeople)
				+ count(floorCapacity, noOfFloors, noOfPeople - floorCapacity[noOfFloors - 1]);
	}
}
