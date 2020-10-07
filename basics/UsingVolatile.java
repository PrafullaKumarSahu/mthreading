/**
 * 
 */
package basics;

import java.util.Scanner;

/**
 * @author prafullakumarsahu
 *
 */

class Processor extends Thread {
	public volatile boolean running = true;

	public void run() {
		while (running) {
			System.out.println("Keep prining!");
		}

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void shutdown() {
		running = false;

	}
}

public class UsingVolatile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Processor process = new Processor();
		process.start();

		System.out.println("Press return key to stop.");
		Scanner scan = new Scanner(System.in);
		scan.nextLine();

		process.shutdown();
	}

}
