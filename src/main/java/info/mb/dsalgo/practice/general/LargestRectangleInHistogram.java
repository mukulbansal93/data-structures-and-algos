package info.mb.dsalgo.practice.general;

import java.util.Stack;

/**
 * Problem Statement-
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * <p>
 * Video Solution- https://www.youtube.com/watch?v=VNbkzsnllsU
 * </p>
 * 
 * @author Mukul Bansal
 *
 */
public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		int histogram[] = { 6, 2, 5, 4, 5, 1, 6 };
		printAreaOfLargestRectangle(histogram);
	}

	private static void printAreaOfLargestRectangle(int[] histogram) {

		Stack<Integer> heightStack = new Stack<>();
		Stack<Integer> positionStack = new Stack<>();
		int largestAreaYet = 0;

		for (int i = 0; i < histogram.length; i++) {

			if (heightStack.empty()) {
				heightStack.push(histogram[i]);
				positionStack.push(i);
				continue;
			}

			if (heightStack.peek() < histogram[i]) {
				// PUSH RIGHT AWAY
				heightStack.push(histogram[i]);
				positionStack.push(i);
			} else {
				// POP LARGER ELEMENTS AND THEN PUSH
				while (!heightStack.empty() && heightStack.peek() > histogram[i]) {
					int poppedElement = heightStack.pop();
					int poppedPosition = positionStack.pop();
					int newArea = poppedElement * (i - poppedPosition);
					if (newArea > largestAreaYet) {
						largestAreaYet = newArea;
					}
				}
				// PUSH IF HEIGHT IS STRICTLY GREATER AND THE STARTING POSITION OF THE NEW
				// PUSHED ELEMENT WILL BE (i-noOfPoppedElements)
				if (heightStack.empty()) {
					heightStack.push(histogram[i]);
					positionStack.push(i);
				} else if (heightStack.peek() < histogram[i]) {
					heightStack.push(histogram[i]);
					positionStack.push(i - positionStack.peek());
				}
			}

		}

		while (!heightStack.isEmpty()) {
			int poppedElement = heightStack.pop();
			int poppedPosition = positionStack.pop();
			int newArea = poppedElement * (histogram.length - poppedPosition);
			if (newArea > largestAreaYet) {
				largestAreaYet = newArea;
			}
		}

		System.out.println("Largest area in histogram is- " + largestAreaYet);

	}

}
