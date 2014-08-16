package design.command;

public interface CarCommand {
	boolean execute();

	void undo();
}
