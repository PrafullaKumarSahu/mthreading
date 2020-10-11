/**
 * 
 */
package lowlevelproducerconsumer;

import java.util.LinkedList;
import java.util.Random;

/**
 * @author prafullakumarsahu
 *
 */
public class Processor {

	private LinkedList<Integer> list = new LinkedList<>();
	private final int LIMIT = 10;
	Random random = new Random();
	Object lock = new Object();

	public void produce() throws InterruptedException {
		int value = 0;

		while (true) {
			synchronized (lock) {
				while (list.size() == LIMIT) {
					lock.wait();
				}

				list.add(value++);
				lock.notify();
			}
		}
	}

	public void consume() throws InterruptedException {

		while (true) {
			synchronized (lock) {
				Thread.sleep(1000);
				while (list.size() == 0) {
					lock.wait();
				}

				System.out.print("List size is: " + list.size());
				int value = list.removeFirst();
				System.out.println("|| value is: " + value);
				lock.notify();
			}
			Thread.sleep(random.nextInt(1000));
		}

	}

}
