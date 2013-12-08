/**
 * 
 */
package techgig.escapeTheMaze;

/**
 * This class is used to
 * 
 * @author Sumit 26-May-2012
 * 
 */
public class TrackFlowObject {

	private Direction direction;
	private int xPoint;
	private int yPoint;
	private int sum;

	public TrackFlowObject() {

	}

	public TrackFlowObject(Direction direction, int xPoint, int yPoint, int sum) {
		super();
		this.direction = direction;
		this.xPoint = xPoint;
		this.yPoint = yPoint;
		this.sum = sum;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public int getxPoint() {
		return xPoint;
	}

	public void setxPoint(int xPoint) {
		this.xPoint = xPoint;
	}

	public int getyPoint() {
		return yPoint;
	}

	public void setyPoint(int yPoint) {
		this.yPoint = yPoint;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

}
