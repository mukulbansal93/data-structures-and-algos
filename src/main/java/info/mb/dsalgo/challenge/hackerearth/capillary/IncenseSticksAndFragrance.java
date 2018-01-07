package info.mb.dsalgo.challenge.hackerearth.capillary;

import java.util.Scanner;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/capillary-software-engineer-hiring-challenge/problems/77d8d195a86e4717af508e69a3e2b8db/
 * 
 * @author Mukul Bansal
 *
 */
public class IncenseSticksAndFragrance {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int Ax = s.nextInt();
		int Ay = s.nextInt();
		int Bx = s.nextInt();
		int By = s.nextInt();
		int positions = s.nextInt();
		int[] Px = new int[positions];
		int[] Py = new int[positions];
		for (int i = 0; i < positions; i++) {
			Px[i] = s.nextInt();
		}
		for (int i = 0; i < positions; i++) {
			Py[i] = s.nextInt();
		}
		int timers = s.nextInt();
		for (int i = 0; i < timers; i++) {
			int time = s.nextInt();
			System.out.print(positionsAffected(Ax, Ay, Bx, By, positions, Px, Py, time));
			System.out.print(" ");
		}
		s.close();
	}

	private static int positionsAffected(int ax, int ay, int bx, int by, int positions, int[] px, int[] py, int time) {

		int positionsAffected = 0;

		for (int i = 0; i < positions; i++) {

			int aReachingtime = (int) Math
					.ceil(Math.sqrt(((px[i] - ax) * (px[i] - ax)) + ((py[i] - ay) * (py[i] - ay))));

			int bReachingtime = (int) Math
					.ceil(Math.sqrt(((px[i] - bx) * (px[i] - bx)) + ((py[i] - by) * (py[i] - by))));

			if (time >= aReachingtime && time >= bReachingtime) {
				positionsAffected++;
			}

		}

		return positionsAffected;
	}

}
