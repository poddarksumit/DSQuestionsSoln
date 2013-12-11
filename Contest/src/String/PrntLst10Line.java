package String;

public class PrntLst10Line {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer buff = new StringBuffer();
		buff.append("My name is Sumit.").append("My name is Sumit Kumar.")
				.append("My name is Sumit Kumar Poddar.");
		printLstLine(buff.toString(), 3);

	}

	public static void printLstLine(String strng, int lineNo) {
		char[] toChar = strng.toCharArray();
		int index = 0;
		int i = toChar.length - 2;
		for (; i >= 0; i--) {
			if (toChar[i] == '.') {
				index++;
			}
			if (index == lineNo) {
				break;
			}
		}
		System.out.println(strng.substring(i+1));
	}
}
