package info.mb.dsalgo.practice.backtracking;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class NQueensProblem {

	public static int n = 10;
	public static int diagonalIMoves[] = { 1, -1, 1, -1 };
	public static int diagonalJMoves[] = { 1, -1, -1, 1 };

	public static void main(String... s) {

		int solution[][] = new int[n][n];

		// Initializing the solution matrix
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				solution[i][j] = 0;
			}
		}

		// Invoking with j=-1 because we want the next queen to be placed after jth
		// position i.e. from j+1 onwards.
		if (solveNQueens(0, -1, 0, solution)) {
			printSolution(solution);
		} else {
			System.out.println("No solution exists...");
		}

	}

	private static boolean solveNQueens(int i, int j, int k, int[][] solution) {

		// Checks if the solution is complete or not.
		if (k == n) {
			return true;
		}

		// Generates next candidate and verifies it.
		for (int iCounter = i; iCounter < n; iCounter++) {
			for (int jCounter = j + 1; jCounter < n; jCounter++) {
				boolean isAValidCandidate = isAValidCandidate(iCounter, jCounter, solution, k);
				if (isAValidCandidate) {
					solution[iCounter][jCounter] = 1;
					if (solveNQueens(iCounter, jCounter, k + 1, solution)) {
						return true;
					} else {
						// Backtracking Step
						solution[iCounter][jCounter] = 0;
					}
				}
			}
			j = -1;
		}
		return false;
	}

	// Processing of the candidate
	private static boolean isAValidCandidate(int i, int j, int[][] solution, int k) {

		boolean isAValidCandidate = true;

		if (k == 0) {
			return true;
		}

		for (int iCounter = 0; iCounter < n; iCounter++) {
			for (int jCounter = 0; jCounter < n; jCounter++) {
				if (solution[iCounter][jCounter] == 1) {

					// CHECK IF QUEENS ARE AT CONTRADICTORY HORIZONTALS
					if (i == iCounter) {
						return false;
					}
					// CHECK IF QUEENS ARE AT CONTRADICTORY VERTICALS
					if (j == jCounter) {
						return false;
					}
					// CHECK IF QUEENS ARE AT CONTRADICTORY DIAGONALS
					int nextDiagonalI = iCounter;
					int nextDiagonalJ = jCounter;
					for (int diagonalCounter = 0; diagonalCounter < 4; diagonalCounter++) {
						nextDiagonalI = iCounter + diagonalIMoves[diagonalCounter];
						nextDiagonalJ = jCounter + diagonalJMoves[diagonalCounter];
						while (nextDiagonalI >= 0 && nextDiagonalI < n && nextDiagonalJ >= 0 && nextDiagonalJ < n) {
							if (i == nextDiagonalI && j == nextDiagonalJ) {
								return false;
							} else {
								nextDiagonalI = nextDiagonalI + diagonalIMoves[diagonalCounter];
								nextDiagonalJ = nextDiagonalJ + diagonalJMoves[diagonalCounter];
							}
						}
					}
				}
			}
		}

		return isAValidCandidate;
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
