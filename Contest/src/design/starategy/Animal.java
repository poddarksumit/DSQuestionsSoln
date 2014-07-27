package design.starategy;

public abstract class Animal {

	static TalkBehaviour behav = null;

	public TalkBehaviour getBehav() {
		return behav;
	}

	public void setBehav(TalkBehaviour behav) {
		this.behav = behav;
	}

	public static int numberOfLegs() {
		return 4;
	}

	public static int numberOfEyes() {
		return 2;
	}

	public static String talk(){
		return behav.talk();
	}
}
