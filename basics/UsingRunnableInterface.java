/**
 * 
 */
package basics;

/**
 * @author prafullakumarsahu
 *
 */

class Run implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println(i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

public class UsingRunnableInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread runnerOne = new Thread(new Run());
		runnerOne.start();
		
		Thread runnerTwo = new Thread(new Run());
		runnerTwo.start();
	}

}
