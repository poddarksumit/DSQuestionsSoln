package design.factoryMethod;

import design.factory.Food;

public class FactoryMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FactoryInterface fctoryInterface = new CreateFFRestroFood();
		Food food = fctoryInterface.createFood(01);
		System.out.println(food.getName());
		System.out.println(food.getDescription());
		fctoryInterface = new CreateIndianRestroFood();
		food = fctoryInterface.createFood(01);
		System.out.println(food.getName());
		System.out.println(food.getDescription());

	}
}
