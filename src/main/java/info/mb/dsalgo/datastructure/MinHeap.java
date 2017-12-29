package info.mb.dsalgo.datastructure;

import java.util.Arrays;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class MinHeap {

	public class HeapData {
		public int value;
		public int metadata;

		public HeapData(int value, int metadata) {
			super();
			this.value = value;
			this.metadata = metadata;
		}

		@Override
		public String toString() {
			return "Data [value=" + value + ", metadata=" + metadata + "]";
		}

	}

	public int maxHeapSize;
	public int currentHeapSize;
	public HeapData[] heap;

	public MinHeap(int maxHeapsize) {
		this.maxHeapSize = maxHeapsize;
		heap = new HeapData[maxHeapsize];
		currentHeapSize = -1;
	}

	public HeapData getMinimumNode() {
		HeapData data = this.heap[0];
		this.heap[0] = this.heap[this.currentHeapSize];
		this.heap[this.currentHeapSize] = null;
		this.currentHeapSize--;
		this.heapifyAfterDeletingNode();
		return data;
	}

	public void addNode(HeapData data) {
		if (this.currentHeapSize + 1 == this.maxHeapSize) {
			System.err.println(
					String.format("The maximum capacity of heap has been reached: %d. Exiting...", this.maxHeapSize));
			System.exit(0);
		}
		this.currentHeapSize++;
		this.heap[this.currentHeapSize] = data;
		this.heapifyAfterAddingNode();
	}

	public void display() {
		System.out.println(Arrays.toString(this.heap));
	}

	private void heapifyAfterDeletingNode() {
		int heapCounter = 0;
		int heapLevels = (int) (Math.log(this.currentHeapSize + 1) / Math.log(2));
		for (int i = 0; i < heapLevels; i++) {
			int leftChildCounter = (2 * heapCounter) + 1;
			int rightChildCounter = (2 * heapCounter) + 2;
			if ((leftChildCounter >= this.maxHeapSize || this.heap[leftChildCounter] == null
					|| this.heap[heapCounter].value <= this.heap[leftChildCounter].value)
					&& (rightChildCounter >= this.maxHeapSize || this.heap[rightChildCounter] == null
							|| this.heap[heapCounter].value <= this.heap[rightChildCounter].value)) {
				break;
			} else {
				if (this.heap[leftChildCounter].value >= this.heap[rightChildCounter].value) {
					HeapData tmpData = this.heap[heapCounter];
					this.heap[heapCounter] = this.heap[rightChildCounter];
					this.heap[rightChildCounter] = tmpData;
					heapCounter = rightChildCounter;
				} else {
					HeapData tmpData = this.heap[heapCounter];
					this.heap[heapCounter] = this.heap[leftChildCounter];
					this.heap[leftChildCounter] = tmpData;
					heapCounter = leftChildCounter;
				}
			}
		}
	}

	private void heapifyAfterAddingNode() {
		int heapCounter = this.currentHeapSize;
		int heapLevels = (int) (Math.log(this.currentHeapSize + 1) / Math.log(2));
		for (int i = 0; i < heapLevels; i++) {
			int parentCounter = (heapCounter - 1) / 2;
			if (parentCounter < 0 || this.heap[heapCounter].value >= this.heap[parentCounter].value) {
				break;
			} else {
				HeapData tmpData = this.heap[parentCounter];
				this.heap[parentCounter] = this.heap[heapCounter];
				this.heap[heapCounter] = tmpData;
				heapCounter = parentCounter;
			}
		}
	}

	public static void main(String... s) {
		int heapsize = 10;
		MinHeap minHeap = new MinHeap(heapsize);

		IntStream.range(0, heapsize).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				HeapData data = minHeap.new HeapData(heapsize - value - 1, heapsize - value - 1);
				System.out.println("Adding Node- " + data.toString());
				minHeap.addNode(data);
				minHeap.display();
			}
		});

		System.out.println("============================================================================================================");

		IntStream.range(0, heapsize).forEach(new IntConsumer() {

			@Override
			public void accept(int value) {
				System.out.println("Deleting Node- " + minHeap.getMinimumNode());
				minHeap.display();
			}
		});

	}

}
