/**
 * 
 */
package basics;

/**
 * @author prafullakumarsahu
 *
 */
public class AnonymousThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread thread = new Thread(new Runnable() {

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
			
		});
		thread.start();
	}

}
