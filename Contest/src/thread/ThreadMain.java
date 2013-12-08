/**
 * 
 */
package thread;

/**
 * This class is used to
 * 
 * @author Sumit 14-Jun-2013
 * 
 */

public class ThreadMain {

	public volatile static int index = 0;

	public static class ThreadA implements Runnable {

		Thread thread;

		public ThreadA(String threadName) {
			thread = new Thread(this, threadName);
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				index++;
				System.out.println("Hello ThreadA : " + i);
				if (i == 5) {
					try {
						System.out.println("index temp : " + index);
						thread.sleep(10000);
					} catch (InterruptedException exception) {
						// TODO Auto-generated catch block
						exception.printStackTrace();
					}
				}
				index = addMore();
			}
		}
	}

	public static class ThreadB implements Runnable {

		Thread thread;

		public ThreadB(String threadName) {
			thread = new Thread(this, threadName);
		}

		@Override
		public void run() {

			for (int i = 0; i < 10; i++) {
				System.out.println("Hello ThreadB : " + i);
				index += 2;
				if (i == 8) {
					System.out.println("Interruptd.");
					this.thread.interrupt();
					for (int in = 0; in < 5; in++) {
						System.out.println("In : " + in);
					}
				}
			}
			index = addMore();
		}
	}

	static public void main(String[] args) {
		ThreadA aThread = new ThreadA("A's thread");
		ThreadB bThread = new ThreadB("B's thread");
		aThread.thread.start();
		bThread.thread.start();
		try {
			aThread.thread.join();
			bThread.thread.join();
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
		System.out.println("index : " + index);
	}

	public synchronized static int addMore() {
		return (index > 0) ? index / 2 : 0;
	}
}
