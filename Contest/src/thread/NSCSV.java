package thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NSCSV {

	private static final String FILE_PATH = "C:\\Users\\Sumit\\My\\newFile";
	private static final String FILE_PATH_NEW = "C:\\Users\\Sumit\\My\\";
	private static final String COMMA = ",";
	private static final String NEW_FILE_NAME = "NS_";
	private static final String NEW_LINE = "\n";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = getTimeInMillis();
		File[] files = MCRCompetitionSubscriptionTread.fetchFiles(FILE_PATH);
		if (files.length > 0) {
			/*
			 * for (File file : files) { process(file); }
			 */
			/*
			 * try { NSCSVThread t1 = new NSCSVThread(files[0]); NSCSVThread t2
			 * = new NSCSVThread(files[1]); NSCSVThread t3 = new
			 * NSCSVThread(files[2]); NSCSVThread t4 = new
			 * NSCSVThread(files[3]); NSCSVThread t5 = new
			 * NSCSVThread(files[4]); t1.myThread.join(); t2.myThread.join();
			 * t3.myThread.join(); t4.myThread.join(); t5.myThread.join(); }
			 * catch (InterruptedException e) { // TODO Auto-generated catch
			 * e.printStackTrace(); }
			 */
			ExecutorService threadService = Executors
					.newFixedThreadPool(files.length);
			try {
				for (File file : files) {
					Runnable thread = new NSCSVThread(file);
					threadService.execute(thread);
				}
				threadService.shutdown();
				threadService.awaitTermination(60, TimeUnit.MINUTES);

			} catch (InterruptedException e) { // TODO Auto-generated catch
				e.printStackTrace();
			}
		}
		System.out.println("Total Time : " + (getTimeInMillis() - startTime));
	}

	private static long getTimeInMillis() {
		// return System.currentTimeMillis();
		return new Date().getTime();
	}

	public static void process(File myFile) {
		String str = "";
		StringBuffer newFile = new StringBuffer();
		try {
			System.out.println(myFile.getName());
			BufferedReader buffer = new BufferedReader(new FileReader(myFile));

			while ((str = buffer.readLine()) != null) {
				String[] strSplit = str.split(COMMA);
				newFile.append(strSplit[2].replace("\"", "")).append(COMMA)
						.append(strSplit[0].replace("\"", "")).append(COMMA)
						.append(strSplit[1].replace("\"", "")).append(COMMA)
						.append(strSplit[13].replace("\"", "")).append(COMMA)
						.append(strSplit[3].replace("\"", "")).append(COMMA)
						.append(strSplit[4].replace("\"", "")).append(COMMA)
						.append(strSplit[5].replace("\"", "")).append(COMMA)
						.append(strSplit[6].replace("\"", "")).append(COMMA)
						.append(strSplit[7].replace("\"", "")).append(COMMA)
						.append(strSplit[8].replace("\"", "")).append(COMMA)
						.append(strSplit[9].replace("\"", "")).append(COMMA)
						.append(strSplit[10].replace("\"", "")).append(COMMA)
						.append(strSplit[11].replace("\"", "")).append(COMMA)
						.append(strSplit[17].replace("\"", ""))
						.append(NEW_LINE);
			}
			writeOutput(newFile.toString(), FILE_PATH_NEW + NEW_FILE_NAME
					+ myFile.getName(), "UTF8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void writeOutput(String str, String fileName, String encoding)
			throws IOException {

		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			Writer out = new OutputStreamWriter(fos, encoding);
			out.write(str);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}
}
