/**
 * 
 */
package basics;

/**
 * @author prafullakumarsahu
 *
 */

class Runner extends Thread{
	public void run() {
		for (int i=0; i<10; i++) {
			
			System.out.println(i);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class UsingThreadClass {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Runner runnerOne = new Runner();
		runnerOne.start();
		
		Runner runnerTwo = new Runner();
		runnerTwo.start();
	}

}
