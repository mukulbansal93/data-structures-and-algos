package info.mb.dsalgo.practice.threading;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class ThreadSychronizer {

	public static void main(String... s) {
		Printer printer = new Printer();

		Thread t1 = new Thread(printer.new Printer1());
		Thread t2 = new Thread(printer.new Printer2());
		Thread t3 = new Thread(printer.new Printer3());

		t1.start();
		t2.start();
		t3.start();
	}
}
