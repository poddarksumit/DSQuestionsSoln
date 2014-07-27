package thread;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Demo1 {

	private static final char COMMA = ',';

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "dm_davidgordonneutralbay@yahoo.com.au,David,Gordon,NSW,All Wines,,,,,,,,,m";
		 ArrayList<String> strSplit = splitPerComma(str);
		System.out.println(strSplit.size());

	}

	private static ArrayList<String> splitPerComma(String str) {
		ArrayList<String> strArray = new ArrayList<String>();
		int index = 0;
		String s = "";
		int indexCount = 0;
		int strSplitArray = 0;
		for (; index < str.length(); index++) {
			char ch = str.charAt(index);
			if (ch == COMMA) {
				strArray.add(str.substring(indexCount, index));
				if (index < str.length()) {
					indexCount = index + 1;
				}
			}
		}

		return strArray;
	}
}
