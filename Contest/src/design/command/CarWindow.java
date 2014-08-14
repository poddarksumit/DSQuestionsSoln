package design.command;

public class CarWindow {

	private String windowName = "";

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
	 * @param windowName
	 *            the windowName to set
	 */
	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public void windowUp() {
		System.out.println("Window " + getWindowName() + " is growing up.");
	}

	public void windowDown() {
		System.out.println("Window " + getWindowName() + " is growing down.");
	}
}
