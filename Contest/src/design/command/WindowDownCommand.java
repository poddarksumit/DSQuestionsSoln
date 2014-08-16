package design.command;

public class WindowDownCommand implements CarCommand {

	CarWindow car;

	public WindowDownCommand(CarWindow car) {
		super();
		this.car = car;
	}

	@Override
	public boolean execute() {
		return this.car.windowDown();
	}

	@Override
	public void undo() {
		car.windowUp();
	}

}
