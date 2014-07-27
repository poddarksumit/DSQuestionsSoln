package thread;

import java.io.File;

public class MCRCompetitionSubsProcess implements Runnable {

	File myFile = null;
	Thread thread = null;

	public MCRCompetitionSubsProcess(File myFile) {
		super();
		this.myFile = myFile;
		this.thread = new Thread(myFile.getName());
		this.thread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}
