/**
 * 
 */
package thread;

/**
 * Write a program to create two threads. In this class we have one constructor
 * used to start the threads and run it. Check whether these two threads are run
 * or not.
 * 
 * @author Sumit 16-Aug-2013
 * 
 */
public class ThreadExrcse1 implements Runnable {

	Thread thSread = null;

	private ThreadExrcse1() {
		thSread = new Thread(this);
		thSread.start();
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadExrcse1 exc1 = new ThreadExrcse1();
		exc1.thSread.setName("Part 1");
		ThreadExrcse1 exc2 = new ThreadExrcse1();
		exc2.thSread.setName("Part 2");

		/*
		 * exc1.thSread.sleep(10000); System.out.println("--------------");
		 * System.out.println(exc1.thSread.getState());
		 * System.out.println(exc1.thSread.getName() + " : " +
		 * exc1.thSread.isAlive()); System.out.println(exc2.thSread.getState());
		 * System.out.println(exc2.thSread.getName() + " : " +
		 * exc2.thSread.isAlive());
		 */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.thSread.getName() + " : " + i);
			if (i == 5) {
				System.out.println(this.thSread.getName() + " sleeping "
						+ this.thSread.isAlive());

			}
		}

	}

}
