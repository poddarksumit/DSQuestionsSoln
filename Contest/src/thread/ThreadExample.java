/**
 * 
 */
package thread;

/**
 * This class is used to
 * 
 * @author Sumit 18-Aug-2013
 * 
 */
public class ThreadExample implements Runnable {

	Thread thread;

	private ThreadExample(String name, int priority) {
		this.thread = new Thread(this);
		this.thread.setName(name);
		this.thread.setPriority(priority);
		// this.thread.start();
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		ThreadExample ex1 = new ThreadExample("First", 3);
		ThreadExample ex2 = new ThreadExample("Second", 6);
		ThreadExample ex3 = new ThreadExample("Third", 5);
		ex2.thread.start();
		ex1.thread.start();
		ex3.thread.start();
		synchronized (ex3.thread) {
			ex3.thread.notifyAll();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (this.thread) {
			try {
				this.thread.wait();
				System.out.println("-----" + this.thread.getName() + " : "
						+ this.thread.getPriority());
			} catch (Exception exception) {
				// TODO Auto-generated catch block
				exception.printStackTrace();
			}
		}

	}

}
