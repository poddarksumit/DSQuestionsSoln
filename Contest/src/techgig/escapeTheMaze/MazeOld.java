package techgig.escapeTheMaze;

import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class MazeOld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escape_Maze(1, "(3,3,{{S,P,E},{P,W,P},{P,P,P}})");
	}

	private static void Escape_Maze(int noOfTestCase, String testCaseDescription) {
		MazeDesignOld mazeDesign = new MazeDesignOld(testCaseDescription);
	}
}

class MazeDesignOld {

	int row;
	int column;
	Arrays[][] mazeMatrix;
	int horizontalLocOfEFromS;
	int verticalLoc;
	int tempHorizontalLoc;
	int tempVerticalLoc;
	final String MY_PATTERN_FOR_SIZE = "[0-9]";
	final String MY_PATTERN_FOR_SPACE = "\\s";
	final String MY_PATTERN_FOR_CORDINATES = "\\{{1}+\\D+\\}";
	HashMap<Integer, String> map = new HashMap<Integer, String>();

	MazeDesignOld(String testCaseDescription) {
		init();
		createMaze(testCaseDescription);
	}

	private void init() {
		map.put(1, MY_PATTERN_FOR_SPACE);
		map.put(2, MY_PATTERN_FOR_SIZE);
		map.put(3, MY_PATTERN_FOR_CORDINATES);
	}

	private void createMaze(String testCaseDescription) {
		// Logic to break the string using regex.
		Pattern pattern = Pattern.compile(MY_PATTERN_FOR_SIZE);
		Matcher matcher = pattern.matcher(testCaseDescription);
		// Check all occurance
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @param row
	 *            the row to set
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * @return the column
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @param column
	 *            the column to set
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * @return the mazeMatrix
	 */
	public Arrays[][] getMazeMatrix() {
		return mazeMatrix;
	}

	/**
	 * @param mazeMatrix
	 *            the mazeMatrix to set
	 */
	public void setMazeMatrix(Arrays[][] mazeMatrix) {
		this.mazeMatrix = mazeMatrix;
	}

	/**
	 * @return the horizontalLoc
	 */
	public int getHorizontalLoc() {
		return horizontalLocOfEFromS;
	}

	/**
	 * @param horizontalLoc
	 *            the horizontalLoc to set
	 */
	public void setHorizontalLoc(int horizontalLoc) {
		this.horizontalLocOfEFromS = horizontalLoc;
	}

	/**
	 * @return the verticalLoc
	 */
	public int getVerticalLoc() {
		return verticalLoc;
	}

	/**
	 * @param verticalLoc
	 *            the verticalLoc to set
	 */
	public void setVerticalLoc(int verticalLoc) {
		this.verticalLoc = verticalLoc;
	}

	/**
	 * @return the tempHorizontalLoc
	 */
	public int getTempHorizontalLoc() {
		return tempHorizontalLoc;
	}

	/**
	 * @param tempHorizontalLoc
	 *            the tempHorizontalLoc to set
	 */
	public void setTempHorizontalLoc(int tempHorizontalLoc) {
		this.tempHorizontalLoc = tempHorizontalLoc;
	}

	/**
	 * @return the tempVerticalLoc
	 */
	public int getTempVerticalLoc() {
		return tempVerticalLoc;
	}

	/**
	 * @param tempVerticalLoc
	 *            the tempVerticalLoc to set
	 */
	public void setTempVerticalLoc(int tempVerticalLoc) {
		this.tempVerticalLoc = tempVerticalLoc;
	}
}