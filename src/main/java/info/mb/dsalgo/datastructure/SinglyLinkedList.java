package info.mb.dsalgo.datastructure;

public class SinglyLinkedList {

	public int data;
	public SinglyLinkedList next;

	public SinglyLinkedList(int data) {
		super();
		this.data = data;
		this.next = null;
	}

	public static void display(SinglyLinkedList head) {

		while (true) {
			System.out.print(head.data);
			if (head.next != null) {
				System.out.print("--->");
				head = head.next;
			} else {
				System.out.println();
				break;
			}
		}
	}

	public static SinglyLinkedList reverseViaIteration(SinglyLinkedList head) {
		SinglyLinkedList revHead = head;

		SinglyLinkedList current = head;
		SinglyLinkedList next = head.next;

		// Making next of first node as null
		if (revHead.next != null) {
			revHead.next = null;
		}

		while (next != null) {
			SinglyLinkedList nextNext = next.next;
			next.next = current;
			revHead = next;
			current = next;
			next = nextNext;
		}
		return revHead;
	}

	public static SinglyLinkedList reverseViaRecursion(SinglyLinkedList head) {
		
		//Breaking first node
		SinglyLinkedList first = head;

		if (head.next == null) {
			return head;
		}

		//Recursing on remaining nodes
		SinglyLinkedList revHead = reverseViaRecursion(head.next);

		//Fixing detached node
		first.next.next = first;
		first.next = null;

		return revHead;
	}

	public static void main(String... s) {
		SinglyLinkedList head = new SinglyLinkedList(1);
		head.next = new SinglyLinkedList(2);
		head.next.next = new SinglyLinkedList(3);
		head.next.next.next = new SinglyLinkedList(4);
		head.next.next.next.next = new SinglyLinkedList(5);

		System.out.println("Original Linked List-");
		display(head);

		System.out.println("Reversing via Iteration-");
		head = reverseViaIteration(head);
		display(head);
		
		System.out.println("Reversing via Recursion-");
		head = reverseViaRecursion(head);
		display(head);
	}
}
