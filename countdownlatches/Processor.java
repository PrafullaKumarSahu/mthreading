/**
 * 
 */
package countdownlatches;

import java.util.concurrent.CountDownLatch;

/**
 * @author prafullakumarsahu
 *
 */
public class Processor implements Runnable {

	private CountDownLatch latch;

	/**
	 * @param latch
	 */
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Before count down: " + latch);
		latch.countDown();
		System.out.println("After count down: " + latch);
	}

}
