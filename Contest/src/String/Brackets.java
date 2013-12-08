/**
 * 
 */
package String;

/**
 * This class is used to
 * 
 * @author Sumit 15-Mar-2013
 * 
 */
public class Brackets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPattern("([[{(x}]]y)"));
	}

	public static boolean checkPattern(String str) {
		boolean isPaternCorrect = true;
		int[] i = initArray(str.length()); // {
		int[] j = initArray(str.length()); // (
		int[] k = initArray(str.length()); // [
		int[] recent = initArray(str.length());
		int iIndex = 0, jIndex = 0, kIndex = 0, strIndex = 0, recentIndex = 0;
		while ((isPaternCorrect) && (strIndex < str.length())) {
			char a = str.charAt(strIndex);
			switch (a) {
			case '{':
				i[iIndex] = strIndex;
				iIndex++;
				recent[recentIndex] = strIndex;
				recentIndex++;
				break;
			case '[':
				k[kIndex] = strIndex;
				kIndex++;
				recent[recentIndex] = strIndex;
				recentIndex++;
				break;
			case '(':
				j[jIndex] = strIndex;
				jIndex++;
				recent[recentIndex] = strIndex;
				recentIndex++;
				break;
			case ')':
				if (j[jIndex - 1] > -1) {
					if (recent[recentIndex - 1] != j[jIndex - 1]) {
						isPaternCorrect = false;

					} else {
						recent[recentIndex - 1] = -1;
						recentIndex--;
						j[jIndex - 1] = -1;
						jIndex--;
					}
				} else {
					isPaternCorrect = false;
				}
				break;
			case '}':
				if (i[iIndex - 1] > -1) {
					if (recent[recentIndex - 1] != i[iIndex - 1]) {
						isPaternCorrect = false;
					} else {
						recent[recentIndex - 1] = -1;
						recentIndex--;
						i[iIndex - 1] = -1;
						iIndex--;
					}
				} else {
					isPaternCorrect = false;
				}
				break;
			case ']':
				if (k[kIndex - 1] > -1) {
					if (recent[recentIndex - 1] != k[kIndex - 1]) {
						isPaternCorrect = false;

					} else {
						recent[recentIndex - 1] = -1;
						recentIndex--;
						k[kIndex - 1] = -1;
						kIndex--;
					}
				} else {
					isPaternCorrect = false;
				}
				break;
			default:
				break;
			}
			strIndex++;
		}
		return isPaternCorrect;
	}

	public static int[] initArray(int size) {
		int[] a = new int[size];
		for (int i = 0; i < size; i++) {
			a[i] = -1;
		}
		return a;
	}
}
