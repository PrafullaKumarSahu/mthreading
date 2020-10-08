/**
 * 
 */
package multiplelocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author prafullakumarsahu
 *
 */
public class Walker {

	private List<Integer> listOne = new ArrayList<Integer>();
	private List<Integer> listTwo = new ArrayList<Integer>();
	private Random random = new Random();

	public void stageOne() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		listOne.add(random.nextInt(100));
	}

	public void stageTwo() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		listTwo.add(random.nextInt(100));
	}

	public void process() {
		for(int i=0; i<1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	public void main() {
		System.out.println("Staring.....");
		
		long start = System.currentTimeMillis();
		
//		process(); //Time taken 2784milliseconds || listOne=1000, listTwo=1000
		
		Thread threadOne = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
			
		});
		
		Thread threadTwo = new Thread(new Runnable() {

			@Override
			public void run() {
				process();
			}
			
		});
		
		threadOne.start();
		threadTwo.start();
		
		try {
			threadOne.join();
			threadTwo.join(); // Time taken 2841 milliseconds, so two threads running simultaneously 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Time taken:" + (end-start));
		System.out.println("List one size: " + listOne.size() + " || List two size:" +  listTwo.size());

	}

}
