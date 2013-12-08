/**
 * 
 */
package thread;

/**
 * This class is used to
 * 
 * @author Sumit 16-Aug-2013
 * 
 */
public class ThreadExec2 implements Runnable {

	String[] course = { "Java", "J2EE", "Spring", "Struts" };
	Thread thread = null;

	private ThreadExec2() {
		this.thread = new Thread(this);
		this.thread.start();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadExec2 ex1 = new ThreadExec2();
		ex1.thread.setName("1");
		ThreadExec2 ex2 = new ThreadExec2();
		ex2.thread.setName("2");
		ThreadExec2 ex3 = new ThreadExec2();
		ex3.thread.setName("3");
		try {
			ex1.thread.join();
			ex2.thread.join();
			ex3.thread.join();
		} catch (Exception exception) {
			// TODO: handle exception
		}
		System.out.println("---END---");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		synchronized (course) {
			for (String str : course) {
				System.out.println(this.thread.getName() + " : " + str);
			}
		}
	}
}
