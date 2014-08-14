package design.command;

public class WindowUpCommand implements CarCommand {

	CarWindow car;

	public WindowUpCommand(CarWindow car) {
		super();
		this.car = car;
	}

	@Override
	public void execute() {
		this.car.windowUp();

	}

}
