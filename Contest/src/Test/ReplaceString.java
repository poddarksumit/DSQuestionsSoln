/**
 * 
 */
package Test;

import java.util.Comparator;

/**
 * This class is used to
 * 
 * @author Sumit 21-Jan-2013
 * 
 */
public class ReplaceString implements Comparable<String>, Comparator<String> {
	static String str;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(replace("itp", "tip"));

	}

	/**
	 * 
	 */
	public ReplaceString(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
	}

	public static String replace(String strTemp, String rep) {
		String newStr = "";
		if ((str != null) && (!"".equals(str))) {
			int length = strTemp.length();
			int i = 0;
			while (i < str.length()) {
				if (str.charAt(i) == strTemp.charAt(0)) {
					String str1 = str.substring(i, length + i);
					if (str1.equals(strTemp)) {
						str = str
								.substring(0, i)
								.concat(rep)
								.concat(str.substring(i + length, str.length()));
						i = i + length;
					} else {
						i++;
					}
				} else {
					i++;
				}

			}
		} else {
			str = "NA";
		}
		return str;
	}

	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}

	public static String replace(String strTemp, char rep) {
		String newStr = "";
		if ((str != null) && (!"".equals(str))) {
			int length = strTemp.length();
			int i = 0;
			while (i < str.length()) {
				if (str.charAt(i) == strTemp.charAt(0)) {
					String str1 = str.substring(i, length + i);
					if (str1.equals(strTemp)) {
						str = str.substring(0, i) + rep
								+ str.substring(i + length, str.length());
						i = i + length;
					} else {
						i++;
					}
				} else {
					i++;
				}

			}
		} else {
			str = "NA";
		}
		return str;
	}

	public static String replace(String strTemp, char rep, int a) {
		String newStr = "";
		if ((str != null) && (!"".equals(str))) {
			str = "";
		} else {
			str = "NA";
		}
		return str;
	}

	public static String replace1(String strTemp, char rep, int a) {
		String newStr = "";
		if ((str != null) && (!"".equals(str))) {
			str = "asd" + "sds";
		} else {
			str = "NA";
		}
		return str;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(String arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return 0;
	}
}
