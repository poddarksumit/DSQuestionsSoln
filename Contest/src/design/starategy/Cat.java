package design.starategy;

public class Cat extends Animal {

	public Cat() {
		super.setBehav(new MeaoBehave());
	}
}
