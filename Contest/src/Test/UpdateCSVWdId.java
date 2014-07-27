package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class UpdateCSVWdId {

	private static StringBuffer sb = new StringBuffer();
	private static StringBuffer error = new StringBuffer();
	private static String FILE_PATH = "C:\\Users\\Sumit\\Downloads\\HelloWorld\\";
	private static String FILE_NAME = "Everydaygiftcard_Customer_WithAddress.csv";
	private static String FILE_NAME_MAP = "export.csv";
	private static String DELIMETER = ",";
	private static int count = 0;
	private static HashMap<String, USAIdMap> map = new HashMap<String, UpdateCSVWdId.USAIdMap>();

	static class USAIdMap {
		String usa_id = "";
		String uad_id = "";

		public USAIdMap(String usa_id, String uad_id) {
			super();
			this.usa_id = usa_id;
			this.uad_id = uad_id;
		}

	}

	public static void main(String[] args) throws IOException {
		createUSAMap();
		File file = new File(FILE_PATH + FILE_NAME);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = "";
		boolean isFirstRead = false;
		while ((line = reader.readLine()) != null) {
			if (isFirstRead) {
				String[] str = line.split(",");
				USAIdMap mapId = map.get(str[3]);
				if (mapId != null) {
					sb.append(line).append(",").append(mapId.usa_id)
							.append(",").append(mapId.uad_id).append("\n");
				} else {
					sb.append(line).append(",,").append("\n");
				}
			} else {
				isFirstRead = true;
				sb.append(line).append("\n");
			}
		}
		writeOutput(sb.toString(), FILE_PATH
				+ "Everydaygiftcard_Customer_WithBMID.csv", "UTF8");
		System.out.println("Done");
	}

	private static void createUSAMap() throws IOException {
		File file = new File(FILE_PATH + FILE_NAME_MAP);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = "";
		boolean isFirstRead = false;
		while ((line = reader.readLine()) != null) {
			if (isFirstRead) {
				String[] str = line.split("\\|");
				if (str.length == 3 && !"".equals(str[1]) && !"".equals(str[2])) {
					map.put(str[0], new USAIdMap(str[1], str[2]));
				}
			} else {
				isFirstRead = true;
			}
		}
	}

	private static void writeOutput(String str, String fileName, String encoding)
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
