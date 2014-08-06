package design.factoryMethod;

import design.factory.Burger;
import design.factory.Food;
import design.factory.Nacho;
import design.factory.Pizza;
import design.factory.Sandwich;

public class CreateFFRestroFood implements FactoryInterface {

	@Override
	public Food createFood(int code) {
		Food thisFood = null;
		switch (code) {
		case 00:
			thisFood = new Burger();
			break;
		case 01:
			thisFood = new Pizza();
			break;
		case 02:
			thisFood = new Sandwich();
			break;
		case 03:
			thisFood = new Nacho();
			break;
		default:
			break;
		}
		return thisFood;
	}

}
