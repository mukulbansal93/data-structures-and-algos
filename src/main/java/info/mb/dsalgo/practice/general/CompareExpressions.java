package info.mb.dsalgo.practice.general;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Problem statement-
 * https://www.geeksforgeeks.org/check-two-expressions-brackets/
 * 
 * @author Mukul Bansal
 *
 */
public class CompareExpressions {

	public static void main(String[] args) {
		String exp1 = "a+b-(c-d-(e-f+g))";
		String exp2 = "a+b-c+d+e-f+g";

		Stack<Character> operatorStack1 = getOperatorStack(exp1);
		Stack<Character> operatorStack2 = getOperatorStack(exp2);

		System.out.print("Are two expressions equal- ");
		System.out.println(operatorStack1.equals(operatorStack2));

	}

	private static Stack<Character> getOperatorStack(String exp) {
		Stack<Character> operatorStack = new Stack<>();

		Deque<Character> globalOperatorStack = new LinkedList<Character>();
		globalOperatorStack.add('+');

		for (int i = 0; i < exp.length(); i++) {
			if (exp.charAt(i) == '(') {
				globalOperatorStack.add(exp.charAt(i - 1));
			} else if (exp.charAt(i) == ')') {
				globalOperatorStack.removeLast();
			} else if (exp.charAt(i) == '+' || exp.charAt(i) == '-') {
				// Do Nothing
			} else {
				if (i >= 1 && (exp.charAt(i - 1) == '+' || exp.charAt(i - 1) == '-')) {
					operatorStack.push(updateOperator(calcGlobalOperator(globalOperatorStack), exp.charAt(i - 1)));
				} else {
					operatorStack.push(updateOperator(calcGlobalOperator(globalOperatorStack), '+'));
				}
			}
		}

		return operatorStack;
	}

	private static char updateOperator(char currentOperator, char newOperator) {
		if (currentOperator == '+' && newOperator == '+') {
			return '+';
		} else if (currentOperator == '+' && newOperator == '-') {
			return '-';
		} else if (currentOperator == '-' && newOperator == '+') {
			return '-';
		} else {
			return '+';
		}
	}

	private static char calcGlobalOperator(Deque<Character> globalOperatorQueue) {

		int negatives = 0;

		for (int i = 0; i < globalOperatorQueue.size(); i++) {
			char removedChar = globalOperatorQueue.remove();
			if (removedChar == '-') {
				negatives++;
			}
			globalOperatorQueue.add(removedChar);
		}

		if (negatives % 2 == 0) {
			return '+';
		}

		return '-';
	}
}
