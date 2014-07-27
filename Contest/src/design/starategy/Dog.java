package design.starategy;

public class Dog extends Animal {

	public Dog() {
		super.setBehav(new BarkBehaviour());
	}
}
