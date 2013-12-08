package techgig.escapeTheMaze;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class RegexTestPatternMatcher {
	public static final String EXAMPLE_TEST = "(3,3,{{S,P,E},{P,W,P},{P,P,P}})";

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("((`\\{)+\\{+[A-Z],[A-Z],[A-Z]+\\})");
		// In case you would like to ignore case sensitivity you could use this
		// statement.
		// Pattern pattern = Pattern.compile("\\s+",
		// Pattern.CASE_INSENSITIVE);34 e
		String[] splitString = (EXAMPLE_TEST.split("[A-Z],[A-Z],[A-Z]"));
		System.out.println(Arrays.toString(splitString));
		System.out.println(splitString.length);// Should be 14
		for (String string : splitString) {
			System.out.println(string);
		}
		Matcher matcher = pattern.matcher(EXAMPLE_TEST);
		// Check all occurance
		while (matcher.find()) {
			System.out.print("Start index: " + matcher.start());
			System.out.print(" End index: " + matcher.end() + " ");
			// System.out.println(matcher.group());
			String m = matcher.group();
			Pattern pat = Pattern.compile("[A-Z]{1,}");
			Matcher mat = pat.matcher(m);
			while (mat.find()) {
				System.out.print("Start index: " + matcher.start());
				System.out.print(" End index: " + matcher.end() + " ");
				System.out.println(matcher.group());
			}
		}
		// Now create a new pattern and matcher to replace whitespace with tabs
		Pattern replace = Pattern.compile("\\s+");
		Matcher matcher2 = replace.matcher(EXAMPLE_TEST);
		System.out.println(matcher2.replaceAll("\t"));
	}
}
