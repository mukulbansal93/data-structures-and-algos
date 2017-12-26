package info.mb.dsalgo.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import info.mb.dsalgo.datastructure.UndirectedGraph;
import info.mb.dsalgo.util.Constants;

public class Dijkstra {

	public static void main(String... s) {
		int source = 0;
		int destination = 2;
		int costPerEdge = 5;
		UndirectedGraph graph = UndirectedGraph.getSampleGraph();
		graph.print();
		Map<Integer, Integer> minimumSpanningTree = generateMST(graph, source, costPerEdge);
		System.out.println("Minimum Spanninng Tree with Source as " + source + " is " + minimumSpanningTree);
		displayOptimalPathAndRoute(minimumSpanningTree, source, destination);
	}

	public static Map<Integer, Integer> generateMST(UndirectedGraph graph, int source, int costPerEdge) {
		Map<Integer, Integer> visitedNodesAndParents = new HashMap<Integer, Integer>();
		int[] distance = new int[graph.noOfVertices];
		int[] parent = new int[graph.noOfVertices];

		for (int i = 0; i < graph.noOfVertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < graph.noOfVertices; i++) {
			parent[i] = -1;
		}

		visitedNodesAndParents.put(source, -1);
		distance[source] = 0;
		int currentNode = source;
		while (visitedNodesAndParents.size() != graph.noOfVertices) {
			for (Integer nextNode : graph.adjListArray[currentNode]) {
				if (!visitedNodesAndParents.containsKey(nextNode)
						&& distance[nextNode] > distance[currentNode] + costPerEdge) {
					distance[nextNode] = distance[currentNode] + costPerEdge;
					parent[nextNode] = currentNode;
				}
			}
			currentNode = chooseNextNode(visitedNodesAndParents, distance);
			// No node left to visit for the currentNode
			if (currentNode == -1) {
				break;
			}
			visitedNodesAndParents.put(currentNode, -1);
		}

		for (int i = 1; i < parent.length; i++) {
			if (i != source) {
				visitedNodesAndParents.put(i, parent[i]);
			}
		}
		
		System.out.println("Distance Vector- "+Arrays.toString(distance));
		return visitedNodesAndParents;

	}

	private static int chooseNextNode(Map<Integer, Integer> visitedNodes, int[] distance) {
		int retVal = -1;
		int minimum = Integer.MAX_VALUE;
		for (int i = 1; i < distance.length; i++) {
			if (!visitedNodes.containsKey(i) && minimum > distance[i]) {
				minimum = distance[i];
				retVal = i;
			}
		}
		return retVal;
	}

	public static void displayOptimalPathAndRoute(Map<Integer, Integer> minimumSpanningTree, int source,
			int destination) {
		Stack<Integer> stack = new Stack<Integer>();
		int parent = minimumSpanningTree.get(destination);
		stack.push(destination);
		while (parent != -1) {
			stack.push(parent);
			parent = minimumSpanningTree.get(parent);
		}
		System.out.println(String.format("Total nodes in path from %s to %s are %d", source, destination, stack.size()));
		System.out.print("Path- ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + Constants.SPACE);
		}
	}

}
