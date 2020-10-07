/**
 * 
 */
package basics;

/**
 * @author prafullakumarsahu
 *
 */
public class UsingSynchronized {

	private int count;
	private int counter;
	
	public synchronized int increament() {
		return counter++;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UsingSynchronized app = new UsingSynchronized();
		app.doWork();
	}

	public void doWork() {
		Thread threadOne = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 10000; i++) {
					count++;
					increament();
				}
			}

		});

		Thread threadTwo = new Thread(new Runnable() {

			public void run() {
				for (int i = 0; i < 10000; i++) {
					count++;
					increament();
				}
			}

		});

		threadOne.start();
		threadTwo.start();
		
		try {
			threadOne.join();
			threadTwo.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(count);
		System.out.println(increament());
	}

}
