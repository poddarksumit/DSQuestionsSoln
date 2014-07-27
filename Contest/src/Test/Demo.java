package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {

	private static String FILE_PATH = "C:\\Users\\Sumit\\Downloads\\HelloWorld\\";
	private static String FILE_NAME = "Everydaygiftcard_Customer_WithAddress.csv";
	private static String DELIMETER = "|";
	private static String ADDRESS = "ADDRESS";
	private static String B2C = "B2C";
	private static String WOW_MON = "wowmo_gfs";
	private static String ENB = "ENB";
	private static String NEW_LINE = "\n";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File file = new File(FILE_PATH + FILE_NAME);
		try {
			StringBuffer newFile = new StringBuffer();
			BufferedReader rd = new BufferedReader(new FileReader(file));
			boolean isFrstLineRead = false;
			String line = "";
			while ((line = rd.readLine()) != null) {
				if (isFrstLineRead) {
					String[] str = line.split(",");
					newFile.append("I").append(DELIMETER).append(ADDRESS)
							.append(DELIMETER).append(str[3].trim());
					newFile.append(DELIMETER).append(B2C).append(DELIMETER)
							.append(WOW_MON).append(DELIMETER);
					newFile.append(ENB).append(DELIMETER).append(DELIMETER)
							.append(DELIMETER).append(DELIMETER);
					newFile.append(str[23].trim()).append(DELIMETER)
							.append(DELIMETER).append(DELIMETER)
							.append(str[24].trim()).append(DELIMETER)
							.append(str[25].trim()).append(DELIMETER).append(str[26]).append(DELIMETER).append(str[27]).append(DELIMETER);

					System.out.println(newFile.toString());
				} else {
					isFrstLineRead = true;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
