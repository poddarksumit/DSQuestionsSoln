package Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class CreateUSAFromXLS {

	private static StringBuffer sb = new StringBuffer();
	private static StringBuffer error = new StringBuffer();
	private static String FILE_PATH = "C:\\Users\\Sumit\\Downloads\\HelloWorld\\";
	private static String FILE_NAME = "Everydaygiftcard_Customer_WithAddress_2.xls";
	private static String DELIMETER = "|";
	private static String ADDRESS = "ADDRESS";
	private static String B2C = "B2C";
	private static String WOW_MON = "wowmon_gfs";
	private static String ENB = "ENB";
	private static String NEW_LINE = "\n";
	private static int count = 0;
	private static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) throws IOException {

		HSSFSheet sheet = readFile();
		Iterator<Row> itr = sheet.iterator();
		while (itr.hasNext()) {
			Row row = itr.next();
			try {
				createBMI(row);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(row.getRowNum());
				System.exit(1);
			}

		}
		writeOutput(sb.toString(), FILE_PATH + "address.bmi", "UTF8");
		writeOutput(error.toString(), FILE_PATH + "error.xls", "UTF8");
		System.out.println(map);
		System.out.println("Failed - " + count);
		// FileManager.createFile("C:/bms/test.bmi", sb.toString());
	}

	private static void createBMI(Row row) {
		// String s =
		// "I|USER_ACCOUNT|dm_abatra@woolworths.com.au|dm|B2C|A|7c4af209b53762d0619aea20eb3dbd64eb87eb1b|false|Anuj||Batra|abatra@woolworths.com.au|8939920293|||false|||31393";
		String email = "";
		boolean isBadInput = false;
		StringBuffer s = new StringBuffer("I|ADDRESS||");
		Cell cell = row.getCell(3);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			email = cell.getStringCellValue().trim();
			if (!isBadInput && !"".equals(email) && null != email) {
				s.append(email).append(DELIMETER).append(B2C).append(DELIMETER)
						.append(WOW_MON).append(DELIMETER).append(ENB)
						.append(DELIMETER).append(DELIMETER).append(DELIMETER)
						.append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(23);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			System.out.println(cell.getStringCellValue().trim());
			String addrss = cell.getStringCellValue().trim();
			if (!isBadInput && !"".equals(addrss) && null != addrss
					&& !"NULL".equals(addrss)) {
				s.append(addrss).append(DELIMETER).append(DELIMETER)
						.append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(24);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String sub = cell.getStringCellValue().trim();
			if (!isBadInput && !"".equals(sub) && null != sub
					&& !"NULL".equals(sub)) {
				s.append(sub).append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(25);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);

			if (!isBadInput && !"".equals(cell.getStringCellValue().trim())
					&& null != cell.getStringCellValue().trim()
					&& !"NULL".equals(cell.getStringCellValue().trim())) {
				s.append(cell.getStringCellValue().trim()).append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(26);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String postCd = "";
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				postCd = Double.toString(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				postCd = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				postCd = cell.getCellFormula();
				break;
			default:
				postCd = cell.getRichStringCellValue().getString();
				break;
			}

			if (!isBadInput && !"".equals(postCd) && null != postCd
					&& !"NULL".equals(postCd)) {
				s.append(postCd).append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(27);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			if (!isBadInput && !"".equals(cell.getStringCellValue().trim())
					&& null != cell.getStringCellValue().trim()
					&& !"NULL".equals(cell.getStringCellValue().trim())) {
				map.put(cell.getStringCellValue().trim(), "");
				s.append(cell.getStringCellValue().trim()).append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(4);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String phone = null;
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:
				phone = Double.toString(cell.getNumericCellValue());
				break;
			case Cell.CELL_TYPE_STRING:
				phone = cell.getStringCellValue();
				break;
			case Cell.CELL_TYPE_FORMULA:
				phone = cell.getCellFormula();
				break;
			default:
				phone = cell.getRichStringCellValue().getString();
				break;
			}
			if (!isBadInput && !"".equals(phone) && null != phone
					&& !"NULL".equals(phone)) {
				s.append(phone).append(DELIMETER).append("BTH")
						.append(DELIMETER).append(DELIMETER).append(DELIMETER)
						.append(DELIMETER);
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(1);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);

			if (!isBadInput && !"".equals(cell.getStringCellValue().trim())
					&& null != cell.getStringCellValue().trim()
					&& !"NULL".equals(cell.getStringCellValue().trim())) {
				s.append(cell.getStringCellValue().trim()).append(" ");
			} else {
				isBadInput = true;
			}
		}
		cell = row.getCell(2);
		if (null != cell) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			if (!isBadInput && !"".equals(cell.getStringCellValue().trim())
					&& null != cell.getStringCellValue().trim()
					&& !"NULL".equals(cell.getStringCellValue().trim())) {
				s.append(cell.getStringCellValue().trim());
			} else {
				isBadInput = true;
			}
		}
		if (!isBadInput) {
			sb.append(s).append("\n");
		} else {
			count++;
			error.append(email).append("\n");
		}

	}

	public static HSSFSheet readFile() throws IOException {
		FileInputStream stream = new FileInputStream(FILE_PATH + FILE_NAME);
		HSSFWorkbook wb = new HSSFWorkbook(stream);
		HSSFSheet sheet = wb.getSheetAt(0);
		return sheet;
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
