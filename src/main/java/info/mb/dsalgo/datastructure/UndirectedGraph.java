package info.mb.dsalgo.datastructure;

import java.util.LinkedList;

/**
 * Creates an unweighted undirected graph.
 * 
 * @author Mukul Bansal
 *
 */
public class UndirectedGraph {
	public int noOfVertices;
	public LinkedList<Integer> adjListArray[];

	public UndirectedGraph(int vertex) {
		this.noOfVertices = vertex;
		adjListArray = new LinkedList[vertex];

		for (int i = 0; i < vertex; i++) {
			adjListArray[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int src, int dest) {
		// Add an edge from src to dest.
		this.adjListArray[src].addFirst(dest);
		// Add an edge from dest to src
		this.adjListArray[dest].addFirst(src);
	}

	public void print() {
		for (int v = 0; v < this.noOfVertices; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("startingNode");
			for (Integer nextNode : this.adjListArray[v]) {
				System.out.print(" --> " + nextNode);
			}
			System.out.println("\n");
		}
	}

	public static UndirectedGraph getSampleGraph() {
		int vertices = 5;
		UndirectedGraph graph = new UndirectedGraph(vertices);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		return graph;
	}

	public static void main(String... strings) {
		UndirectedGraph graph = getSampleGraph();
		graph.print();
	}
}
