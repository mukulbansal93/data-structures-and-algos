package info.mb.dsalgo.practice.backtracking;

public class KnightsTour {

	public static int n = 8;

	// This is the optimized move sequence, otherwise it can take more than an
	// hour or so to solve it for 8X8.
	public static int iMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	public static int jMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String... s) {

		int solution[][] = new int[n][n];

		// Initializing the solution matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				solution[i][j] = -1;
			}
		}

		solution[0][0] = 0;

		if (generateKnightsTour(0, 0, 1, solution)) {
			printSolution(solution);
		} else {
			System.out.println("No solution exists...");
		}
	}

	private static boolean generateKnightsTour(int currentI, int currentJ, int moveNum, int solution[][]) {

		if (moveNum == n * n) {
			return true;
		}

		// Trying all 8 moves possible from current location
		for (int i = 0; i < 8; i++) {
			int nextI = currentI + iMove[i];
			int nextJ = currentJ + jMove[i];
			if (isValidNextMove(nextI, nextJ, solution)) {
				solution[nextI][nextJ] = moveNum;
				if (generateKnightsTour(nextI, nextJ, moveNum + 1, solution)) {
					return true;
				} else {
					// Backtracking Step
					solution[nextI][nextJ] = -1;
				}
			}
		}
		return false;
	}

	private static boolean isValidNextMove(int i, int j, int solution[][]) {
		return (i >= 0 && i < n && j >= 0 && j < n && solution[i][j] == -1);
	}

	public static void printSolution(int solution[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(solution[i][j] + " ");
			}
			System.out.println();
		}
	}

}
