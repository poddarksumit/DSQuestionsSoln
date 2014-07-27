/*
 * Copyright (C) 2009 Woolworths Limited
 *
 * 1 Woolworths Way Bella Vista NSW 2153 Australia
 * All rights reserved.
 * This software is the confidential and proprietary information of Woolworths Limited. You shall not disclose
 * such confidential information and shall use it only in accordance with the terms of the licence agreement
 * you entered into with Woolworths Limited.
 * No part of this document may be presented, reproduced or copied in any form or by any means (graphical,
 * electronic or mechanical including photocopying, recording tape or by any information storage and
 * retrieval system) without the express written permission of Woolworths Ltd.
 * Unpublished work.
 */
package thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.easymock.internal.Results;

import thread.MCRDMCompSubscription.FieldValidator;

import com.sun.xml.internal.fastinfoset.util.StringArray;

/**
 * This class is used to
 * 
 * @author xspro Version 1.0
 */
public class MCRCompetitionSubscriptionTread implements Runnable {
	private static final String CSV_PATH = "C:\\Users\\Sumit\\Downloads\\sub\\sub\\";
	private static HashSet<String> stateList = new HashSet<String>();
	private static final String USERNAME = "system";
	private static final String PASSWORD = "system";
	private static final String URL = "jdbc:oracle:thin:system/system@localhost:1521:xe";
	private static Connection conn = null;
	private static Statement statement = null;
	private static final String ERROR_PATH = "C:\\Users\\Sumit\\Downloads\\sub\\sub\\";

	private static final String BATCH_NAME = "MCRDMCompSubscription";
	private static final String CONFIG_PATH = "mcr/tools/DMCompSubs/compSubscription.DM.appconfig.dna";
	private static final String TMP_FILE_NAME = "comp_subs_config";
	private static final String BANNER = "BANNER";
	private static final String STATE_ENV = "STATE_ENV";
	private static final String CSV_FILE = "CSV_FILE";
	private static final String ERROR_FILE = "ERROR_FILE";
	private static final String JOB_STATUS = "JOB_STATUS";
	private static final String EMAIL_SEND = "EMAIL_SEND";
	private static final String locale = "locale";
	private static String CONFIG_FILE_NAME = null;
	private static String COMP_INBOUND = "COMP_INBOUND";
	private static String INSERT_TEXT = "INSERT ALL";
	private static String STRING_JOINER = "','";
	private static String CLOSE_JOINER = "')";
	private static String UTF8_ENCODING = "UTF8";
	private static String QUOTE_JOINER = "',";
	private static String CLOSE_COMMA_JOINER = ")";
	private static String BREAK = "\n";
	private static String EXTENSION = ".txt";
	private static String SMTP = "mail.smtp.host";
	private static String SUB = "_error";
	private static String LINE_ERROR = "#Line Level Error";
	private static String ABOVE_ERRORS = "Above errors are for the csv file :";
	private static String SEPARATOR = "---------------------------------------------------------------------------------------------------------------------";
	private static String FILE_ERROR = "#Record Level Error";
	private static String INVALID_EMAIL = "# Failed due to -- Invalid email format in the csv file record";
	private static String INVALID_NUMBER_OF_ENTRIES = "# Failed due to -- Invalid number of columns in the csv file";
	private static String DUPLICATE_EMAIL = "# Failed due to -- Duplicate email entry in the csv file";
	private static String FILE_NOT_FOUND = "# Failed due to -- File Not Found Exception";
	private static String FAILED_MSSG = "# Failed due to -- ";
	private static String INVALID_STATE = "# Failed due to -- Invalid state entry in CSV file.";
	private static String IO_EXCEPTION = "# Failed due to -- Input Output read Exception";
	private static String SELECT_TEXT = " SELECT * FROM DUAL";
	private static String TABLE_INSERT_QUERY = " INTO NEWSLETTER_SUBSCRIPTION (EMAIL_ADDRESS,FIRST_NAME,LAST_NAME,STATE_CD,INTEREST1,INTEREST2,INTEREST3,INTEREST4,INTEREST5,INTEREST6,INTEREST7,INTEREST8,INTEREST9,SUBSCRIBED_BY,STATUS_CD,SUBSCRIBED_SOURCE,SUBSCRIBED_DT,UPDATE_DT) VALUES ('";
	private static String COMP = "COMP";
	private static String INVALID_LENGTH_ERROR_EXCCEDS = " exceeded ";
	private static String INVALID_LENGTH_ERROR_CHAR = " character.";
	private static String TABLE_UPDATE_QUERY = "UPDATE NEWSLETTER_SUBSCRIPTION";
	private static String TABLE_COLMNS = "# EMAIL_ADDRESS | FIRST_NAME | LAST_NAME | STATE_CD | INTEREST1 | INTEREST2 | INTEREST3 | INTEREST4 | INTEREST5 | INTEREST6 | INTEREST7 | INTEREST8 | INTEREST9 | SUBSCRIBED_BY | \n ";
	private static final int ROW_INSERT = 100;

	static {
		stateList.add("NSW");
		stateList.add("ACT");
		stateList.add("VIC");
		stateList.add("QLD");
		stateList.add("SA");
		stateList.add("TAS");
		stateList.add("NT");
		stateList.add("WA");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
	}

	class TotalRowRecord {
		int rowCount = 0;
		boolean isErrorOccurred = false;

		private TotalRowRecord(int rowCount, boolean isErrorOccurred) {
			super();
			this.rowCount = rowCount;
			this.isErrorOccurred = isErrorOccurred;
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MCRCompetitionSubscriptionTread demo = new MCRCompetitionSubscriptionTread();
		demo.run();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		long startTime = getTimeInMillis();
		File[] files = fetchFiles();
		Pattern emailPattern = Pattern
				.compile("^['_A-Za-z0-9-\\+]+(\\.['_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean isValidEmail = false;
		if (null != files && files.length > 0) {
			int fileSize = files.length;
			for (File file : files) {
				new MCRCompetitionSubsProcess(file);
				processFile(file, emailPattern);
			}
		}
		System.out.println("Time Spent : " + ((getTimeInMillis() - startTime)));
	}

	private long getTimeInMillis() {
		return System.currentTimeMillis();
	}

	public static File[] fetchFiles(String filePath) {
		return getFilesInDirectory(filePath, "csv");
	}

	public static File[] getFilesInDirectory(String aupostPath, String extension) {
		if (isFolderValid(aupostPath)) {
			return getFilesInDirectory(new File(aupostPath), extension);
		} else {
			return null;
		}
	}

	public static boolean isFolderValid(File file) {
		boolean isValid = false;
		if (file.exists() && file.canRead() && file.isDirectory()) {
			isValid = true;
		}
		return isValid;
	}

	public static boolean isFolderValid(String path) {
		if (null != path) {
			File file = new File(path);
			return isFolderValid(file);
		} else {
			return false;
		}
	}

	public static File[] getFilesInDirectory(File file, final String extension) {

		File[] files;
		if (null != extension) {
			files = file.listFiles(new FilenameFilter() {
				public boolean accept(File file, String filename) {
					return filename.endsWith(extension);
				}
			});
		} else {
			files = file.listFiles();
		}

		return files;
	}

	public void processFile(File file, Pattern emailPattern) {
		String line = "";
		StringBuffer errorFileNameWithPath = new StringBuffer(ERROR_PATH);
		errorFileNameWithPath.append("ERROR_" + file.getName() + "x");
		boolean isErrorThown = false;
		StringBuffer errors = new StringBuffer(TABLE_COLMNS);
		ArrayList<String> fileEmailIDs = new ArrayList<String>();
		StringBuffer insertQuery = new StringBuffer(INSERT_TEXT);
		StringBuffer updateQuery = new StringBuffer(TABLE_UPDATE_QUERY);
		TotalRowRecord insertRowRec = new TotalRowRecord(0, false);
		TotalRowRecord udpateRowRec = new TotalRowRecord(0, false);
		try {
			BufferedReader r = new BufferedReader(new FileReader(file));
			createCoonection();
			while ((line = r.readLine()) != null) {
				String[] newsLetterValues = line.split(",");
				Matcher m = emailPattern.matcher(newsLetterValues[0].replace(
						"\"", ""));
				boolean isValidEmail = m.matches();
				if (newsLetterValues.length == 14 && isValidEmail) {
					isErrorThown = validateInputLine(newsLetterValues, line,
							errors);
					if (isEMailExists(newsLetterValues[0])) {
						if (!isErrorThown) {
							/*
							 * udpateRowRec = updateExistingRecord(
							 * newsLetterValues, updateQuery, udpateRowRec);
							 */
							if (udpateRowRec.rowCount == 0) {
								updateQuery = new StringBuffer(
										TABLE_UPDATE_QUERY);
							}
						}
					} else {
						if (!fileEmailIDs.isEmpty()
								&& fileEmailIDs.contains(newsLetterValues[0])) {
							isErrorThown = true;
							errors.append(BREAK);
							errors.append(LINE_ERROR);
							errors.append(BREAK);
							errors.append("#Line :" + line);
							errors.append(BREAK);
							errors.append(DUPLICATE_EMAIL);
							errors.append(BREAK);
						} else {
							if (!isErrorThown) {
								insertRowRec = updateAndInsertNewrecord(
										newsLetterValues, insertQuery,
										insertRowRec);
								if (insertRowRec.rowCount == 0) {
									insertQuery = new StringBuffer(INSERT_TEXT);
								}
								fileEmailIDs.add(newsLetterValues[0]);
							}
						}
					}
				} else {
					if (!isValidEmail) {
						isErrorThown = true;
						errors.append(BREAK);
						errors.append(LINE_ERROR);
						errors.append(BREAK);
						errors.append("#Line :" + line);
						errors.append(BREAK);
						errors.append(INVALID_EMAIL);
						errors.append(BREAK);
					} else {
						isErrorThown = true;
						errors.append(BREAK);
						errors.append(LINE_ERROR);
						errors.append(BREAK);
						errors.append("#Line :" + line);
						errors.append(BREAK);
						errors.append(INVALID_NUMBER_OF_ENTRIES);
						errors.append(BREAK);
					}

				}
			}

			if (insertRowRec.rowCount > 0) {
				System.out.println(insertRowRec.rowCount);
				insertQuery.append(SELECT_TEXT);
				insertIntoDatabase(insertQuery.toString(), insertRowRec);
			}

			if (udpateRowRec.rowCount > 0) {

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isErrorThown = true;
			errors.append(BREAK);
			errors.append(FILE_ERROR);
			errors.append(FILE_NOT_FOUND);
			errors.append(BREAK);
			errors.append("#Exception :" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			isErrorThown = true;
			errors.append(BREAK);
			errors.append(FILE_ERROR);
			errors.append(IO_EXCEPTION);
			errors.append(BREAK);
			errors.append("#Exception :" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (errors.length() > 0 && (isErrorThown)) {
					errors.append(ABOVE_ERRORS);
					errors.append(BREAK);
					errors.append(file.getAbsolutePath() + file.getName());
					errors.append(BREAK);
					errors.append(SEPARATOR);
					errors.append(BREAK);
					writeOutput(errors.toString(),
							errorFileNameWithPath.toString(), UTF8_ENCODING);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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

	/*
	 * public static boolean isEMailExists(String email) throws BMException {
	 * boolean isEMailExist = false; try {
	 * BMDatabaseManager.pushCurrentDatabase("custom"); BindArray array = new
	 * BindArray(); array.addString(email); if
	 * (DBUtil.selectCount("NEWSLETTER_SUBSCRIPTION", "EMAIL_ADDRESS=?", array)
	 * > 0) { isEMailExist = true; } } catch (BMException e) { if
	 * (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
	 * BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0, "MCRDMCompSubscription",
	 * "fetchTableEmailIDs", e.getMessage(), null, false); } // System.exit(1);
	 * } finally { BMDatabaseManager.popCurrentDatabase("custom"); } return
	 * isEMailExist; }
	 */

	public static void updateExistingRecord(String[] newsLetterValues,
			StringBuffer updateQuery, TotalRowRecord udpateRowRec) {
		/*
		 * udpateRowRec.rowCount = udpateRowRec.rowCount +1;
		 * updateQuery.append(" SET FIRST_NAME = CASE EMAIL_ADDRESS");
		 */
	}

	public static void validateAndInsertQuery(String[] newsletter, String line,
			StringBuffer errorString, StringBuffer insertQuery) {
		ArrayList<String> lengthValidate = validateInput(newsletter);
		if ((!lengthValidate.isEmpty()) && (lengthValidate.size() > 0)) {
			errorString.append(BREAK);
			errorString.append(LINE_ERROR);
			errorString.append(BREAK);
			errorString.append("#Line :" + line);
			errorString.append(BREAK);
			for (String str : lengthValidate) {
				errorString.append(str);
				errorString.append(BREAK);
			}
			errorString.append(BREAK);
		} else {

		}
	}

	public static boolean validateInputLine(String[] newsletter, String line,
			StringBuffer errorString) {
		ArrayList<String> lengthValidate = validateInput(newsletter);
		boolean isInValid = false;
		if ((!lengthValidate.isEmpty()) && (lengthValidate.size() > 0)) {
			errorString.append(BREAK);
			errorString.append(LINE_ERROR);
			errorString.append(BREAK);
			errorString.append("#Line :" + line);
			errorString.append(BREAK);
			for (String str : lengthValidate) {
				errorString.append(str);
				errorString.append(BREAK);
			}
			errorString.append(BREAK);
			isInValid = true;
		}
		return isInValid;
	}

	public static ArrayList<String> validateInput(String[] newsLetterValues) {
		ArrayList<String> str = new ArrayList<String>();
		str = isFieldLenthValid(str, FieldValidator.EMAIL, "dm_"
				+ newsLetterValues[0]);
		str = isFieldLenthValid(str, FieldValidator.FIRST_NAME,
				newsLetterValues[1]);
		str = isFieldLenthValid(str, FieldValidator.LAST_NAME,
				newsLetterValues[2]);
		str = isFieldLenthValid(str, FieldValidator.STATE_CD,
				newsLetterValues[3]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_1,
				newsLetterValues[4]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_2,
				newsLetterValues[5]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_3,
				newsLetterValues[6]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_4,
				newsLetterValues[7]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_5,
				newsLetterValues[8]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_6,
				newsLetterValues[9]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_7,
				newsLetterValues[10]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_8,
				newsLetterValues[11]);
		str = isFieldLenthValid(str, FieldValidator.INTEREST_9,
				newsLetterValues[12]);
		str = isFieldLenthValid(str, FieldValidator.SUBSCRIBED_BY,
				newsLetterValues[13]);
		return str;
	}

	public static TotalRowRecord updateAndInsertNewrecord(
			String[] newsLetterValues, StringBuffer insertQuery,
			TotalRowRecord insertRow) {
		insertRow.rowCount = insertRow.rowCount + 1;
		insertQuery.append(TABLE_INSERT_QUERY);
		insertQuery.append("dm_" + newsLetterValues[0].replace("'", "''"));
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[1].replace("'", "''"));
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[2].replace("'", "''"));
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[3]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[4]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[5]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[6]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[7]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[8]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[9]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[10]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[11]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[12]);
		insertQuery.append(STRING_JOINER);
		insertQuery.append("COMP");
		insertQuery.append(STRING_JOINER);
		insertQuery.append("S");
		insertQuery.append(STRING_JOINER);
		insertQuery.append(newsLetterValues[13].replace("'", "''"));
		insertQuery.append(QUOTE_JOINER);
		insertQuery.append("SYSDATE");
		insertQuery.append(",").append("SYSDATE");
		insertQuery.append(CLOSE_COMMA_JOINER);

		if (insertRow.rowCount == ROW_INSERT) {
			System.out.println(insertRow.rowCount);
			insertQuery.append(SELECT_TEXT);
			insertIntoDatabase(insertQuery.toString(), insertRow);
			insertRow.rowCount = 0;

		}
		return insertRow;
	}

	public static void insertIntoDatabase(String query, TotalRowRecord totalRec) {
		try {
			statement = conn.createStatement();
			statement.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			totalRec.isErrorOccurred = true;
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static boolean isEMailExists(String email) {
		boolean isEmailExist = false;
		ResultSet set = null;
		try {
			statement = conn.createStatement();
			set = statement.executeQuery(getEmailExistsQuery(email));
			while (set.next()) {
				if (set.getInt(1) > 0) {
					isEmailExist = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (set != null) {
					set.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isEmailExist;
	}

	public static void createCoonection() {
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getEmailExistsQuery(String email) {
		StringBuffer str = new StringBuffer();
		str.append(
				"SELECT COUNT(*) FROM NEWSLETTER_SUBSCRIPTION WHERE EMAIL_ADDRESS='dm_")
				.append(email).append("'");
		return str.toString();
	}

	public static ArrayList<String> isFieldLenthValid(
			ArrayList<String> lengthValidate, FieldValidator validator,
			String fieldValue) {
		boolean isFieldLengthValid = true;
		boolean isStateMismatch = true;
		StringBuffer errorMesage = new StringBuffer();
		if (lengthValidate == null) {
			lengthValidate = new ArrayList<String>();
		}
		if (fieldValue.length() > 0) {
			fieldValue = fieldValue.replace("\"", "");
			if (validator == FieldValidator.STATE_CD) {
				if (!((fieldValue.length() == validator.fieldLength - 1) || (fieldValue
						.length() == validator.fieldLength))) {
					isFieldLengthValid = false;
				}
				if (!stateList.contains((String) fieldValue)) {
					isStateMismatch = false;
				}
			} else if (fieldValue.length() > validator.fieldLength) {
				isFieldLengthValid = false;
			}
			if (!isFieldLengthValid) {
				errorMesage.append(FAILED_MSSG).append(validator.myFieldName)
						.append(INVALID_LENGTH_ERROR_EXCCEDS)
						.append(validator.fieldLength)
						.append(INVALID_LENGTH_ERROR_CHAR);
				lengthValidate.add(errorMesage.toString());
			} else if (!isStateMismatch) {
				lengthValidate.add(INVALID_STATE);
			} else {
				if (FieldValidator.EMAIL == validator
						|| FieldValidator.FIRST_NAME == validator
						|| FieldValidator.LAST_NAME == validator
						|| FieldValidator.SUBSCRIBED_BY == validator) {
					fieldValue = fieldValue.replace("'", "''");
				}
			}
		}
		return lengthValidate;
	}

	public enum FieldValidator {
		EMAIL(240, "userid", "EMAIL"), FIRST_NAME(20, "firstName", "FIRST_NAME"), LAST_NAME(
				20, "lastName", "LAST_NAME"), INTEREST_1(20, "interest1",
				"INTEREST_1"), INTEREST_2(20, "interest2", "INTEREST_2"), INTEREST_3(
				20, "interest3", "INTEREST_3"), INTEREST_4(20, "interest4",
				"INTEREST_4"), INTEREST_5(20, "interest5", "INTEREST_5"), INTEREST_6(
				20, "interest6", "INTEREST_6"), INTEREST_7(20, "interest7",
				"INTEREST_7"), INTEREST_8(20, "interest8", "INTEREST_8"), INTEREST_9(
				20, "interest9", "INTEREST_9"), STATE_CD(3, "state_cd",
				"STATE_CD"), SUBSCRIBED_BY(120, "subscribedBy", "SUBSCRIBED_BY");

		int fieldLength = 0;
		String fieldName = "";
		String myFieldName = "";

		/**
		 * @param fieldLength
		 */

		public boolean isFieldValid(FieldValidator fieldName, String fieldVal) {
			return (fieldVal.length() <= fieldName.fieldLength) ? true : false;
		}

		/**
		 * @param fieldLength
		 * @param fieldName
		 * @param myFieldName
		 */
		private FieldValidator(int fieldLength, String fieldName,
				String myFieldName) {
			this.fieldLength = fieldLength;
			this.fieldName = fieldName;
			this.myFieldName = myFieldName;
		}

	}
}
