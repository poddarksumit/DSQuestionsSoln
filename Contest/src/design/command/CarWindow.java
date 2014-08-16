package design.command;

import java.util.Stack;

public class CarWindow {

	private String windowName = "";
	private int state = 1;

	/**
	 * @return the windowName
	 */
	public String getWindowName() {
		return windowName;
	}

	public CarWindow(String windowName) {
		super();
		this.windowName = windowName;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @param windowName
	 *            the windowName to set
	 */
	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public boolean windowUp() {
		if (this.state == 1) {
			System.out.println("Window - " + getWindowName()
					+ " is already up.");
			return false;
		} else {
			System.out.println("Window - " + getWindowName() + " is going up.");
			this.state = 1;
			return true;
		}
	}

	public boolean windowDown() {
		if (this.state == 0) {
			System.out.println("Window - " + getWindowName()
					+ " is already down.");
			return false;
		} else {
			System.out.println("Window - " + getWindowName()
					+ " is going down.");
			this.state = 0;
			return true;
		}
	}
}
