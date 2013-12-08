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
public class FileReadingWithOutThread {
	static String[] fileName = {
			"C:/Users/Sumit/Documents/Work Documents/w8.txt",
			"C:/Users/Sumit/Documents/Work Documents/database password.txt",
			"C:/Users/Sumit/Documents/Work Documents/yourkit.txt",
			"C:/Users/Sumit/Documents/Work Documents/w8.txt",
			"C:/Users/Sumit/Documents/Work Documents/database password.txt",
			"C:/Users/Sumit/Documents/Work Documents/yourkit.txt" };

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		long strtTym = System.currentTimeMillis();
		File file = null;
		FileReader readFile = null;
		LineNumberReader reader = null;
		for (int i = 0; i < fileName.length; i++) {
			file = new File(fileName[i]);
			int lineNo = 0;
			if (file.exists()) {
				readFile = new FileReader(file);
				reader = new LineNumberReader(readFile);
				while (reader.readLine() != null) {
					lineNo++;
				}
				System.out.println(fileName[i] + " : " + lineNo);
			}
		}
		if (readFile != null) {
			readFile.close();
		}
		if (reader != null) {
			reader.close();
		}
		long endTym = System.currentTimeMillis();
		System.out.println(endTym - strtTym);
	}
}
