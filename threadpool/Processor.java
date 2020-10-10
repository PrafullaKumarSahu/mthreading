/**
 * 
 */
package threadpool;

/**
 * @author prafullakumarsahu
 *
 */
public class Processor implements Runnable{
	
	private int id;
	
	/**
	 * @param id
	 */
	public Processor(int id) {
		super();
		this.id = id;
	}



	@Override
	public void run() {
		System.out.println("Starting thread: " + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Completed thread: " + id);
	}

}
