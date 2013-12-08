/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 09-Mar-2013
 * 
 */
public class DivideString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getNPart("geegks", 3);
	}

	public static void getNPart(String s, int n) {
		int midIndex = s.length() / n;
		int i = 0;
		if ((s.length() % n) == 0) {
			int statIndex = -1;
			int inddex = 0;
			char[] c = new char[midIndex];
			for (; i < s.length(); i++) {
				c[inddex] = s.charAt(i);
				inddex++;
				if (i == statIndex + midIndex) {
					System.out.println(new String(c));
					statIndex = i;
					c = new char[midIndex];
					inddex = 0;
				}
			}
		} else {
			System.out.println("Cannot be divided into equal parts");
		}
	}
}
