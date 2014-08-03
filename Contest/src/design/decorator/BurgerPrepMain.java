package design.decorator;

public class BurgerPrepMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Burger myBurger = new SimpleVegBuger();
		System.out.println(myBurger.getDescription());
		System.out.println(myBurger.getCost());
		myBurger = new SpicySimpleVeggieBurger(new SimpleVegBuger());
		System.out.println(myBurger.getDescription());
		System.out.println(myBurger.getCost());
		myBurger = new MaypFillBurger(new SimpleVegBuger());
		System.out.println(myBurger.getDescription());
		System.out.println(myBurger.getCost());
		myBurger = new MaypFillBurger(new SpicySimpleVeggieBurger(
				new SimpleVegBuger()));
		System.out.println(myBurger.getDescription());
		System.out.println(myBurger.getCost());
		myBurger = new SimpleChickenBurger();
		System.out.println(myBurger.getDescription());
		System.out.println(myBurger.getCost());
		myBurger = new SpicySalsaChicken(new SimpleChickenBurger());
		System.out.println(myBurger.getDescription());
		System.out.println(myBurger.getCost());

	}

}
