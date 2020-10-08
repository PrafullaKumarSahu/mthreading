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

	private Object lockOne = new Object();
	private Object lockTwo = new Object();

	public void stageOne() {
		synchronized (lockOne) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			listOne.add(random.nextInt(100));
		}
	}

	public void stageTwo() {
		synchronized (lockTwo) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			listTwo.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
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

		// Time taken 2841 milliseconds, so two threads running simultaneously ||
		// listOne=1993, listTwo=1994
		// some elements missing as in 2 threads, each list should have 2000 numbers ||
		// sometimes may cause ArrayIndexOutOfBoundexception

		// With synchronized keyword, Time taken:5631 | listOne=2000, listTwo=2000
		// First thread is accessing the intrinsic lock of list and 2nd thread is
		// waiting, so time taken is double
		
		//With synchronized block, time taken = 2799 | listOne=2000, listTwo=2000
		//Now two thread can run the same method at same time, but if synchronized block is executing by one thread, the other need to wait
		//So, when one thread is running 1st method, the other will run the 2nd method

		try {
			threadOne.join();
			threadTwo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Time taken:" + (end - start));
		System.out.println("List one size: " + listOne.size() + " || List two size:" + listTwo.size());

	}

}
