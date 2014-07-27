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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import au.com.woolworths.mcr.thirdparty.batch.util.MCRCmdAppErrorLogging;
import au.com.woolworths.mcr.util.MCRSiteUtils;

import com.bluemartini.database.BMDatabaseManager;
import com.bluemartini.database.BMResultSet;
import com.bluemartini.database.BMStatement;
import com.bluemartini.database.BindArray;
import com.bluemartini.database.DBUtil;
import com.bluemartini.dna.BMContext;
import com.bluemartini.dna.BMException;
import com.bluemartini.dna.BMLog;
import com.bluemartini.dna.BusinessObject;
import com.bluemartini.dna.BusinessObjectArray;
import com.bluemartini.dna.CommandLine;
import com.bluemartini.dna.DNAList;
import com.bluemartini.dna.DNAStringArray;
import com.bluemartini.htmlapp.HTMLContentUtil;
import com.bluemartini.util.MainApp;


/**
 * This class is used for three process 1-Read the fraud In file and update
 * fraud status 2-Send fraud PASS credit card orders to fulfill 3-Send fraud
 * Fail credit card orders to cancel 4-Send return status orders
 * 
 * @author 308635 Version 1.0
 */
public class MCRDMCompSubscription extends MainApp {

	// Batch Details
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
	private static String TABLE_COLMNS = "# EMAIL_ADDRESS | FIRST_NAME | LAST_NAME | STATE_CD | INTEREST1 | INTEREST2 | INTEREST3 | INTEREST4 | INTEREST5 | INTEREST6 | INTEREST7 | INTEREST8 | INTEREST9 | SUBSCRIBED_BY | \n " ;
	private static HashSet<String> stateList = new HashSet<String>();
	static {
		stateList.add("NSW");
		stateList.add("ACT");
		stateList.add("VIC");
		stateList.add("QLD");
		stateList.add("SA");
		stateList.add("TAS");
		stateList.add("NT");
		stateList.add("WA");
	}
	
	protected MCRDMCompSubscription() {
		super(BATCH_NAME, CONFIG_PATH);
	}

	@Override
	protected void setupOptions() {
		setEnvironmentOption(true, true);
		setPublishVersionOption(true, false);
		setLocaleOption(true);
		setCommandLineLogging(true);

		CommandLine.addStringOption("BANNER");
		CommandLine.setDescription("BANNER", "Banner like BIGW or DSAU.");
		CommandLine.setRequired("BANNER");

		CommandLine.addStringOption("STATE_ENV");
		CommandLine.setDescription("STATE_ENV", "State like PROD or ACPT.");
		CommandLine.setRequired("STATE_ENV");

		CommandLine.addStringOption("CSV_FILE");
		CommandLine.setDescription("CSV_FILE",
				"Absolute path for the CSV file.");
		
		CommandLine.addStringOption("ERROR_FILE");
		CommandLine.setDescription("ERROR_FILE",
				"Absolute path for the Error file.");
		
		CommandLine.addStringOption("JOB_STATUS");
		CommandLine.setDescription("JOB_STATUS",
				"Indicator of job running succesful/failed.");
		
		super.setupOptions();
	}

	public static void main(String[] args) {
		MCRDMCompSubscription batchObj = new MCRDMCompSubscription();
		batchObj.mainImpl(args);
	}

	@Override
	protected void run() throws BMException {
		String errorFileNameWithPath = "";
		String from = null;
		String to = null;
		String subject = null;
		StringBuffer newSub = new StringBuffer();
		boolean isErrorThown = false;
		String msgBody = null;
		String msgBodyFail = null;
		boolean isSendErrorMail = false;
		StringBuffer errors = new StringBuffer(TABLE_COLMNS);
		DNAList dnaCmdLineOptions = CommandLine.getOptions();
		String banner = dnaCmdLineOptions.getString(BANNER);
		String state = dnaCmdLineOptions.getString(STATE_ENV);
		String target = dnaCmdLineOptions.getString(CSV_FILE);
		String errorFile = dnaCmdLineOptions.getString(ERROR_FILE);
		String jobStatus = dnaCmdLineOptions.getString(JOB_STATUS);
		boolean fieldValid = true;
		BusinessObject boNewsLetter = BMContext
				.createBusinessObject("SUBSCRIPTION_INFO");
		MCRCmdAppErrorLogging
				.logMessage("Inside Competition Subscription batch");
		StringBuffer configfileName = new StringBuffer();
		configfileName.append(TMP_FILE_NAME);
		configfileName.append("_");
		configfileName.append(banner);
		configfileName.append("_");
		configfileName.append(state);
		configfileName.append(".dna");
		Pattern emailPattern = Pattern
				.compile("^['_A-Za-z0-9-\\+]+(\\.['_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		boolean isValidEmail = false;
		CONFIG_FILE_NAME = configfileName.toString();
		StringBuffer sbErrors = new StringBuffer();
		DNAList dnaModules = BMContext.loadAndMergeDNAsFromModules(
				CONFIG_FILE_NAME, sbErrors);
		String host = dnaModules.getString("smtpHost");
		String errorMailContPath = MCRSiteUtils.getAssortmentOrContentPath("ErrorEmailContent");
		com.bluemartini.htmlapp.Content errorMailCont = HTMLContentUtil.getContentByName(errorMailContPath);
		
		if ((null != errorMailCont)
				&& "A".equals(errorMailCont
						.getString("status_cd"))){
			from = errorMailCont.getString("ATR_EmailFrom");
			to = errorMailCont.getString("ATR_EmailTo");
			subject = errorMailCont.getString("ATR_EmailSubject");
			msgBody = errorMailCont.getString("ATR_EmailMsgBody");
			isSendErrorMail = errorMailCont.getBoolean("ATR_isEmailSend", false);
			
		}else{
			from = dnaModules.getString("from","");
			to = dnaModules.getString("to","");
			newSub.append(dnaModules.getString("msg1",""));
			if(!"".equals(newSub.toString())){
				newSub.append(state).append(dnaModules.getString("msg2",""));
			}
			msgBodyFail = dnaModules.getString("msgBodyFail","");
			isSendErrorMail = dnaModules.getBoolean("sendErrorMail",false);
		}
		if (null != dnaModules.getString("errorFilePath")
				&& !"".equalsIgnoreCase("errorFilePath")
				&& null != dnaModules.getString("errorFileName")
				&& !"".equalsIgnoreCase("errorFileName")) {
			errorFileNameWithPath = dnaModules
					.getString("errorFilePath")
					.concat(Long.toString(System.currentTimeMillis()))
					.concat("_")
					.concat(dnaModules.getString("errorFileName").concat(SUB)
							.concat(EXTENSION));
		}
		int uploadCount = dnaModules.getInteger("uploadCountRecord", 100);
		//DNAStringArray tableEmailIDs = fetchTableEmailIDs();
		DNAStringArray fileEmailIDs = new DNAStringArray();
		BusinessObjectArray insertBOArrNewsLetter = new BusinessObjectArray();
		BusinessObjectArray updateBOArrNewsLetter = new BusinessObjectArray();
		BufferedReader r = null;
		BusinessObject lengthValidate = new BusinessObject();
		try {
			if(null!=target && !"".equalsIgnoreCase(target)){
			String line = "";
			r = new BufferedReader(new FileReader(target));
			line = r.readLine();
			while (line != null) {
				fieldValid = true;
				lengthValidate = new BusinessObject();
				isValidEmail = false;
				String[] newsLetterValues = line.split(",");
				for (int index = 0; index < newsLetterValues.length; index++) {
					if (newsLetterValues[index].contains("\"")) {
						newsLetterValues[index] = newsLetterValues[index]
								.replace("\"", "");
					}
				}
				Matcher m = emailPattern.matcher(newsLetterValues[0]);
				isValidEmail = m.matches();
				if (newsLetterValues.length == dnaModules.getInteger(
						"csvRecordLength", 14) && isValidEmail) {
					boNewsLetter.clear();
					boNewsLetter.setString("status", "S");
					boNewsLetter.setString("subscribedSource", "COMP");
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.EMAIL,"dm_"
							+ newsLetterValues[0]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.FIRST_NAME,newsLetterValues[1]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.LAST_NAME,newsLetterValues[2]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.STATE_CD,newsLetterValues[3]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_1,newsLetterValues[4]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_2,newsLetterValues[5]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_3,newsLetterValues[6]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_4,newsLetterValues[7]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_5,newsLetterValues[8]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_6,newsLetterValues[9]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_7,newsLetterValues[10]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_8,newsLetterValues[11]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.INTEREST_9,newsLetterValues[12]);
					lengthValidate = isFieldLenthValid(lengthValidate,boNewsLetter,FieldValidator.SUBSCRIBED_BY,newsLetterValues[13]);
					
					if (isEMailExists("dm_" + newsLetterValues[0])) {
						if((!lengthValidate.isEmpty()) && (null != lengthValidate.getStringArray("lengthErrors"))
								&&(lengthValidate.getStringArray("lengthErrors").size() > 0)){
							isErrorThown = true;
							errors.append(BREAK);
							errors.append(LINE_ERROR);
							errors.append(BREAK);
							errors.append("#Line :" + line);
							errors.append(BREAK);
							DNAStringArray errorArray = lengthValidate.getStringArray("lengthErrors");
							for(String str : errorArray){
								errors.append(str);
								errors.append(BREAK);
							}
							errors.append(BREAK);
						}else {
							updateBOArrNewsLetter.addElement(boNewsLetter);
						}
					} else {
						if (!fileEmailIDs.isEmpty()
								&& fileEmailIDs.contains(newsLetterValues[0])) {
							if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
								BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
										"MCRDMCompSubscription", "run method",
										"Duplicate email entry in the csv file--email :"
												+ newsLetterValues[0], null,
										false);
							}
							isErrorThown = true;
							errors.append(BREAK);
							errors.append(LINE_ERROR);
							errors.append(BREAK);
							errors.append("#Line :" + line);
							errors.append(BREAK);
							errors.append(DUPLICATE_EMAIL);
							errors.append(BREAK);
						} else {
							if((!lengthValidate.isEmpty()) && (null != lengthValidate.getStringArray("lengthErrors"))
									&&(lengthValidate.getStringArray("lengthErrors").size() > 0)){
								isErrorThown = true;
								errors.append(BREAK);
								errors.append(LINE_ERROR);
								errors.append(BREAK);
								errors.append("#Line :" + line);
								errors.append(BREAK);
								DNAStringArray errorArray = lengthValidate.getStringArray("lengthErrors");
								for(String str : errorArray){
									errors.append(str);
									errors.append(BREAK);
								}
								errors.append(BREAK);
							}else {
								insertBOArrNewsLetter.addElement(boNewsLetter);
								fileEmailIDs.add(newsLetterValues[0]);
							}
						}

					}
				} else {
					if (!isValidEmail) {
						if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
							BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
									"MCRDMCompSubscription", "run method",
									"Invalid email format in the csv file record--line :"
											+ line, null, false);
						}
						isErrorThown = true;
						errors.append(BREAK);
						errors.append(LINE_ERROR);
						errors.append(BREAK);
						errors.append("#Line :" + line);
						errors.append(BREAK);
						errors.append(INVALID_EMAIL);
						errors.append(BREAK);
					} else {
						if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
							BMLog.logRef(
									BMLog.COMPONENT_EXCEPTIONS,
									0,
									"MCRDMCompSubscription",
									"run method",
									"Invalid number of entries in the csv file--record :"
											+ line
											+ ",--Number of entries is "
											+ newsLetterValues.length
											+ ",Correct value ="
											+ dnaModules.getInteger(
													"csvRecordLength", 14),
									null, false);
						}
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
				line = r.readLine();
			}
			if (null != insertBOArrNewsLetter
					&& insertBOArrNewsLetter.size() > 0) {
				bulkInsertIntoTable(insertBOArrNewsLetter, uploadCount);
			}
			if (null != updateBOArrNewsLetter
					&& updateBOArrNewsLetter.size() > 0) {
				int i =0 ;
				while(i < updateBOArrNewsLetter.size()){
					bulkUpdateTable(updateBOArrNewsLetter, i,(i+uploadCount > updateBOArrNewsLetter.size())?updateBOArrNewsLetter.size() : i+uploadCount);
					i = (i+uploadCount > updateBOArrNewsLetter.size())?updateBOArrNewsLetter.size() : i+uploadCount;
				}
			}
		  } 
			if(null!=errorFile && !"".equalsIgnoreCase(errorFile) && isSendErrorMail){
				 sendMail(errorFile,host,from,to,newSub,msgBodyFail,jobStatus, dnaModules);
		  }
		 
		}catch (FileNotFoundException e) {
			e.printStackTrace();
			isErrorThown = true;
			errors.append(BREAK);
			errors.append(FILE_ERROR);
			errors.append(FILE_NOT_FOUND);
			errors.append(BREAK);
			errors.append("#Exception :" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			isErrorThown = true;
			errors.append(BREAK);
			errors.append(FILE_ERROR);
			errors.append(IO_EXCEPTION);
			errors.append(BREAK);
			errors.append("#Exception :" + e.getMessage());
		} finally {
			try {
				if (null != r) {
					r.close();
				}
				if (errors.length() > 0
						&& !"".equalsIgnoreCase(errorFileNameWithPath) && (isErrorThown)) {
					errors.append(ABOVE_ERRORS);
					errors.append(BREAK);
					errors.append(target);
					errors.append(BREAK);
					errors.append(SEPARATOR);
					errors.append(BREAK);
					writeOutput(errors.toString(), errorFileNameWithPath,
							UTF8_ENCODING );
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// System.exit(exitValue);

	}

	
	public static BusinessObject isFieldLenthValid(BusinessObject lengthValidate,BusinessObject boNewsLetter,FieldValidator validator ,String fieldValue){
		boolean isFieldLengthValid = true;
		boolean isStateMismatch = true;
		StringBuffer errorMesage = new StringBuffer();
		DNAStringArray strArry = lengthValidate.getStringArray("lengthErrors");
		if(strArry == null){
			strArry = new DNAStringArray();
		}
		if(fieldValue.length() > 0 ){
			fieldValue = fieldValue.replace("\"", "");
			if(validator == FieldValidator.STATE_CD){
				if(!((fieldValue.length() == validator.fieldLength-1) || (fieldValue.length() == validator.fieldLength))){
					isFieldLengthValid = false;
				}
				if(!stateList.contains((String)fieldValue)){
					isStateMismatch = false;
				}
			}else if(fieldValue.length() > validator.fieldLength){
				isFieldLengthValid = false;
			}
			if(!isFieldLengthValid){
				errorMesage.append(FAILED_MSSG).append(validator.myFieldName).append(INVALID_LENGTH_ERROR_EXCCEDS).append(validator.fieldLength).append(INVALID_LENGTH_ERROR_CHAR);
				strArry.add(errorMesage.toString());
				lengthValidate.setStringArray("lengthErrors", strArry);
			}
			else if(!isStateMismatch){
				strArry.add(INVALID_STATE);
				lengthValidate.setStringArray("lengthErrors", strArry);
			}else {
				if(FieldValidator.EMAIL == validator || FieldValidator.FIRST_NAME == validator || FieldValidator.LAST_NAME == validator || FieldValidator.SUBSCRIBED_BY == validator){
					fieldValue = fieldValue.replace("'", "''");
				}
				boNewsLetter.setString(validator.fieldName, fieldValue);
			}
		}
		return lengthValidate;
	}
	
	public static boolean isEMailExists(String email) throws BMException {
		boolean isEMailExist = false;
		try {
			BMDatabaseManager.pushCurrentDatabase("custom");
			BindArray array = new BindArray();
			array.addString(email);
			if(DBUtil.selectCount("NEWSLETTER_SUBSCRIPTION", "EMAIL_ADDRESS=?", array) > 0){
				isEMailExist = true;
			}
		} catch (BMException e) {
			if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
				BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
						"MCRDMCompSubscription", "fetchTableEmailIDs",
						e.getMessage(), null, false);
			}
			// System.exit(1);
		} finally {
			BMDatabaseManager.popCurrentDatabase("custom");
		}
		return isEMailExist;
	}

	public static void bulkInsertIntoTable(
			BusinessObjectArray insertBOArrNewsLetter, int uploadCount) throws BMException {
		int totalRow = 0;
		boolean erroroccured = false;
		BMStatement stmtordNews = null;
		BMResultSet rsordNews = null;
		StringBuffer giftGenNews = new StringBuffer(86);
		try {
			BMDatabaseManager.pushCurrentDatabase("custom");
			giftGenNews.append(INSERT_TEXT);
			for (BusinessObject insertBONewsLetter : insertBOArrNewsLetter) {
				totalRow +=1;
				giftGenNews.append(TABLE_INSERT_QUERY);
				giftGenNews.append(insertBONewsLetter.getString("userid"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("firstName"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("lastName"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("state_cd"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest1"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest2"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest3"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest4"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest5"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest6"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest7"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest8"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("interest9"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews
						.append(insertBONewsLetter.getString("subscribedBy"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter.getString("status"));
				giftGenNews.append(STRING_JOINER);
				giftGenNews.append(insertBONewsLetter
						.getString("subscribedSource"));
				giftGenNews.append(QUOTE_JOINER);
				giftGenNews.append("SYSDATE");
				giftGenNews.append(",").append("SYSDATE");
				giftGenNews.append(CLOSE_COMMA_JOINER);
				
				if(totalRow == uploadCount){
					giftGenNews.append(SELECT_TEXT);
					MCRCmdAppErrorLogging
					.logMessage("----------------------------------");
					MCRCmdAppErrorLogging
					.logMessage("Record Inserted : "+totalRow);
					MCRCmdAppErrorLogging
					.logMessage("Bulk insert query final form :"
							+ giftGenNews.toString());
					try{
						stmtordNews = BMDatabaseManager.getStatement();
						rsordNews = stmtordNews.executeQuery(giftGenNews.toString());
						MCRCmdAppErrorLogging.logMessage("TABLE INSERT SUCCESSFUL");
					}catch(BMException bme){
						if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
							BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
									"MCRDMCompSubscription", "bulkInsertIntoTable",
									bme.getMessage(), null, false);
						}
						erroroccured = true;
					}finally{
						if (null != rsordNews) {
							rsordNews.close();
						}
						if (null != stmtordNews) {
							stmtordNews.close();
						}
						totalRow = 0;
						giftGenNews = new StringBuffer(86);
						giftGenNews.append(INSERT_TEXT);
					}					
				}
			}
			if(totalRow > 0){
				giftGenNews.append(SELECT_TEXT);
				MCRCmdAppErrorLogging
				.logMessage("----------------------------------");
				MCRCmdAppErrorLogging
				.logMessage("Record Inserted : "+totalRow);
				MCRCmdAppErrorLogging
				.logMessage("Bulk insert query final form :"
						+ giftGenNews.toString());
				try{
					stmtordNews = BMDatabaseManager.getStatement();
					rsordNews = stmtordNews.executeQuery(giftGenNews.toString());
					MCRCmdAppErrorLogging.logMessage("TABLE INSERT SUCCESSFUL");
				}catch(BMException bme1){
					if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
						BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
								"MCRDMCompSubscription", "bulkInsertIntoTable",
								bme1.getMessage(), null, false);
					}
					erroroccured = true;
				}finally{
					if (null != rsordNews) {
						rsordNews.close();
					}
					if (null != stmtordNews) {
						stmtordNews.close();
					}
				}
				
				//totalRow = 0;
				//giftGenNews = new StringBuffer(86);
				//giftGenNews.append(INSERT_TEXT);
			}
			
			if(erroroccured){
				System.exit(1);
			}
			
		} catch (BMException e) {
			if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
				BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
						"MCRDMCompSubscription", "bulkInsertIntoTable",
						e.getMessage(), null, false);
			}
			System.exit(1);
		} finally {
			BMDatabaseManager.popCurrentDatabase("custom");
		}

	}

	public static void bulkUpdateTable(BusinessObjectArray updateBOArrNewsLetter, int uploadCountStart, int uploadCountEnd)
			throws BMException {
		BMStatement stmtordNews = null;
		BMResultSet rsordNews = null;
		StringBuffer giftGenNews = new StringBuffer(86);
		try {
			BMDatabaseManager.pushCurrentDatabase("custom");
			giftGenNews.append(TABLE_UPDATE_QUERY);
			giftGenNews.append(" SET FIRST_NAME = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"firstName",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" LAST_NAME = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"lastName",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" STATE_CD = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"state_cd",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST1 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest1",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST2 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest2",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST3 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest3",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST4 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest4",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST5 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest5",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST6 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest6",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST7 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest7",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST8 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest8",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" INTEREST9 = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"interest9",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" SUBSCRIBED_BY= CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"subscribedBy",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" STATUS_CD= CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"status",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" SUBSCRIBED_SOURCE = CASE EMAIL_ADDRESS");
			constructUpdateQuerySub(giftGenNews, updateBOArrNewsLetter,
					"subscribedSource",uploadCountStart,uploadCountEnd);
			giftGenNews.append(" UPDATE_DT = SYSDATE");
			// giftGenNews =
			// constructUpdateQuerySub(giftGenNews,updateBOArrNewsLetter);
			giftGenNews.append(" WHERE EMAIL_ADDRESS IN ('");
			for (int i = uploadCountStart; i < uploadCountEnd; i++) {
				giftGenNews.append(updateBOArrNewsLetter.get(i).getString(
						"userid"));
				if (i != uploadCountEnd -1) {
					giftGenNews.append("','");
				}
			}
			giftGenNews.append("')");
			MCRCmdAppErrorLogging
			.logMessage("--------------------------");
			MCRCmdAppErrorLogging
			.logMessage("Uploading data between : "+uploadCountStart+ " and "+uploadCountEnd);
			MCRCmdAppErrorLogging
			.logMessage("Bulk update query final form :"
					+ giftGenNews.toString());
			stmtordNews = BMDatabaseManager.getStatement();
			rsordNews = stmtordNews.executeQuery(giftGenNews.toString());
			System.out.println("TABLE UPDATE SUCCESSFUL");

		} catch (BMException e) {
			if (BMLog.logEnabled(BMLog.COMPONENT_EXCEPTIONS, 0)) {
				BMLog.logRef(BMLog.COMPONENT_EXCEPTIONS, 0,
						"MCRDMCompSubscription", "bulkUpdateIntoTable",
						e.getMessage(), null, false);
			}
			System.exit(1);
		} finally {
			if (null != rsordNews) {
				rsordNews.close();
			}
			if (null != stmtordNews) {
				stmtordNews.close();
			}
			BMDatabaseManager.popCurrentDatabase("custom");
		}

	}

	/**
	 * @param giftGenNews
	 * @param updateBOArrNewsLetter
	 * @return
	 */
	private static StringBuffer constructUpdateQuerySub(
			StringBuffer giftGenNews, BusinessObjectArray updateBOArrNewsLetter) {
		for (BusinessObject updateBONewsLetter : updateBOArrNewsLetter) {
			giftGenNews.append(" WHEN '");
			giftGenNews.append(updateBONewsLetter.getString("userid"));
			giftGenNews.append("'");
			giftGenNews.append(" THEN ");
			giftGenNews.append("SYSDATE");
		}
		giftGenNews.append(" END");
		return giftGenNews;
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

	
	public static StringBuffer constructUpdateQuerySub(
			StringBuffer giftGenNews,
			BusinessObjectArray updateBOArrNewsLetter, String term,int uploadCountStart, int uploadCountEnd) {
		//for (BusinessObject updateBONewsLetter : updateBOArrNewsLetter) {
		for (int i = uploadCountStart;i < uploadCountEnd;i++) {
			BusinessObject updateBONewsLetter = updateBOArrNewsLetter.get(i);
			giftGenNews.append(" WHEN '");
			giftGenNews.append(updateBONewsLetter.getString("userid"));
			giftGenNews.append("'");
			giftGenNews.append(" THEN '");
			giftGenNews.append(updateBONewsLetter.getString(term));
			giftGenNews.append("'");
		}
		giftGenNews.append(" END");
		giftGenNews.append(",");
		return giftGenNews;

	}
	
	public static void sendMail(String errorFileName,String host,String from,String to,StringBuffer subject,String msgBody,String jobStatus,DNAList dnaModules ){
	     
	      Properties properties = System.getProperties();
	      properties.setProperty(SMTP, host);
	      Session session = Session.getDefaultInstance(properties);
	      SimpleDateFormat createDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa");
	      subject.append(("F".equals(jobStatus))?dnaModules.getString("failedMsg",""):dnaModules.getString("successfulMsg","")).append(" @ ").append(createDateFormat.format(Calendar.getInstance().getTime()));
	      String[] toArr= to.split(",");
	      try{
	         MimeMessage message = new MimeMessage(session);
	         message.setFrom(new InternetAddress(from));
	      	 for(String toVal:toArr){
	          message.addRecipient(Message.RecipientType.TO,
	      	                        new InternetAddress(toVal));
	      	 }
	          message.setSubject(subject.toString());
	         
	         Multipart multipart = new MimeMultipart();
	         BodyPart messageBodyPart = new MimeBodyPart();
	         messageBodyPart.setText(subject.toString()+BREAK);
	         multipart.addBodyPart(messageBodyPart);
	         if("F".equals(jobStatus)){
	        	 messageBodyPart = new MimeBodyPart();
	        	 messageBodyPart.setText(msgBody);
	        	 multipart.addBodyPart(messageBodyPart);
	        	 messageBodyPart = new MimeBodyPart();
	        	 String filename = errorFileName;
	        	 DataSource source = new FileDataSource(filename);
	        	 messageBodyPart.setDataHandler(new DataHandler(source));
	        	 messageBodyPart.setFileName(dnaModules.getString("errorFileName","Competetion_Subscription_Failed_Record.txt"));
	        	 multipart.addBodyPart(messageBodyPart);
	         }
	         message.setContent(multipart );
	         Transport.send(message);
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         System.exit(1);
	      }
	}

	
	public enum FieldValidator {
		EMAIL(240,"userid","EMAIL"),FIRST_NAME(20,"firstName","FIRST_NAME"),LAST_NAME(20,"lastName","LAST_NAME"),INTEREST_1(20,"interest1","INTEREST_1"),INTEREST_2(20,"interest2","INTEREST_2"),INTEREST_3(20,"interest3","INTEREST_3"),INTEREST_4(20,"interest4","INTEREST_4"),
		INTEREST_5(20,"interest5","INTEREST_5"),INTEREST_6(20,"interest6","INTEREST_6"),INTEREST_7(20,"interest7","INTEREST_7"),INTEREST_8(20,"interest8","INTEREST_8"),INTEREST_9(20,"interest9","INTEREST_9"),STATE_CD(3,"state_cd","STATE_CD"),SUBSCRIBED_BY(120,"subscribedBy","SUBSCRIBED_BY");
		
		int fieldLength = 0;
		String fieldName = "";
		String myFieldName = "";
		/**
		 * @param fieldLength
		 */
		
		
		public boolean isFieldValid(FieldValidator fieldName, String fieldVal){
			return (fieldVal.length() <=  fieldName.fieldLength )?true:false;
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
