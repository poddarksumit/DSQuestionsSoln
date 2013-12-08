/**
 * 
 */
package thread;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * This class is used to
 * 
 * @author Sumit 17-Aug-2013
 * 
 */
public class FileReadingWithThread implements Runnable {
	static String[] fileName = {
			"C:/Users/Sumit/Documents/Work Documents/w8.txt",
			"C:/Users/Sumit/Documents/Work Documents/database password.txt",
			"C:/Users/Sumit/Documents/Work Documents/yourkit.txt",
			"C:/Users/Sumit/Documents/Work Documents/w8.txt",
			"C:/Users/Sumit/Documents/Work Documents/database password.txt",
			"C:/Users/Sumit/Documents/Work Documents/yourkit.txt" };

	Thread thread;
	String filePath = "";
	int lineCount = 0;

	private FileReadingWithThread(String filePath, String threadName,
			int priority) {
		super();
		this.thread = new Thread(this, threadName);
		this.filePath = filePath;
		this.thread.setPriority(priority);
		this.thread.start();
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public synchronized static void main(String[] args)
			throws InterruptedException {
		long strtTime = System.currentTimeMillis();
		FileReadingWithThread f1 = new FileReadingWithThread(fileName[0], "0",
				7);
		FileReadingWithThread f2 = new FileReadingWithThread(fileName[1], "1",
				4);
		FileReadingWithThread f3 = new FileReadingWithThread(fileName[2], "2",
				9);
		FileReadingWithThread f4 = new FileReadingWithThread(fileName[3], "3",
				10);
		FileReadingWithThread f5 = new FileReadingWithThread(fileName[4], "4",
				1);
		FileReadingWithThread f6 = new FileReadingWithThread(fileName[5], "5",
				8);

		// Join
		f1.thread.join();
		f2.thread.join();
		f3.thread.join();
		f4.thread.join();
		f5.thread.join();
		f6.thread.join();

		long endTime = System.currentTimeMillis();
		System.out.println(endTime - strtTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		try {
			this.thread.sleep(1000);
			for (int i = 0; i < 10; i++) {

			}

			File file = new File(this.filePath);
			FileReader reader = new FileReader(file);
			LineNumberReader lineReader = new LineNumberReader(reader);
			while (lineReader.readLine() != null) {
				this.lineCount += 1;
			}
			System.out.println(this.thread.getName() + " : " + this.lineCount);
		} catch (IOException exception) {
			// TODO: handle exception
		} catch (InterruptedException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
	}
}
