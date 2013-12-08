/**
 * 
 */
package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is used to
 * 
 * @author Sumit 16-Aug-2013
 * 
 */
public class ThreadExc3 implements Runnable {

	Thread thread;
	static List<Integer> coll = new ArrayList<Integer>();

	private ThreadExc3() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadExc3 exc31 = new ThreadExc3();
		ThreadExc3 exc32 = new ThreadExc3();
		ThreadExc3 exc33 = new ThreadExc3();
		ThreadExc3 exc34 = new ThreadExc3();
		ThreadExc3 exc35 = new ThreadExc3();

		try {
			exc31.thread.join();
			exc32.thread.join();
			exc33.thread.join();
			exc34.thread.join();
			exc35.thread.join();
		} catch (InterruptedException exception) { // TODO Auto-generated catch
													// block
			exception.printStackTrace();
		}

		// Add

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (coll) {
			coll.add(new Random().nextInt(10));
		}

	}

}
