package techgig.escapeTheMaze;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to
 * 
 * @author 394154 Version 1.0
 */
public class MazeDesign {

	private int row;
	private int column;
	private String[][] mazeMatrix;
	private List<Integer> startXYPos;
	private List<Integer> endXYPos;
	private int horizontalLocOfEFromS;
	private int verticalLocEFromS;
	private int tempHorizontalLoc;
	private int tempVerticalLoc;

	MazeDesign(String testCaseDescription) {
		createMaze(testCaseDescription);
	}

	private void createMaze(String testCaseDescription) {
		// Logic to break the string using regex.
		setRow(3);
		setColumn(3);
		setHorizontalLocOfEFromS(3);
		setVerticalLocEFromS(3);
		setTempHorizontalLoc(3);
		setTempVerticalLoc(3);
		mazeMatrix = new String[3][3];
		mazeMatrix[0][0] = "S";
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(0);
		setStartXYPos(list);
		mazeMatrix[0][1] = "P";
		mazeMatrix[0][2] = "E";
		list = new ArrayList<Integer>();
		list.add(0);
		list.add(2);
		setEndXYPos(list);
		mazeMatrix[1][0] = "P";
		mazeMatrix[1][1] = "W";
		mazeMatrix[1][2] = "P";
		mazeMatrix[2][0] = "P";
		mazeMatrix[2][1] = "P";
		mazeMatrix[2][2] = "P";
		setMazeMatrix(mazeMatrix);
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
	public String[][] getMazeMatrix() {
		return mazeMatrix;
	}

	/**
	 * @param mazeMatrix
	 *            the mazeMatrix to set
	 */
	public void setMazeMatrix(String[][] mazeMatrix) {
		this.mazeMatrix = mazeMatrix;
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

	/**
	 * @return the startXYPos
	 */
	public List<Integer> getStartXYPos() {
		return startXYPos;
	}

	/**
	 * @param startXYPos
	 *            the startXYPos to set
	 */
	public void setStartXYPos(List<Integer> startXYPos) {
		this.startXYPos = startXYPos;
	}

	/**
	 * @return the enXYPos
	 */
	public List<Integer> getEndXYPos() {
		return endXYPos;
	}

	/**
	 * @param enXYPos
	 *            the enXYPos to set
	 */
	public void setEndXYPos(List<Integer> endXYPos) {
		this.endXYPos = endXYPos;
	}

	/**
	 * @return the horizontalLocOfEFromS
	 */
	public int getHorizontalLocOfEFromS() {
		return horizontalLocOfEFromS;
	}

	/**
	 * @param horizontalLocOfEFromS
	 *            the horizontalLocOfEFromS to set
	 */
	public void setHorizontalLocOfEFromS(int horizontalLocOfEFromS) {
		this.horizontalLocOfEFromS = horizontalLocOfEFromS;
	}

	/**
	 * @return the verticalLocEFromS
	 */
	public int getVerticalLocEFromS() {
		return verticalLocEFromS;
	}

	/**
	 * @param verticalLocEFromS
	 *            the verticalLocEFromS to set
	 */
	public void setVerticalLocEFromS(int verticalLocEFromS) {
		this.verticalLocEFromS = verticalLocEFromS;
	}

}
