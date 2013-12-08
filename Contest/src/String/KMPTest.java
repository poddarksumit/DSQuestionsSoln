package String;

public class KMPTest {
	public static void main(String[] args) {
		KnuthMorrisPratt k = new KnuthMorrisPratt();
		/*
		 * String text = "Lorem ipsum dolor sit amet"; String pattern = "ipsum";
		 */

		String text = "This test text";
		String pattern = "ababca";

		int first_occur_position = k.kmp(text, pattern);
		System.out.println("The text '" + pattern + "' is first found on the "
				+ first_occur_position + " position.");
	}
}
