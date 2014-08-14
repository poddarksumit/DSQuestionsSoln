package design.command;

public class Car {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CarWindow carWindow = new CarWindow("Driver side window");
		WindowUpCommand upCmd = new WindowUpCommand(carWindow);
		upCmd.execute();
	}

}
