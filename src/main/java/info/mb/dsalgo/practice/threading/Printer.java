package info.mb.dsalgo.practice.threading;

/**
 * 
 * @author Mukul Bansal
 *
 */
public class Printer {

	Object lock = new Object();
	int turn = 1;

	 class Printer1 implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (lock) {
					if (turn == 1) {
						System.out.print("Pay");
						turn = 2;
						lock.notifyAll();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	 class Printer2 implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (lock) {
					if (turn == 2) {
						System.out.print("T");
						turn = 3;
						lock.notifyAll();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	 class Printer3 implements Runnable {
		@Override
		public void run() {
			while (true) {
				synchronized (lock) {
					if (turn == 3) {
						System.out.print("m ");
						turn = 1;
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						lock.notifyAll();
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

}