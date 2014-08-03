package design.decorator;

public class SimpleVegBuger extends Burger {

	@Override
	String getDescription() {
		// TODO Auto-generated method stub
		return "Burger + Onion + Veg Patty + Tomato Ketchup";
	}

	@Override
	double getCost() {
		// TODO Auto-generated method stub
		return 5.0;
	}

}
