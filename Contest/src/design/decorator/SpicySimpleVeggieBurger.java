package design.decorator;

public class SpicySimpleVeggieBurger extends BurgerDecorator {

	Burger thisBurger;

	public SpicySimpleVeggieBurger(Burger thisBurger) {
		super();
		this.thisBurger = thisBurger;
	}

	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return thisBurger.getDescription() + "BBQ Ketchup + Lenthils";
	}

	@Override
	double getCost() {
		// TODO Auto-generated method stub
		return thisBurger.getCost() + 2.0;
	}

}
