package info.mb.dsalgo.practice.threading;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class ThreadSychronizer {

	public static void main(String... s) {
		PrinterUsingLocks printer = new PrinterUsingLocks();
		//PrinterUsingSemaphore printer = new PrinterUsingLocks();

		Thread t1 = new Thread(printer.new Printer1());
		Thread t2 = new Thread(printer.new Printer2());
		Thread t3 = new Thread(printer.new Printer3());

		t1.start();
		t2.start();
		t3.start();
	}
}
