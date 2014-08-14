package design.command;

public class WindowDownCommand implements CarCommand {

	CarWindow car;

	public WindowDownCommand(CarWindow car) {
		super();
		this.car = car;
	}

	@Override
	public void execute() {
		car.windowDown();
	}

}
