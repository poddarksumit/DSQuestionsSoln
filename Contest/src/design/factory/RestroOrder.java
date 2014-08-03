package design.factory;

public class RestroOrder {

	public static void getFood(int code) {
		Food food = getFoodItem(code);
		if (food != null) {
			System.out.println(food.getName());
			System.out.println(food.getDescription());
		}

	}

	private static Food getFoodItem(int code) {
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
