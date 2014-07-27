package thread;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class NSCSVThread extends Thread {
	private static final String FILE_PATH_NEW = "C:\\Users\\Sumit\\My\\";
	private static final String COMMA = ",";
	private static final String NEW_FILE_NAME = "NS_";
	private static final String NEW_LINE = "\n";
	private File myFile = null;
	public Thread myThread = null;

	public NSCSVThread(File myFile) {
		this.myFile = myFile;
		myThread = new Thread(this);
		// myThread.start();
	}

	@Override
	public void run() {
		process();
	}

	public void process() {
		String str = "";
		StringBuffer newFile = new StringBuffer();
		BufferedReader buffer = null;
		try {
			System.out.println(this.myFile.getName());
			buffer = new BufferedReader(new FileReader(this.myFile));
			while ((str = buffer.readLine()) != null) {
				String[] strSplit = str.split(COMMA);
				newFile.append(
						strSplit[2].replace("\"", "").replace("dm_", "")
								.replace("masters", "").replace("bigw_", ""))
						.append(COMMA).append(strSplit[0].replace("\"", ""))
						.append(COMMA).append(strSplit[1].replace("\"", ""))
						.append(COMMA).append(strSplit[13].replace("\"", ""))
						.append(COMMA).append(strSplit[3].replace("\"", ""))
						.append(COMMA).append(strSplit[4].replace("\"", ""))
						.append(COMMA).append(strSplit[5].replace("\"", ""))
						.append(COMMA).append(strSplit[6].replace("\"", ""))
						.append(COMMA).append(strSplit[7].replace("\"", ""))
						.append(COMMA).append(strSplit[8].replace("\"", ""))
						.append(COMMA).append(strSplit[9].replace("\"", ""))
						.append(COMMA).append(strSplit[10].replace("\"", ""))
						.append(COMMA).append(strSplit[11].replace("\"", ""))
						.append(COMMA);
				if (!"".equals(strSplit[17].replace("\"", ""))) {
					//newFile.append(strSplit[17].replace("\"", ""));
					newFile.append("Monteith");
				} else {
					newFile.append("Monteith");
				}
				newFile.append(NEW_LINE);
			}
			System.out.println("over : " + this.myFile.getName());
			writeOutput(newFile.toString(), FILE_PATH_NEW + NEW_FILE_NAME
					+ this.myFile.getName(), "UTF8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				buffer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void writeOutput(String str, String fileName, String encoding)
			throws IOException {

		try {
			System.out.println(fileName);
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
