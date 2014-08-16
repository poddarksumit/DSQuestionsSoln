package design.command;

public class CarDoor {
	private String carDoor = "";
	private int doorStatus = 0;

	public CarDoor(String carDoor) {
		super();
		this.carDoor = carDoor;
	}

	/**
	 * @return the carDoor
	 */
	public String getCarDoor() {
		return carDoor;
	}

	/**
	 * @param carDoor
	 *            the carDoor to set
	 */
	public void setCarDoor(String carDoor) {
		this.carDoor = carDoor;
	}

	/**
	 * @return the doorStatus
	 */
	public int getDoorStatus() {
		return doorStatus;
	}

	/**
	 * @param doorStatus
	 *            the doorStatus to set
	 */
	public void setDoorStatus(int doorStatus) {
		this.doorStatus = doorStatus;
	}

	public boolean doorOpen() {
		if (doorStatus == 1) {
			System.out.println("Door - " + this.carDoor + " is already open.");
			return false;
		} else {
			doorStatus = 1;
			System.out.println("Door - " + this.carDoor + " is open now.");
			return true;
		}
	}

	public boolean doorClose() {
		if (doorStatus == 0) {
			System.out.println("Door - " + this.carDoor + " is already close.");
			return false;
		} else {
			doorStatus = 0;
			System.out.println("Door - " + this.carDoor + " is close now.");
			return true;
		}
	}

}
