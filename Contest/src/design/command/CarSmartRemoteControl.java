package design.command;

import java.util.ArrayList;
import java.util.Stack;

public class CarSmartRemoteControl {

	private static ArrayList<CarCommand> carCommands = new ArrayList<CarCommand>();
	private static Stack<CarCommand> commandExecuted = new Stack<CarCommand>();

	public void addCarCommand(int index, CarCommand carCommand) {
		carCommands.add(index, carCommand);
	}

	public void removeCarCommand(int index) {
		carCommands.remove(index);
	}

	public boolean runCommand(int index) {
		System.out.println("index : " + index);
		return execute(index);
	}

	public boolean execute(int index) {
		if (carCommands.size() <= 0) {
			System.out.println("Car command empty.");
			return false;
		}

		if (index < 0 || carCommands.size() <= index) {
			System.out.println("Car command index invalid");
			return false;
		}
		if (carCommands.get(index).execute()) {
			commandExecuted.add(carCommands.get(index));
		}
		return true;
	}

	public void undo() {
		if (commandExecuted != null && !commandExecuted.isEmpty()) {
			commandExecuted.pop().undo();
		} else {
			System.out.println("No more undo command.");
		}
	}
}
