package info.mb.dsalgo.practice.backtracking;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Problem statement-
 * https://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 * 
 * @author Mukul Bansal
 *
 */
public class HamiltonianCycle {

	//@formatter:off
	
	/* 
	Let us create the following graph-
    (0)--(1)--(2)
     |   / \   |
     |  /   \  |
     | /     \ |
    (3)-------(4)    
    */
	private static int[][] adjMatrix1 = 
		{ 
			{ 0, 1, 0, 1, 0 }, 
			{ 1, 0, 1, 1, 1 }, 
			{ 0, 1, 0, 0, 1 }, 
			{ 1, 1, 0, 0, 1 },
			{ 0, 1, 1, 1, 0 }, 
		};
	
	
	/* 
	 Let us create the following graph-
    (0)--(1)--(2)
     |   / \   |
     |  /   \  |
     | /     \ |
    (3)       (4)    
    */
	private static int[][] adjMatrix2 = 
		{
			{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
        };
	
	//@formatter:on

	public static void main(String[] args) {

		Set<Integer> visitedNodes = null;

		visitedNodes = new LinkedHashSet<>();
		visitedNodes.add(0);
		if (findHamiltonianPath(0, adjMatrix1, visitedNodes)) {
			System.out.println("Hamiltonian Path in graph 1 starting at 0- " + visitedNodes.toString());
		} else {
			System.out.println("There are no hamiltonian paths in graph 1.");
		}

		if (adjMatrix1[getLastValue(visitedNodes)][0] == 1) {
			System.out.println("Hamiltonian Path in graph 1- " + visitedNodes.toString());
		} else {
			System.out.println("There are no hamiltonian cycles in graph 1.");
		}

		System.out.println("------------------------------------------------------------------");

		visitedNodes = new LinkedHashSet<>();
		visitedNodes.add(0);
		if (findHamiltonianPath(0, adjMatrix2, visitedNodes)) {
			System.out.println("Hamiltonian Path in graph 2 starting at 0- " + visitedNodes.toString());
		} else {
			System.out.println("There are no hamiltonian paths in graph 2.");
		}

		if (adjMatrix1[getLastValue(visitedNodes)][0] == 1) {
			System.out.println("Hamiltonian Path in graph 2- " + visitedNodes.toString());
		} else {
			System.out.println("There are no hamiltonian cycles in graph 2.");
		}

	}

	private static boolean findHamiltonianPath(int i, int[][] adjMatrix, Set<Integer> visitedNodes) {

		if (visitedNodes.size() == adjMatrix.length) {
			return true;
		}

		for (int j = 0; j < adjMatrix[i].length; j++) {
			// IS VALID CANDIDATE
			if (adjMatrix[i][j] == 1 && !visitedNodes.contains(j)) {
				visitedNodes.add(j);
				// IS A VALID SOLUTION
				boolean exists = findHamiltonianPath(j, adjMatrix, visitedNodes);
				if (exists) {
					return true;
				} else {
					// BACKTRACK
					visitedNodes.remove(j);
				}
			}
		}

		return false;
	}

	private static int getLastValue(Set<Integer> set) {
		Iterator<Integer> iterator = set.iterator();
		int lastValue = 0;
		while (iterator.hasNext()) {
			lastValue = iterator.next();
		}
		return lastValue;
	}

}
