package design.command;

public class NoWindowCommand implements CarCommand {

	@Override
	public boolean execute() {
		return false;

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
