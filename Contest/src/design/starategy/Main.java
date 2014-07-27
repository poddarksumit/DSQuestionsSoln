package design.starategy;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal animal = new Dog();
		System.out.println(animal.talk());
		
		animal = new Cat();
		System.out.println(animal.talk());
		
		animal = new WildCat();
		System.out.println(animal.talk());

	}

}
