package info.mb.dsalgo.practice.backtracking;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/bin-packing-problem-minimize-number-of-used-bins/
 *
 * @author Mukul Bansal
 */
public class BinPacking {

    public static int numberOfItems = 6;
    public static int itemWeights[] = {4, 8, 1, 4, 2, 1};
    public static int binCapacity = 10;

    // Global variables for best answer we yet have.
    public static int globalMinBoxes = numberOfItems;
    public static int[][] globalMinSolution;

    public static void main(String... s) {
        int[][] solution = new int[numberOfItems][numberOfItems];
        globalMinSolution = new int[numberOfItems][numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            for (int j = 0; j < numberOfItems; j++) {
                solution[i][j] = -1;
            }
        }
        for (int i = 0; i < numberOfItems; i++) {
            for (int j = 0; j < numberOfItems; j++) {
                globalMinSolution[i][j] = -1;
            }
        }

        findNumberOfBoxes(solution, 0);
        System.out.println(String.format("Minimum boxes of capacity %d required are- %d", binCapacity, globalMinBoxes));
        printSolution(globalMinSolution);
    }

    private static void findNumberOfBoxes(int[][] solution, int itemNumber) {

        if (itemNumber == numberOfItems) {
            int boxesUsed = boxesUsed(solution);
            // Updating if we get a better solution
            if (boxesUsed < globalMinBoxes) {
                globalMinSolution = copy(solution);
                globalMinBoxes = boxesUsed;
            }
            return;
        }

        for (int boxNumber = 0; boxNumber < numberOfItems; boxNumber++) {

            if (itemWeights[itemNumber] > binCapacity) {
                System.err.println("Weight of one or more items is more than bin capacity.");
                System.exit(0);
            }

            boolean isValidCandidate = isValidCandidate(boxNumber, itemWeights[itemNumber], solution);
            if (isValidCandidate) {
                int emptySlot = 0;
                for (int j = 0; j < numberOfItems; j++) {
                    if (solution[boxNumber][j] == -1) {
                        emptySlot = j;
                        break;
                    }
                }
                // Backtracking Step
                solution[boxNumber][emptySlot] = itemWeights[itemNumber];
                findNumberOfBoxes(solution, itemNumber + 1);
                solution[boxNumber][emptySlot] = -1;
            }
        }

    }

    private static boolean isValidCandidate(int boxNumber, int itemWeight, int[][] solution) {
        int totalWeightOfABox = 0;

        for (int j = 0; j < numberOfItems; j++) {
            if (solution[boxNumber][j] != -1) {
                totalWeightOfABox = totalWeightOfABox + solution[boxNumber][j];
            }
        }
        if (totalWeightOfABox + itemWeight > binCapacity) {
            return false;
        }
        return true;
    }

    private static int boxesUsed(int[][] solution) {
        int boxesUsed = 0;
        for (int i = 0; i < numberOfItems; i++) {
            for (int j = 0; j < numberOfItems; j++) {
                if (solution[i][j] != -1) {
                    boxesUsed++;
                    break;
                }
            }
        }
        return boxesUsed;
    }

    private static int[][] copy(int[][] solution) {
        int[][] arr = new int[numberOfItems][numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            for (int j = 0; j < numberOfItems; j++) {
                arr[i][j] = solution[i][j];
            }
        }
        return arr;
    }

    private static void printSolution(int[][] solution) {
        for (int i = 0; i < numberOfItems; i++) {
            for (int j = 0; j < numberOfItems; j++) {
                if (solution[i][j] != -1) {
                    System.out.print(solution[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
