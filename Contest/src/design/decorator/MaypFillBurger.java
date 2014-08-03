package design.decorator;

public class MaypFillBurger extends BurgerDecorator {

	Burger burger;

	public MaypFillBurger(Burger burger) {
		super();
		this.burger = burger;
	}

	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return this.burger.getDescription() + " Mayo Filled + Chat Masala.";
	}

	@Override
	double getCost() {
		// TODO Auto-generated method stub
		return this.burger.getCost() + 2.5;
	}

}
