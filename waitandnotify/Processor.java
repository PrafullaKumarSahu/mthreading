/**
 * 
 */
package waitandnotify;

import java.util.Scanner;

/**
 * @author prafullakumarsahu
 *
 */
public class Processor {

	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread starting.....");
			wait(); // waiting another thread to complete and notify to resume
			System.out.println("Resumed");
		}
	}

	public void consume() throws InterruptedException {
		Thread.sleep(2000);
		Scanner scanner = new Scanner(System.in);
		synchronized (this) {
			System.out.println("Waiting for return key: ");
			String str = scanner.nextLine();
			if (str.equalsIgnoreCase("")) {
				notify(); // notify waiting thread on same intrinsic lock to wake up
			}
			Thread.sleep(5000); // make the waiting thread wait for 5000 milliseconds before resuming
		}
	}

}
