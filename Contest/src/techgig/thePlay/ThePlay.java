package techgig.thePlay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * N boys and M girls are learning acting skills from a theatre in Mumbai. To
 * perform a play on ‘Ramayana’ they need to form a group of P actors containing
 * not less than 4 boys and not less than 1 girl. The theatre requires you to
 * write a program that tells them the number of ways the group can be formed
 * 
 * Note: Composition should be unique and not the order in which the composition
 * is made of.
 * 
 * @author 394154 Version 1.0
 */
public class ThePlay {

	private static int output1[];
	private static final int minBoy = 4;
	private static final int minGirl = 1;
	private static final int minTeamSize = 5;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = 1;
		String testCaseDesc = "(7,6,8)";
		manipulatePlayerCount(testCase, testCaseDesc);
	}

	public static void manipulatePlayerCount(int testCase, String testCaseDesc) {

		TeamNumber teamNumber = setTeamDetails(testCase, testCaseDesc);
		int combinationalResult = 1;
		if (verifyInput(testCase, teamNumber)) {
			combinationalResult *= getCombinationResult(
					teamNumber.getTotalBoys(), minBoy);
			combinationalResult *= getCombinationResult(
					teamNumber.getTotalGirl(), minGirl);
			List<Integer> remTeamSize = getRemainingTeamSize(teamNumber);
			if ((!remTeamSize.isEmpty()) && (remTeamSize.get(0) != 0)) {
				combinationalResult *= getCombinationResult(remTeamSize.get(0),
						remTeamSize.get(1));
			}
			output1[0] = combinationalResult;
			System.out.println(Arrays.toString(output1));
		}
	}

	private static List<Integer> getRemainingTeamSize(TeamNumber teamNumber) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(teamNumber.getTotalTeam() - (minBoy + minGirl));
		list.add((teamNumber.getTotalBoys() - minBoy)
				+ (teamNumber.getTotalGirl() - minGirl));
		return list;

	}

	public static boolean verifyInput(int testCase, TeamNumber teamNumber) {
		output1 = new int[testCase];
		boolean isInputValid = true;
		int boy = teamNumber.getTotalBoys();
		int girl = teamNumber.getTotalGirl();
		int teamSize = teamNumber.getTotalTeam();
		if (boy < 4) {
			output1[0] = 1;
			isInputValid = false;
		} else if (girl < 1) {
			output1[0] = 2;
			isInputValid = false;
		} else if (teamSize < 5) {
			output1[0] = 3;
			isInputValid = false;
		}
		return isInputValid;
	}

	public static int getCombinationResult(int n, int r) {
		return (getFactorial(n)) / (getFactorial(r) * getFactorial(n - r));
	}

	public static int getFactorial(int input) {
		int factRes = 1 * input;
		int inputTemp = input;
		while (input > 1) {
			factRes = factRes * (input - 1);
			input--;
		}
		return factRes;
	}

	public static TeamNumber setTeamDetails(int testCase, String testCaseDesc) {
		Pattern pat = Pattern.compile("([0-9]+)|([0-9]+)");
		Matcher mat = pat.matcher(testCaseDesc);
		TeamNumber teamNumber = new TeamNumber();
		int i = 0;
		while (mat.find()) {
			int num = Integer.parseInt(mat.group());

			switch (i) {
			case 0:
				teamNumber.setTotalBoys(num);
				break;
			case 1:
				teamNumber.setTotalGirl(num);
				break;
			case 2:
				teamNumber.setTotalTeam(num);
				break;
			default:
				break;
			}
			i++;
		}
		return teamNumber;
	}
}

class TeamNumber {
	private int totalBoys;
	private int totalGirl;
	private int totalTeam;

	/**
	 * @return the totalBoys
	 */
	public int getTotalBoys() {
		return totalBoys;
	}

	/**
	 * @param totalBoys
	 *            the totalBoys to set
	 */
	public void setTotalBoys(int totalBoys) {
		this.totalBoys = totalBoys;
	}

	/**
	 * @return the totalGirl
	 */
	public int getTotalGirl() {
		return totalGirl;
	}

	/**
	 * @param totalGirl
	 *            the totalGirl to set
	 */
	public void setTotalGirl(int totalGirl) {
		this.totalGirl = totalGirl;
	}

	/**
	 * @return the totalTeam
	 */
	public int getTotalTeam() {
		return totalTeam;
	}

	/**
	 * @param totalTeam
	 *            the totalTeam to set
	 */
	public void setTotalTeam(int totalTeam) {
		this.totalTeam = totalTeam;
	}

}
