package design.command;

public class DoorCloseCommand implements CarCommand {
	CarDoor carDoor;

	public DoorCloseCommand(CarDoor carDoor) {
		super();
		this.carDoor = carDoor;
	}

	@Override
	public boolean execute() {
		return this.carDoor.doorClose();

	}

	@Override
	public void undo() {
		this.carDoor.doorOpen();

	}

}
