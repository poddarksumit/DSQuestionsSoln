package design.decorator;

public class SpicySalsaChicken extends BurgerDecorator {

	Burger burger;

	public SpicySalsaChicken(Burger burger) {
		super();
		this.burger = burger;
	}

	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return this.burger.getDescription() + " + Salsa topping + Spicy sauce.";
	}

	@Override
	double getCost() {
		// TODO Auto-generated method stub
		return this.burger.getCost() + 2.12;
	}

}
