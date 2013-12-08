package techgig.escapeTheMaze;

/**
 * 
 * Consider a Maze consisting of big walls and rooms. You are trapped in that
 * maze. To escape, you can pass through the rooms but cannot pass through the
 * walls. You cannot break the wall to create a passage. You enter at one spot,
 * and exit at another. There is only one Entry point and Exit point in the Maze
 * and they can be at any position i.e. top, left, bottom, right in the Maze.
 * Your task is to try to escape the maze with minimum no. of rooms pass
 * through. You can move either Top, left, right, bottom directions but you
 * cannot move diagonally.
 * 
 * This class is used to Note : The array is represented as [0][0] where first
 * one is 'Y' and other as 'X'.
 * 
 * 
 * @author 394154 Version 1.0
 */
public class Maze {

	final static char X = 'X';
	final static char Y = 'Y';
	final static String ROOM_PASS = "P";
	final static String ROOM_WALL = "W";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Escape_Maze(1, "(3,3,{{S,P,E},{P,W,P},{P,P,P}})");
	}

	private static void Escape_Maze(int noOfTestCase, String testCaseDescription) {
		MazeDesign mazeDesign = new MazeDesign(testCaseDescription);
		process(mazeDesign);
	}

	private static void process(MazeDesign mazeDesign) {
		// Iterate through the array
		int xStart = mazeDesign.getStartXYPos().get(0);
		int xEnd = mazeDesign.getEndXYPos().get(0);
		int yStart = mazeDesign.getStartXYPos().get(1);
		int yEnd = mazeDesign.getEndXYPos().get(1);
		Direction xDirection = getDirection(xStart, xEnd);
		Direction yDirection = getDirection(yStart, yEnd);
		processFlowForX(xStart, xDirection, xEnd, mazeDesign, yStart);
	}

	private static void processFlowForX(int point, Direction direction,
			int xEnd, MazeDesign mazeDesign, int yPoint) {
		TrackFlowObject trackFlowObject = null;
		int xPoint;
		int sumOfMove = 0;
		try {
			for (Direction direc : Direction.values()) {
				switch (direc) {
				case RIGTH:
					xPoint = point + 1;
					for (; xPoint <= mazeDesign.getRow(); xPoint++) {
						if (mazeDesign.getMazeMatrix()[yPoint][xPoint] != null) {
							if (ROOM_PASS == mazeDesign.getMazeMatrix()[yPoint][xPoint]) {
								sumOfMove++;
								trackFlowObject = new TrackFlowObject();
								trackFlowObject.setDirection(direc);
								trackFlowObject.setSum(sumOfMove);
								trackFlowObject.setxPoint(xPoint);
								trackFlowObject.setyPoint(yPoint);
							} else {

							}
						}
					}
					break;
				case LEFT:
					xPoint = point - 1;
					for (; xPoint >= 0; xPoint--) {

					}
				default:
					// Do nothing.
					break;
				}

			}
		} catch (Exception exception) {

		}
	}

	private static Direction getDirection(int start, int end) {

		Direction direction = null;
		if (start > end) {
			direction = Direction.LEFT;
		} else if (start < end) {
			direction = Direction.RIGTH;
		} else {
			direction = Direction.SAME;
		}

		return direction;
	}
}

enum Direction {
	RIGTH("RIGTH"), LEFT("LEFT"), UP("UP"), DOWN("DOWN"), SAME("SAME");

	String direction;

	Direction(String direction) {
		this.direction = direction;
	}

	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

}