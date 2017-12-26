package info.mb.dsalgo.challenge.hackerearth.servicenow;

import java.util.Map;
import java.util.Scanner;

import info.mb.dsalgo.algorithm.Dijkstra;
import info.mb.dsalgo.datastructure.UndirectedGraph;
import info.mb.dsalgo.util.Constants;

/**
 * Problem Statement-
 * https://www.hackerearth.com/challenge/hiring/servicenow-developer-hiring-challenge/
 * 
 * @author Mukul Bansal
 *
 */
class TheFlightPlan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] NMTC = scanner.nextLine().split(Constants.SPACE);
		int N = Integer.parseInt(NMTC[0]);
		int M = Integer.parseInt(NMTC[1]);
		int T = Integer.parseInt(NMTC[2]);
		int C = Integer.parseInt(NMTC[3]);

		// CREATING GRAPH
		int vertices = N;
		UndirectedGraph graph = new UndirectedGraph(vertices + 1);
		for (int i = 1; i <= M; i++) {
			graph.addEdge(scanner.nextInt(), scanner.nextInt());
		}

		// graph.print();

		int source = scanner.nextInt();
		int destination = scanner.nextInt();
		Map<Integer, Integer> MST = Dijkstra.generateMST(graph, source, destination);
		// System.out.println(MST);

		Dijkstra.displayOptimalPathAndRoute(MST, source, destination);

		scanner.close();
	}

}