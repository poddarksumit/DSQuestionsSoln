package design.decorator;

public class SimpleChickenBurger extends Burger {

	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return "Simple burger + Chicken Patty + Onion + Tomato + Tomato Ketchup ";
	}

	@Override
	double getCost() {
		// TODO Auto-generated method stub
		return 7.5;
	}

}
