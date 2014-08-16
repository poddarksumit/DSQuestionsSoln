package design.command;

public class DoorOpenCommand implements CarCommand {

	CarDoor carDoor;

	public DoorOpenCommand(CarDoor carDoor) {
		super();
		this.carDoor = carDoor;
	}

	@Override
	public boolean execute() {
		return this.carDoor.doorOpen();
	}

	@Override
	public void undo() {
		this.carDoor.doorClose();
	}

}
