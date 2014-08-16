package design.command;

public class Car {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CarSmartRemoteControl remoteCntrl = new CarSmartRemoteControl();
		carWindowSetUp(remoteCntrl);
		carDoorSetUp(remoteCntrl);
		// Run command
		remoteCntrl.undo();
		remoteCntrl.runCommand(0);
		remoteCntrl.undo();
		remoteCntrl.runCommand(1);
		remoteCntrl.undo();
		remoteCntrl.runCommand(0);
		remoteCntrl.undo();
		//remoteCntrl.runCommand(7);
		remoteCntrl.runCommand(4);
		
		remoteCntrl.undo();
		remoteCntrl.undo();
		remoteCntrl.runCommand(8);
		remoteCntrl.runCommand(12);
		remoteCntrl.runCommand(10);
		remoteCntrl.undo();
		remoteCntrl.undo();
	}

	private static void carDoorSetUp(CarSmartRemoteControl remoteCntrl) {
		CarDoor carDoor = new CarDoor("Driver Side Door");
		DoorOpenCommand openCommand = new DoorOpenCommand(carDoor);
		DoorCloseCommand closeCommand = new DoorCloseCommand(carDoor);
		remoteCntrl.addCarCommand(9, openCommand);
		remoteCntrl.addCarCommand(10, closeCommand);
		carDoor = new CarDoor("Co Driver Side Door");
		openCommand = new DoorOpenCommand(carDoor);
		closeCommand = new DoorCloseCommand(carDoor);
		remoteCntrl.addCarCommand(11, openCommand);
		remoteCntrl.addCarCommand(12, closeCommand);
		carDoor = new CarDoor("Co Driver Side Back Door");
		openCommand = new DoorOpenCommand(carDoor);
		closeCommand = new DoorCloseCommand(carDoor);
		remoteCntrl.addCarCommand(13, openCommand);
		remoteCntrl.addCarCommand(14, closeCommand);
		carDoor = new CarDoor(" Driver Side Back Door");
		openCommand = new DoorOpenCommand(carDoor);
		closeCommand = new DoorCloseCommand(carDoor);
		remoteCntrl.addCarCommand(15, openCommand);
		remoteCntrl.addCarCommand(16, closeCommand);
	}

	private static void carWindowSetUp(CarSmartRemoteControl remoteCntrl) {
		// Driver Side Window.
		CarWindow carWindow = new CarWindow("Driver side window");
		WindowUpCommand upCmd = new WindowUpCommand(carWindow);
		remoteCntrl.addCarCommand(0, upCmd);
		WindowDownCommand downCmd = new WindowDownCommand(carWindow);
		remoteCntrl.addCarCommand(1, downCmd);
		// Co Driver Side Window.
		carWindow = new CarWindow("Co Driver side window");
		upCmd = new WindowUpCommand(carWindow);
		remoteCntrl.addCarCommand(2, upCmd);
		downCmd = new WindowDownCommand(carWindow);
		remoteCntrl.addCarCommand(3, downCmd);
		// Co Driver Back Side Window.
		carWindow = new CarWindow("Co Driver Back side window");
		upCmd = new WindowUpCommand(carWindow);
		remoteCntrl.addCarCommand(4, upCmd);
		downCmd = new WindowDownCommand(carWindow);
		remoteCntrl.addCarCommand(5, downCmd);
		// Driver Back Side Window.
		carWindow = new CarWindow("Driver Back side window");
		upCmd = new WindowUpCommand(carWindow);
		remoteCntrl.addCarCommand(6, upCmd);
		downCmd = new WindowDownCommand(carWindow);
		NoWindowCommand noWindw = new NoWindowCommand();
		remoteCntrl.addCarCommand(7, noWindw);
		remoteCntrl.addCarCommand(8, downCmd);
	}
}
