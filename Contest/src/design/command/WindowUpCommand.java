package design.command;

public class WindowUpCommand implements CarCommand {

	CarWindow car;

	public WindowUpCommand(CarWindow car) {
		super();
		this.car = car;
	}

	@Override
	public boolean execute() {
		return this.car.windowUp();

	}

	@Override
	public void undo() {
		this.car.windowDown();

	}

}
